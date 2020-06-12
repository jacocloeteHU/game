package lingo.game.application.services;

import lingo.game.application.services.IGamePlayService;
import lingo.game.domain.model.Game;
import lingo.game.domain.model.Word;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamePlayServiceTest {
    private static String gameKey = "";
    @Autowired
    private IGamePlayService GamePlayService;
    
    public GamePlayServiceTest() {
    }


  //  @Test
    //@DisplayName("Initsialize game")
    @BeforeEach
    public void initsializeTest() throws IOException, URISyntaxException {
        Word newWord = new Word("steun");
        Game game = GamePlayService.start(newWord);
        gameKey = game.getGameKey();
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("to late guesses test")
    public void toLateGuessesTest() throws IOException, URISyntaxException {
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steur", new Date()).getRound().isActive());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, 11);
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steun", cal.getTime()).getRound().isActive());
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steun", new Date()).getRound().isActive());
    }

    @Test
    @DisplayName("4 guesses test")
    public void fourGuessesTest() throws IOException, URISyntaxException {
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steur", new Date()).getRound().isActive());
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steuren", new Date()).getRound().isActive());
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steu", new Date()).getRound().isActive());
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steun", new Date()).getRound().isActive());
    }
    @Test
    @DisplayName("Lose test")
    public void playnegativeTest() throws IOException, URISyntaxException {
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steuren", new Date()).getRound().isActive());
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steu", new Date()).getRound().isActive());
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steue", new Date()).getRound().isActive());
        Assertions.assertTrue(GamePlayService.guessWord(gameKey,"steueee", new Date()).getRound().isActive());
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steueeereee", new Date()).getRound().isActive());
        // nog een try om te bevestigen dat je eerst next round moet opvragen
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steun", new Date()).getRound().isActive());
    }

    @Test
    @DisplayName("Next Round test")
    public void nextRoundTest() throws IOException, URISyntaxException {
        Assertions.assertFalse(GamePlayService.guessWord(gameKey,"steun", new Date()).getRound().isActive());
        Game game = GamePlayService.nextRound(gameKey);
        Assertions.assertTrue(game.getRound().isActive());
        Assertions.assertTrue(game.getRound().getTurns().size() == 1);
        Assertions.assertTrue(game.getScore() == 50);
    }

    @Test
    @DisplayName("Next Round after 5 wrong tries test")
    public void nextRoundAfterLoseTest() throws IOException, URISyntaxException {
        GamePlayService.guessWord(gameKey,"stuur", new Date());
        GamePlayService.guessWord(gameKey,"stuur", new Date());
        GamePlayService.guessWord(gameKey,"stuur", new Date());
        GamePlayService.guessWord(gameKey,"stuur", new Date());
        GamePlayService.guessWord(gameKey,"stuur", new Date());
        Game game = GamePlayService.nextRound(gameKey);
        Assertions.assertTrue(game.getRound().isActive());
        Assertions.assertTrue(game.getRound().getTurns().size() == 1);
        Assertions.assertTrue(game.getScore() == 0);
    }

    @Test
    @DisplayName("Get game from memory")
    public void getGameFromMemoryTest() throws IOException, URISyntaxException {
        Assertions.assertTrue(GamePlayService.getCurrentGame(gameKey).getRound().isActive());
        Assertions.assertTrue(GamePlayService.getCurrentGame(gameKey).getScore() == 0);
   }



}
