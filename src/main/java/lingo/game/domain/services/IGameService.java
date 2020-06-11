package lingo.game.domain.services;

import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;

public interface IGameService {


    public Game create(Round round);
    public Game findGame(Game game);
    public Game addRound(Game game, Round round);
    public void stop(Game game);
}
