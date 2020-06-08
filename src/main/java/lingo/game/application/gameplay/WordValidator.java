package lingo.game.application.gameplay;

import lingo.game.domain.model.IWordSource;
import lingo.game.domain.model.Word;
import lingo.game.infrastructure.source.ApiWordSource;

import java.io.IOException;
import java.net.URISyntaxException;

public class WordValidator implements IWordValidator {

    @Override
    public boolean evaluateWord(String word) throws IOException, URISyntaxException {
        if(validGameWordCheck(word)){
            return realWordCheck(word);
        } else {
            return false;
        }
    }

    private boolean realWordCheck(String word) throws IOException, URISyntaxException {
        IWordSource wordSource = new ApiWordSource("https://lingo-words.herokuapp.com");
        boolean validWord = wordSource.checkWord(word);
        return validWord;
    }

    public boolean validGameWordCheck(String word) {
        return word.matches("^[a-z]{5,7}+$");
    }
}
