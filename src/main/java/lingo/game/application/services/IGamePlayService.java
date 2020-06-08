package lingo.game.application.services;

import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IGamePlayService {
    public boolean start(Word word) throws IOException, URISyntaxException;
    public void printCurrentGame();
    public Round guessWord(String playersWord) throws IOException, URISyntaxException ;
}
