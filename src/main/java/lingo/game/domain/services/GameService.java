package lingo.game.domain.services;

import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService {

    private Game game;

    GameService(){
    }
    @Override
    public void start(Round round) {
        game = new Game();
        game.start();
        game.addRound(round);
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public Game nextRound(Round round) {
        game.addRound(round);

        // add score etc
        return game;
    }

    @Override
    public void stop() {

    }
}
