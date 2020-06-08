package lingo.game;

import java.io.IOException;
import java.net.URISyntaxException;

import lingo.game.application.services.GamePlayService;
import lingo.game.domain.model.IWordSource;
import lingo.game.infrastructure.source.ApiWordSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WordsApplication implements CommandLineRunner {
    @Autowired
    GamePlayService gamePlayServices;
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
        gamePlayServices.start();
        gamePlayServices.printCurrentGame();
        gamePlayServices.guessWord("peanut");
        gamePlayServices.printCurrentGame();
    }
}
