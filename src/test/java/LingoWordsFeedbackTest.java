import lingo.game.domain.model.IWordSource;
import lingo.game.domain.model.Word;
import lingo.game.domain.services.FeedbackService;
import lingo.game.domain.services.IFeedbackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URISyntaxException;

public class LingoWordsFeedbackTest {
    @Autowired
    private IFeedbackService feedbackService;
    public LingoWordsFeedbackTest() {
        feedbackService = new FeedbackService();
    }

    @Test
    @DisplayName("Feedback valid check testing")
    public void WordValidTest()  {
        Assertions.assertTrue(feedbackService.validCheck("BA", "BARTJE"));
        Assertions.assertTrue(feedbackService.validCheck("B", "BERTJE"));
        Assertions.assertFalse(feedbackService.validCheck("BA", "BERTJE"));
        Assertions.assertFalse(feedbackService.validCheck("BA", "KERTJE"));
        Assertions.assertFalse(feedbackService.validCheck("BA", "KARTJE"));
        Assertions.assertFalse(feedbackService.validCheck("BA", "KARTJE"));
    }

    @Test
    @DisplayName("Feedback valid check testing")
    public void WordPresentAndAbsentTest()  {
        Word word = new Word("barend");
        feedbackService.evolveWord(word, "ba", "bartje");
        feedbackService.evolveWord(word, "ba", "barend");
        feedbackService.evolveWord(word, "ba", "kareje");
        feedbackService.evolveWord(word, "ba", "artje");
        feedbackService.evolveWord(word, "ba", "bartjess");
        feedbackService.evolveWord(word, "ba", "bartje");


    }




}