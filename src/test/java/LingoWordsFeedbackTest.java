import lingo.game.application.gameplay.IFeedbackCreator;
import lingo.game.application.gameplay.FeedbackCreator;
import lingo.game.domain.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class LingoWordsFeedbackTest {
    @Autowired
    private IFeedbackCreator feedbackCreator;
    public LingoWordsFeedbackTest() {
        feedbackCreator = new FeedbackCreator() {
        };
    }

/*
    @Test
    @DisplayName("Feedback valid check testing")
    public void WordValidTest()  {
        Word word = new Word("barend");
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(0);
        indexList.add(1);
        Assertions.assertTrue(feedbackCreator.validCheck("BA", "BARTJE"));
        Assertions.assertTrue(feedbackCreator.validCheck("B", "BERTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "BERTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "KERTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "KARTJE"));
        Assertions.assertFalse(feedbackCreator.validCheck("BA", "KARTJE"));
    }
*/


    @Test
    @DisplayName("Feedback valid check testing")
    public void WordPresentAndAbsentTest() throws IOException, URISyntaxException {
        Word word = new Word("barend");
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(0);
        indexList.add(1);
        feedbackCreator.evolveWord(word, indexList, "bartje");
        feedbackCreator.evolveWord(word, indexList, "barend");
        feedbackCreator.evolveWord(word, indexList, "kareje");
        feedbackCreator.evolveWord(word, indexList, "artje");
        feedbackCreator.evolveWord(word, indexList, "bartjess");
        feedbackCreator.evolveWord(word, indexList, "bartje");


    }

    @Test
    @DisplayName("Feedback valid check testing")
    public void WordPresentAndAbsent2Test() throws IOException, URISyntaxException {
        Word word = new Word("aanzien");
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(0);
        indexList.add(1);
        feedbackCreator.evolveWord(word, indexList, "aanvang");
        indexList.add(2);
        feedbackCreator.evolveWord(word, indexList, "aanzoek");
        feedbackCreator.evolveWord(word, indexList, "aanvoer");

    }




}
