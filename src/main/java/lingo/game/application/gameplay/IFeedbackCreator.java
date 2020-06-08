package lingo.game.application.gameplay;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IFeedbackCreator {
    public Feedback evolveWord(Word roundWord, String wordParts, String playersWord) throws IOException, URISyntaxException;
  //  Feedback absentOrPresentCheck(Word roundWord, String playersWord);
  //  Feedback invalidFeedback(String playersWord);
  //  boolean validCheck(String givenPart, String playersWord);
  //  boolean wordCorrectCheck(Word roundWord, String playersWord);
}
