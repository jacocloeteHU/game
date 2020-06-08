package lingo.game.application.gameplay;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IWordValidator {
    public boolean evaluateWord(String word) throws IOException, URISyntaxException;
}
