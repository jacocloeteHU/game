package lingo.game.application.validation;

import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface IWordValidator {
    boolean validateWord(String word) throws IOException, URISyntaxException;
    boolean validateWordsForFeedback(ArrayList<Integer> givenPartsIndex, String roundWord, String playersWord) throws IOException, URISyntaxException;
    boolean wordCorrectCheck(Word roundWord, String playersWord);
}
