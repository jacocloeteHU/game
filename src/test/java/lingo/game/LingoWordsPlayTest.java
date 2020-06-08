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
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
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
    @Autowired
    private IGamePlayService GamePlayService;
    public LingoWordsPlayTest() {
    }

    @Test
    @DisplayName("Game Init test")
    public void initsializeTest() throws IOException, URISyntaxException {
        Word newWord = new Word("steun");
        Assertions.assertTrue(GamePlayService.start(newWord));
        GamePlayService.printCurrentGame();
    }

    @Test
    @DisplayName("Game play test")
    public void playTest() throws IOException, URISyntaxException {
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steur").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steuren").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steu").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertTrue(GamePlayService.guessWord("steun").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();

        playnegativeTest();
    }


    @DisplayName("Game play test")
    public void playnegativeTest() throws IOException, URISyntaxException {
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steur").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steuren").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steu").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steue").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steueee").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
        Assertions.assertFalse(GamePlayService.guessWord("steueeereee").getFeedback().isWordValidState());
        GamePlayService.printCurrentGame();
    }
/*    @Test
    @DisplayName("Game Init test")
    public void initsializeTest() throws IOException, URISyntaxException {
        Word newWord = new Word("steur");
        Assertions.assertTrue(GamePlayService.start(newWord));
        GamePlayService.printCurrentGame();
    }*/


}