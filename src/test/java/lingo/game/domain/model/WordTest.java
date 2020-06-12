package lingo.game.domain.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WordTest {

    public WordTest() {
    }

    @Test
    @DisplayName("Word Object Test")
    public void wordObjectTest() throws IOException, URISyntaxException {
        Word word = new Word("snaar");
        Assertions.assertEquals(5, word.getLength());
        word.setWord("snaren");
        Assertions.assertEquals(6, word.getLength());
        Assertions.assertEquals("snaren", word.getWord());
    }





}
