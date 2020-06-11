package lingo.game.application.factory;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface IFeedbackFactory {
    Feedback createFeedback(Word roundWord, ArrayList<Integer> wordPartsIndex, String playersWord) throws IOException, URISyntaxException;
    Feedback absentOrPresentCheck(Word roundWord, String playersWord);
    Feedback invalidFeedback(String playersWord);
}

