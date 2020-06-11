package lingo.game;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

import lingo.game.application.services.GamePlayService;
import lingo.game.domain.model.Game;
import lingo.game.domain.model.IWordSource;
import lingo.game.infrastructure.source.ApiWordSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class WordsApplication implements CommandLineRunner {
    @Autowired
    GamePlayService GamePlayService;
    public static void main(String[] args) {
        SpringApplication.run(WordsApplication.class, args);
    }

    private void InitializeApplication() throws IOException, URISyntaxException {

    }

    @Override
    public void run(String... args) throws IOException, URISyntaxException {
        System.out.println("Initsialize word game");
        IWordSource api = new ApiWordSource("https://lingo-words.herokuapp.com");
        api.readWord();
        api.readWord(5);
        api.readWords();
        api.readWords(5);
        Game game = GamePlayService.start();
        String gameKey = game.getGameKey();
        System.out.println(gameKey);
      //  GamePlayService.printCurrentGame(gameKey);
        GamePlayService.guessWord(gameKey,"peanut", new Date());
      //  GamePlayService.printCurrentGame(gameKey);
    }
}
