package lingo.game.domain.services;

import lingo.game.domain.model.*;
import lingo.game.infrastructure.source.ApiWordSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class RoundService implements IRoundService {
    @Autowired
    IFeedbackService feedbackService;
    RoundService(){

    }

    @Override
    public Round createRound(Word word, Turn turn) {
        return new Round(word, turn);
    }
}
