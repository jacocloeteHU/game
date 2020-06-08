import lingo.game.application.gameplay.IFeedbackCreator;
import lingo.game.application.gameplay.FeedbackCreator;
import lingo.game.domain.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

public class LingoWordsFeedbackTest {
    @Autowired
    private IFeedbackCreator feedbackCreator;
    public LingoWordsFeedbackTest() {
        feedbackCreator = new FeedbackCreator() {
        };
    }

/*    @Test
    @DisplayName("Feedback valid check testing")
    public void WordValidTest()  {
        Assertions.assertTrue(feedbackCreator.validCheck("BA", "BARTJE"));
        Assertions.assertTrue(feedbackCreator.validCheck("B", "BERTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "BERTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "KERTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "KARTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "KARTJE"));
    }*/

    @Test
    @DisplayName("Feedback valid check testing")
    public void WordPresentAndAbsentTest() throws IOException, URISyntaxException {
        Word word = new Word("barend");
        feedbackCreator.evolveWord(word, "ba", "bartje");
        feedbackCreator.evolveWord(word, "ba", "barend");
        feedbackCreator.evolveWord(word, "ba", "kareje");
        feedbackCreator.evolveWord(word, "ba", "artje");
        feedbackCreator.evolveWord(word, "ba", "bartjess");
        feedbackCreator.evolveWord(word, "ba", "bartje");


    }

    @Test
    @DisplayName("Feedback valid check testing")
    public void WordPresentAndAbsent2Test() throws IOException, URISyntaxException {
        Word word = new Word("aanzien");
        feedbackCreator.evolveWord(word, "aa", "aanvang");
        feedbackCreator.evolveWord(word, "aan", "aanzoek");
        feedbackCreator.evolveWord(word, "aan", "aanvoer");

    }




}