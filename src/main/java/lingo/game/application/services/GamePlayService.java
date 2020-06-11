package lingo.game.application.services;

import lingo.game.application.validation.IWordValidator;
import lingo.game.application.validation.WordValidator;
import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Turn;
import lingo.game.domain.model.Word;
import lingo.game.domain.services.IGameService;
import lingo.game.domain.services.IRoundService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

@Component
public class GamePlayService implements IGamePlayService {
    @Autowired
    IGameService gameService;
    @Autowired
    IRoundService roundService;
    @Autowired TurnService turnService;
    @Autowired
    WordSourceService wordSourceService;
    @Autowired
    IWordValidator wordValidator;
    public GamePlayService(){

    }

    public Game start() throws IOException, URISyntaxException {
        return start(wordSourceService.generateNewWord(5));
    }

    public Game start(Word word) throws IOException, URISyntaxException {
        Round round = roundService.createRound(word, new Turn(1,10));
        Game game = gameService.create(round);
        game.setGameKey(RandomStringUtils.randomAlphanumeric(10));
        return game;
    }

    public Game nextRound(String gameKey) throws IOException, URISyntaxException {
        Game game = gameService.findGame(new Game(gameKey));
        Round currentRound =gameService.findGame(game).getRound();
        int turnIndex = currentRound.getTurns().size();
        if (turnIndex >= 5) {
            gameService.findGame(game).reset();
        }
        Round round = roundService.createRound( wordSourceService.generateNewWord(game.getWordLength()), new Turn( 1,10));
        gameService.addRound(game, round);
        return gameService.findGame(game);
    }

    public Game getCurrentGame(String gameKey){
        Game game = new Game(gameKey);
        return gameService.findGame(game);
    }

    // vanuit round kun je meer showen dus ook feedback
    public Game guessWord(String gameKey, String playersWord, Date timePushed) throws IOException, URISyntaxException {
        Game game = gameService.findGame(new Game(gameKey));
        Round currentRound = game.getRound();
        int turnIndex = currentRound.getTurns().size() - 1;
        if (!currentRound.isActive()) {
            return game;
        } else {
            currentRound.getTurns().get(turnIndex).setPlayerInput(playersWord);
            currentRound = turnService.evaluateGuessedWord(currentRound, playersWord, turnIndex, timePushed);
            gameService.findGame(game).setRound(currentRound);
            return checkRoundState(game, currentRound.getTurns().get(turnIndex).getFeedback().isWordCorrect(), turnIndex);
        }
    }

    private Game checkRoundState(Game game, boolean wordCorrect, int turnIndex) throws IOException, URISyntaxException {
        if(wordCorrect == true){
            gameService.findGame(game).addScore(turnIndex);
            gameService.findGame(game).addWordLength();
            gameService.findGame(game).getRound().setActive(false);
        } else {
            if (turnIndex < 4) {
                gameService.findGame(game).getRound().addTurn(new Turn(turnIndex +2, 10));
            } else {
                gameService.findGame(game).getRound().setActive(false);
            }
        }

        return gameService.findGame(game);
    }
}