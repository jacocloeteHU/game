package lingo.game.application.validation;

import lingo.game.application.validation.IWordValidator;
import lingo.game.application.validation.WordValidator;
import lingo.game.domain.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class WordValidatorTest {

    private final IWordValidator wordValidator = new WordValidator();
    public WordValidatorTest() {

    }

    @Test
    @DisplayName("Valid and real words test")
    public void validateRealWordTest() throws IOException, URISyntaxException {
        Assertions.assertTrue(wordValidator.validateWord("aanzien"));
        Assertions.assertTrue(wordValidator.validateWord("email"));
        Assertions.assertTrue(wordValidator.validateWord("smeer"));
    }

    @Test
    @DisplayName("not valid or not real words test")
    public void validateNotRealWordTest() throws IOException, URISyntaxException {
        Assertions.assertFalse(wordValidator.validateWord("Aanzien"));
        Assertions.assertFalse(wordValidator.validateWord("aanzien1"));
        Assertions.assertFalse(wordValidator.validateWord("aan"));
        Assertions.assertFalse(wordValidator.validateWord("aan-zien"));
        Assertions.assertFalse(wordValidator.validateWord("e-mail"));
    }

    @Test
    @DisplayName("not valid or not real words test")
    public void validateWordsForFeedback() throws IOException, URISyntaxException {
        ArrayList<Integer> wordPartIndex = new ArrayList<Integer>();
        wordPartIndex.add(0);
        wordPartIndex.add(1);
        Assertions.assertTrue(wordValidator.validateWordsForFeedback(wordPartIndex, "staan", "stond"));
        Assertions.assertFalse(wordValidator.validateWordsForFeedback(wordPartIndex, "staan", "slank"));
    }

    @Test
    @DisplayName("Valid and real words test")
    public void correctWordTest() throws IOException, URISyntaxException {
        Assertions.assertTrue(wordValidator.wordCorrectCheck(new Word("aanzien"),"aanzien"));
    }
}