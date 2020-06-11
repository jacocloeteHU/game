package lingo.game.application.services;

import lingo.game.application.factory.IFeedbackFactory;
import lingo.game.application.factory.FeedbackFactory;
import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;
import lingo.game.domain.services.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

@Component
public class TurnService {
    @Autowired
    IFeedbackService feedbackService;
    @Autowired
    IFeedbackFactory feedbackCreator;
    public Round evaluateGuessedWord(Round round, String guessWord, int turnIndex, Date timeStamp) throws IOException, URISyntaxException {
        Word word = round.getWord();
        Feedback feedback;
        if(!round.getTurns().get(turnIndex).inTime(timeStamp)){
            feedback = feedbackCreator.invalidFeedback(guessWord);
        } else {
            feedback = feedbackCreator.createFeedback(word, round.getWordPartsIndexes(), guessWord);
            round.setWordPartsIndexes(feedback.getCorrectLettersIndex());
        }
        round.getTurns().get(turnIndex).setFeedback(feedback);
        return round;
    }
}
