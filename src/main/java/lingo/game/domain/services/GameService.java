package lingo.game.domain.services;

import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameService implements IGameService {

    private ArrayList<Game> games = new ArrayList<Game>();

    GameService(){
    }
    @Override
    public Game create(Round round) {
        Game game = new Game();
        game.start();
        game.setRound(round);
        games.add(game);
        return game;
    }

    public Game findGame(Game game){
        int index = games.indexOf(game);
        return games.get(index);
    }

    @Override
    public Game addRound(Game game, Round round) {
        findGame(game).setRound(round);
        // add score etc
        return game;
    }

    public void stop(Game game) {
        int index = games.indexOf(game);
        games.get(index).stop();
    }
}
