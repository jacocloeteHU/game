package lingo.game.domain.services;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Word;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements IFeedbackService {

    public FeedbackService(){ }

    public void addFeedback(Feedback feedback, char c, String feedbackType) {
        feedback.addFeedback(c, feedbackType);
    }

    @Override
    public Feedback findFeedback(Feedback feedback) {
        return feedback;
    }


}
