package lingo.game;

import lingo.game.WordsApplication;
import lingo.game.application.gameplay.FeedbackCreator;
import lingo.game.application.gameplay.IFeedbackCreator;
import lingo.game.application.gameplay.IWordValidator;
import lingo.game.application.gameplay.WordValidator;
import lingo.game.application.services.GamePlayService;
import lingo.game.application.services.IGamePlayService;
import lingo.game.domain.model.Game;
import lingo.game.domain.model.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LingoWordsPlayTest {
    private static String gameKey = "";
    @Autowired
    private IGamePlayService GamePlayService;

    public LingoWordsPlayTest() {
    }

    @Before
    @Test
    @DisplayName("Game play init test")
    public void initsializeTest() throws IOException, URISyntaxException {
        Word newWord = new Word("steun");
        Game game = GamePlayService.start(newWord);
        gameKey = game.getGameKey();
        Assertions.assertTrue(true);
        GamePlayService.printCurrentGame(gameKey);
    }


    @Test
    @DisplayName("Game play test")
    public void playTest() throws IOException, URISyntaxException {
        System.out.println(this.gameKey);
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steur").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steuren").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steu").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steun").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);

        playnegativeTest();
    }

    @DisplayName("Game play test")
    public void playnegativeTest() throws IOException, URISyntaxException {
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steur").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steuren").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steu").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steue").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steueee").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steueeereee").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame(gameKey);
    }
/*    @Test
    @DisplayName("Game Init test")
    public void initsializeTest() throws IOException, URISyntaxException {
        Word newWord = new Word("steur");
        Assertions.assertTrue(GamePlayService.start(newWord));
        GamePlayService.printCurrentGame();
    }*/


}