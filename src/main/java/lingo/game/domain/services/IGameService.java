package lingo.game.domain.services;

import lingo.game.domain.model.Game;
import lingo.game.domain.model.Round;

public interface IGameService {


    public void start(Round round);
    public Game getGame();
    public Game nextRound(Round round);
    public void stop();
}
