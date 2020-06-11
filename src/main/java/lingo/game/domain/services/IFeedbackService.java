package lingo.game.domain.services;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;

import java.util.ArrayList;

public interface IFeedbackService {
    void addFeedback(Feedback feedback, char c, String feedbackType);
    public Feedback findFeedback(Feedback feedback);

}
