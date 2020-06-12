package lingo.game.domain.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackTest {

    public FeedbackTest() {
    }

    @Test
    @DisplayName("Feedback creation Object Test")
    public void feedbackObjectTest() throws IOException, URISyntaxException {
        Feedback feedback = new Feedback();
        feedback.addFeedback('h', feedback.CORRECT);
        feedback.addFeedback('a', feedback.CORRECT);
        feedback.addFeedback('i', feedback.ABSENT);
        Assertions.assertEquals("h correct", feedback.getFeedback().get(0));
        Assertions.assertEquals("a correct", feedback.getFeedback().get(1));
        Assertions.assertEquals("i absent", feedback.getFeedback().get(2));
    }

    @Test
    @DisplayName("Feedback creation Object Test")
    public void feedbackCorrectTest() throws IOException, URISyntaxException {
        Feedback feedback = new Feedback();
        feedback.addCorrectLettersIndex(0);
        feedback.addCorrectLettersIndex(3);
        Assertions.assertTrue(feedback.getCorrectLettersIndex().contains(0));
        Assertions.assertTrue(feedback.getCorrectLettersIndex().contains(3));
        Assertions.assertFalse(feedback.getCorrectLettersIndex().contains(4));
    }









}
