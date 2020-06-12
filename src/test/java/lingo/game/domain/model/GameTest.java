package lingo.game.domain.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameTest {
    private static String gameKey = "";

    public GameTest() {
    }

    @Test
    @DisplayName("Game Object Test")
    public void gameScoreTest() throws IOException, URISyntaxException {
        Game game = new Game();
        game.addScore(3);
        game.addScore(2);
        Game game2 = new Game();
        Assertions.assertEquals(50, game.getScore());
        Assertions.assertTrue(game.equals(game2));
    }

    @Test
    @DisplayName("Game Object Test")
    public void gameWordLengthTest() throws IOException, URISyntaxException {
        Game game = new Game();
        Assertions.assertEquals(5, game.getWordLength());
        game.addWordLength();
        Assertions.assertEquals(6, game.getWordLength());
        game.addWordLength();
        Assertions.assertEquals(7, game.getWordLength());
        game.addWordLength();
        Assertions.assertEquals(5, game.getWordLength());
    }

    @Test
    @DisplayName("Game Object Test")
    public void gameStartStopTest() throws IOException, URISyntaxException {
        Game game = new Game();
        game.start();
        Assertions.assertTrue(game.isActive());
        game.stop();
        Assertions.assertFalse(game.isActive());
        game.start();
        Assertions.assertTrue(game.isActive());
    }


}
