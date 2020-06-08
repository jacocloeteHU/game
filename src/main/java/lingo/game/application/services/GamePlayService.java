package lingo.game.application.services;

import lingo.game.application.gameplay.IWordValidator;
import lingo.game.application.gameplay.WordValidator;
import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;
import lingo.game.domain.services.IGameService;
import lingo.game.domain.services.IRoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
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

    public boolean startWithRandomWord() throws IOException, URISyntaxException {
        return start(wordSourceService.generateNewWord());
    }

    public boolean start(Word word) throws IOException, URISyntaxException {
        Round round = roundService.createRound(10, 5, word);
        gameService.start(round);
        return true;
    }

    public void printCurrentGame(){
        System.out.println("Score:" + gameService.getGame().getScore());
        int roundSize = gameService.getGame().getRounds().size();
        System.out.println("Round:" + roundSize);
        System.out.println("Turns left:" + gameService.getGame().getCurrentRound().getTurn() +  "/5");
        System.out.println("Time left:"  + gameService.getGame().getCurrentRound().getTimer());
        System.out.println("To guess word:" + gameService.getGame().getCurrentRound().getWord());
        System.out.println("Game word parts with placehodler:" + gameService.getGame().getCurrentRound().getWordPartWithPlaceholder());
        System.out.println("Game word parts:" + gameService.getGame().getCurrentRound().getWordParts());
    }

    // vanuit round kun je meer showen dus ook feedback
    public Round guessWord(String playersWord) throws IOException, URISyntaxException {
        IWordValidator wordValidator = new WordValidator();
        int roundSize = gameService.getGame().getRounds().size();
        Round currentRound =gameService.getGame().getCurrentRound();
        boolean wordCorrect = false;
        currentRound = turnService.evaluateGuessedWord(currentRound, playersWord);
        wordCorrect = currentRound.getFeedback().isWordValidState();

        checkRoundState(wordCorrect);
        return currentRound;
    }

    private void checkRoundState(boolean wordCorrect) throws IOException, URISyntaxException {
        int turn = gameService.getGame().getCurrentRound().getTurn();
        if(wordCorrect == true){
            Round round = roundService.createRound( 10, 5, wordSourceService.generateNewWord());
            gameService.getGame().addScore(turn);
            Game game = gameService.nextRound(round);
        } else {
            if(turn == 5){
                start(wordSourceService.generateNewWord());
            } else {
                gameService.getGame().getCurrentRound().nextTurn();
            }

        }
        //printCurrentGame();
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
