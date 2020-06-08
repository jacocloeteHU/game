
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

public class LingoWordsApiTest {

    private final IWordSource api;
    public LingoWordsApiTest() {
        api = new ApiWordSource("https://lingo-words.herokuapp.com");
    }

    @Test
    @DisplayName("Words Api testing")
    public void WordsApiTest() throws IOException, URISyntaxException {
        ArrayList<Word> words = api.ReadWords();
        Assert.notNull(words);
    }

    @Test
    @DisplayName("Words Api testing with length")
    public void WordsLengthApiTest() throws IOException, URISyntaxException {
        ArrayList<Word> words = api.ReadWords(5);
        Assert.notNull(words);
    }

    @Test
    @DisplayName("Word Api testing")
    public void WordApiTest() throws IOException, URISyntaxException {
        Word word = api.ReadWord();
        Assert.notNull(word);
    }

    @Test
    @DisplayName("Word Api testing with length")
    public void WordLengthApiTest() throws IOException, URISyntaxException {
        Word word = api.ReadWord(5);
        Assert.notNull(word);
    }

    @Test
    @DisplayName("check if word exits testing")
    public void WordPresentAndAbsentTest() throws IOException, URISyntaxException {
        Assertions.assertEquals(true ,api.checkWord("aanzien"));
        Assertions.assertEquals(false ,api.checkWord("Aanzien"));
        Assertions.assertEquals(false,api.checkWord("aanzien1"));
        Assertions.assertEquals(false ,api.checkWord("aan"));
    }

}