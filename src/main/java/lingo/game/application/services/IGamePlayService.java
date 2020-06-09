package lingo.game.application.services;

import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IGamePlayService {
    public Game startWithRandomWord() throws IOException, URISyntaxException;
    public Game start(Word word) throws IOException, URISyntaxException;
    public Game nextRound(String gameKey) throws IOException, URISyntaxException;
    //public void printCurrentGame(String gameKey);
    //public String getCurrentGameStringFormat(String gameKey);
    public Game getCurrentGame(String gameKey);
    public Game guessWord(String gameKey, String playersWord) throws IOException, URISyntaxException ;
}
