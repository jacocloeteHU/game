package lingo.game.domain.services;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IRoundService {
    public Round createRound(int timer, int turns ) throws IOException, URISyntaxException;
    public boolean roundStatus();
    public Round evaluateGuessedWord(Round round, String guessWord);
}
