package lingo.game.application.services;

import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;
import lingo.game.domain.services.IGameService;
import lingo.game.domain.services.IRoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
@Service
public class GamePlayService {
    @Autowired
    IGameService gameService;
    @Autowired
    IRoundService roundService;

    public GamePlayService(){

    }

    public boolean start() throws IOException, URISyntaxException {
        Round round = roundService.createRound(10, 5);
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

    public void guessWord(String playersWord) throws IOException, URISyntaxException {
        int roundSize = gameService.getGame().getRounds().size();
        Round currentRound =gameService.getGame().getCurrentRound();
        Round round = roundService.evaluateGuessedWord(currentRound, playersWord);
        boolean wordCorrect = round.getFeedback().isWordValidState();
        checkRoundState(wordCorrect);
    }

    private void checkRoundState(boolean wordCorrect) throws IOException, URISyntaxException {
        if(wordCorrect == true){
            Round round = roundService.createRound(10, 5);
            Game game = gameService.nextRound(round);
        } else {
            gameService.getGame().getCurrentRound().nextTurn();
        }
        printCurrentGame();
    }

    public void PrintHighscore(){

    }

    public void Printscore(){

    }


}
