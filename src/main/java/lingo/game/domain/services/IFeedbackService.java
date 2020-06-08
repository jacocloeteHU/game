package lingo.game.domain.services;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;

import java.util.ArrayList;

public interface IFeedbackService {
    public Feedback evolveWord(Word roundWord, String wordParts, String playersWord);
    void addFeedback(Feedback feedback, char c, String feedbackType);
    public Feedback getFeedback(Feedback feedback);
    public void PrintFeedback(Feedback feedback);
    public boolean validCheck(String givenPart, String playersWord);
}
