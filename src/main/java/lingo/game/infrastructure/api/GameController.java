package lingo.game.infrastructure.api;

import lingo.game.application.services.GamePlayService;
import lingo.game.application.services.IGamePlayService;
import lingo.game.domain.model.Game;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
public class GameController {
    @Autowired
    IGamePlayService gamePlayService;
    @GetMapping("/game/start")
    public ResponseEntity<Game> GetGame() throws IOException, URISyntaxException, JSONException {
      //  JSONObject json = new JSONObject();
        //json.put("path", "/game/" + gamePlayService.startWithRandomWord().getGameKey()+ "/round");
        return ResponseEntity.ok(gamePlayService.startWithRandomWord());
    }

    @GetMapping("/game/{gameKey}/round")
    public ResponseEntity<Game> GetWordsByLength(@PathVariable String gameKey ) throws IOException, URISyntaxException {
        return ResponseEntity.ok(gamePlayService.getCurrentGame(gameKey));
    }

   @GetMapping("/game/{gameKey}/round/{playerWord}")
    public ResponseEntity<Game> GetGuessRound(@PathVariable String gameKey, @PathVariable String playerWord  ) throws IOException, URISyntaxException {
       return ResponseEntity.ok(gamePlayService.guessWord(gameKey, playerWord));
    }

    @GetMapping("/game/{gameKey}/round/next")
    public ResponseEntity<Game> GetNextRound(@PathVariable String gameKey) throws IOException, URISyntaxException {
        return ResponseEntity.ok(gamePlayService.nextRound(gameKey));
    }
/*
    @GetMapping("/word")
    public ResponseEntity<Word> GetRandomWord(){
        return ResponseEntity.ok(WordService.GetWord());
    }

    @GetMapping("/word/length/{length}")
    public ResponseEntity<Word> GetRandomWordByLength(@PathVariable int length){
        return ResponseEntity.ok(WordService.GetWordByLength(length));
    }

    @GetMapping("/word/check/{word}")
    public ResponseEntity<Boolean> GetRandomWord(@PathVariable String word){
        return ResponseEntity.ok(WordService.CheckWord(word));
    }*/
}
