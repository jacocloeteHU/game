package lingo.game.domain.services;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Turn;
import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IRoundService {
    //public Round createRound(int timer, int turns, Word word) throws IOException, URISyntaxException;
    public boolean roundStatus();

    Round createRound(Word word, Turn turn);
}
