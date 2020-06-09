package lingo.game.application.services;

import lingo.game.application.gameplay.IWordValidator;
import lingo.game.application.gameplay.WordValidator;
import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Turn;
import lingo.game.domain.model.Word;
import lingo.game.domain.services.GameService;
import lingo.game.domain.services.IGameService;
import lingo.game.domain.services.IRoundService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Component
public class GamePlayService implements IGamePlayService {
    @Autowired
    IGameService gameService;
    @Autowired
    IRoundService roundService;
    @Autowired TurnService turnService;
    @Autowired
    WordSourceService wordSourceService;
    public GamePlayService(){

    }

    public Game startWithRandomWord() throws IOException, URISyntaxException {
        return start(wordSourceService.generateNewWord());
    }

    public Game start(Word word) throws IOException, URISyntaxException {
        Round round = roundService.createRound(word, new Turn(1,10));
        Game game = gameService.start(round);
        game.setGameKey(RandomStringUtils.randomAlphanumeric(10));
        return game;
    }

    public Game nextRound(String gameKey) throws IOException, URISyntaxException {
        Game game = gameService.findGame(new Game(gameKey));
        Round round = roundService.createRound( wordSourceService.generateNewWord(), new Turn( 1,10));
        gameService.nextRound(game, round);
        gameService.findGame(game).setRound(round);
        return gameService.findGame(game);
    }

/*    public void printCurrentGame(String gameKey){
   //     Game game = new Game(gameKey);
 ////       System.out.println("Score:" + gameService.findGame(game).getScore());
      //  int roundSize = gameService.findGame(game).getRounds().size();
    //    System.out.println("Round:" + roundSize);
  //      System.out.println("Turns left:" + gameService.findGame(game).getCurrentRound().getTurn() +  "/5");
    //    System.out.println("Time left:"  + gameService.findGame(game).getCurrentRound().getTimer());
    //    System.out.println("To guess word:" + gameService.findGame(game).getCurrentRound().getWord());
   //     System.out.println("Game word parts with placehodler:" + gameService.findGame(game).getCurrentRound().getWordPartWithPlaceholder());
   //     System.out.println("Game word parts:" + gameService.findGame(game).getCurrentRound().getWordParts());
    }*/

    public Game getCurrentGame(String gameKey){
        Game game = new Game(gameKey);
        return gameService.findGame(game);
    }

/*
    public String getCurrentGameStringFormat(String gameKey){
        Game game = new Game(gameKey);
        game = gameService.findGame(game);
        Round round = game.getRound();
        String printString = "Game:" + game.getGameKey()+ "\tScore:" + game.getScore();
        String grid = "\n%s \t %s \t %s \t %s \t %s";
        printString += String.format(grid,"Beurt", "Te raden", "Gegeven", "Raadbeurt", "Feedback");
      //  for(int i=0;i<round.getTurn(); i++){
     //       printString += String.format(grid,i+1, round.getWord().getWord(), round.getWordPartWithPlaceholder(), round.getPlayerGuessesByIndex(i), round.getFeedback().get(i).getFeedback());
        }
      /  return printString;
    }
*/

    // vanuit round kun je meer showen dus ook feedback
    public Game guessWord(String gameKey, String playersWord) throws IOException, URISyntaxException {
        Game game = new Game(gameKey);
        IWordValidator wordValidator = new WordValidator();
        Round currentRound =gameService.findGame(game).getRound();
        int turnIndex = currentRound.getTurns().size() - 1;
        currentRound.getTurns().get(turnIndex).setPlayerInput(playersWord);
        currentRound = turnService.evaluateGuessedWord(currentRound, playersWord, turnIndex);
        ArrayList<Integer> correctLetters = currentRound.getTurns().get(turnIndex).getFeedback().getCorrectLettersIndex();
        gameService.findGame(game).getRound().setWordPartsIndexes(correctLetters);
        boolean wordCorrect = currentRound.getTurns().get(turnIndex).getFeedback().isWordValidState();
        gameService.findGame(game).setRound(currentRound);
        return checkRoundState(game ,wordCorrect, turnIndex);
    }

    private Game checkRoundState(Game game, boolean wordCorrect, int turnIndex) throws IOException, URISyntaxException {
        if(wordCorrect == true){
       //
            gameService.findGame(game).addScore(turnIndex);
            //
        } else {
            if(turnIndex >= 5){
                Round round = roundService.createRound(wordSourceService.generateNewWord(), new Turn(1,10));
                gameService.findGame(game).addScore(turnIndex);
                gameService.nextRound(game, round);

                // dit moet anders
            } else {
               //game = gameService.findGame(game);
                gameService.findGame(game).getRound().addTurn(new Turn(turnIndex +2, 10));
            }
        }

        return gameService.findGame(game);
    }

/*    public Round evaluateGuessedWord(Round round, String guessWord){
        Word word = round.getWord();
        IFeedbackCreator feedbackCreator = new TurnFeedback();
        Feedback feedback = feedbackCreator.evolveWord(word, round.getWordParts(), guessWord);
        round.setFeedback(feedback);
        return round;
        //  return round.getWord().equals(guessWord);
    }*/

    public void PrintHighscore(){

    }

    public void Printscore(){

    }


}
