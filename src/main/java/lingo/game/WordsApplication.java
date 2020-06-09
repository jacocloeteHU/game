package lingo.game;

import java.io.IOException;
import java.net.URISyntaxException;

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
import org.springframework.stereotype.Component;


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
        api.ReadWord();
        api.ReadWord(5);
        api.ReadWords();
        api.ReadWords(5);
        Game game = GamePlayService.startWithRandomWord();
        String gameKey = game.getGameKey();
        System.out.println(gameKey);
      //  GamePlayService.printCurrentGame(gameKey);
        GamePlayService.guessWord(gameKey,"peanut");
      //  GamePlayService.printCurrentGame(gameKey);
    }
}
