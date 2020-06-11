package lingo.game.application.validation;

import lingo.game.application.validation.IWordValidator;
import lingo.game.application.validation.WordValidator;
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
        Assertions.assertEquals(true, wordValidator.validateWord("aanzien"));
        Assertions.assertEquals(true, wordValidator.validateWord("email"));
        Assertions.assertEquals(true, wordValidator.validateWord("smeer"));
    }

    @Test
    @DisplayName("not valid or not real words test")
    public void validateNotRealWordTest() throws IOException, URISyntaxException {
        Assertions.assertEquals(false ,wordValidator.validateWord("Aanzien"));
        Assertions.assertEquals(false ,wordValidator.validateWord("aanzien1"));
        Assertions.assertEquals(false ,wordValidator.validateWord("aan"));
        Assertions.assertEquals(false ,wordValidator.validateWord("aan-zien"));
        Assertions.assertEquals(false ,wordValidator.validateWord("e-mail"));
    }

    @Test
    @DisplayName("not valid or not real words test")
    public void validateWordsForFeedback() throws IOException, URISyntaxException {
        ArrayList<Integer> wordPartIndex = new ArrayList<Integer>();
        wordPartIndex.add(0);
        wordPartIndex.add(1);
        Assertions.assertEquals(true ,wordValidator.validateWordsForFeedback(wordPartIndex,"staan","stond"));
        Assertions.assertEquals(false ,wordValidator.validateWordsForFeedback(wordPartIndex,"staan","slank"));
    }
}