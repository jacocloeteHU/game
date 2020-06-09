package lingo.game.application.services;

import lingo.game.application.gameplay.IFeedbackCreator;
import lingo.game.application.gameplay.FeedbackCreator;
import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;
import lingo.game.domain.services.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class TurnService {
    @Autowired
    IFeedbackService feedbackService;
    public Round evaluateGuessedWord(Round round, String guessWord, int turnIndex) throws IOException, URISyntaxException {
        Word word = round.getWord();
        IFeedbackCreator feedbackCreator = new FeedbackCreator();
        Feedback feedback = feedbackCreator.evolveWord(word, round.getWordPartsIndexes(), guessWord);
        round.getTurns().get(turnIndex).setFeedback(feedback);
      //  round.setFeedback(feedback);
        return round;
        //  return round.getWord().equals(guessWord);
    }
}
