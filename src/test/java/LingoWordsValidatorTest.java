
import lingo.game.application.gameplay.IWordValidator;
import lingo.game.application.gameplay.WordValidator;
import lingo.game.domain.model.IWordSource;
import lingo.game.domain.model.Word;
import lingo.game.infrastructure.source.ApiWordSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class LingoWordsValidatorTest {

    private final IWordValidator wordValidator = new WordValidator();
    public LingoWordsValidatorTest() {

    }

    @Test
    @DisplayName("check if word is valid exits testing")
    public void WordValidTest() throws IOException, URISyntaxException {
        Assertions.assertEquals(true, wordValidator.evaluateWord("aanzien"));
        Assertions.assertEquals(true, wordValidator.evaluateWord("email"));
        Assertions.assertEquals(true, wordValidator.evaluateWord("smeer"));

    }

    @Test
    @DisplayName("not valid word testing")
    public void WordInValidTest() throws IOException, URISyntaxException {
        Assertions.assertEquals(false ,wordValidator.evaluateWord("Aanzien"));
        Assertions.assertEquals(false,wordValidator.evaluateWord("aanzien1"));
        Assertions.assertEquals(false ,wordValidator.evaluateWord("aan"));
        Assertions.assertEquals(false ,wordValidator.evaluateWord("aan-zien"));
        Assertions.assertEquals(false ,wordValidator.evaluateWord("e-mail"));
    }
}