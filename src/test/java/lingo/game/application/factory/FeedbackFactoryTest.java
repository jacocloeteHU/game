package lingo.game.application.factory;

import lingo.game.application.services.IGamePlayService;
import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Game;
import lingo.game.domain.model.Word;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackFactoryTest {
    private static String gameKey = "";
    @Autowired
    private IFeedbackFactory feedbackFactory;

    public FeedbackFactoryTest() {
    }

    @Test
    @DisplayName("Create Feedback test")
    public void createFeedbackTest() throws IOException, URISyntaxException {
        Word word = new Word("staan");
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(0);
        indexList.add(1);
        Feedback feedback = feedbackFactory.createFeedback(word, indexList, "stank");
        Assertions.assertFalse(feedback.isWordCorrect());
        feedback = feedbackFactory.createFeedback(word, indexList, "staan");
        Assertions.assertTrue(feedback.isWordCorrect());
    }

    @Test
    @DisplayName("Create Feedback test")
    public void absentOrPresentCheckTest() throws IOException, URISyntaxException {
        Word word = new Word("staan");
        Feedback feedback = feedbackFactory.absentOrPresentCheck(word, "stank");
        Assertions.assertFalse(feedback.isWordCorrect());
        feedback = feedbackFactory.absentOrPresentCheck(word, "staan");
        Assertions.assertTrue(feedback.isWordCorrect());
    }

    @Test
    @DisplayName("Invalid Feedback test")
    public void invalidFeedbackTest() throws IOException, URISyntaxException {
        Feedback feedback = feedbackFactory.invalidFeedback("stank");
        Assertions.assertFalse(feedback.isWordCorrect());
    }

    @Test
    @DisplayName("Invalid Word part test")
    public void invalidWordPartTest() throws IOException, URISyntaxException {
        Word word = new Word("staan");
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(0);
        Feedback feedback = feedbackFactory.createFeedback(word, indexList, "slank");
        Assertions.assertFalse(feedback.isWordCorrect());
    }

    





}
