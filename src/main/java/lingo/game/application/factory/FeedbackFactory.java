package lingo.game.application.factory;

import lingo.game.application.validation.IWordValidator;
import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Component
public class FeedbackFactory implements IFeedbackFactory {
    @Autowired
    IWordValidator wordValidator;
    @Override
    public Feedback createFeedback(Word roundWord, ArrayList<Integer> wordPartsIndex, String playersWord) throws IOException, URISyntaxException {
        if(wordValidator.validateWordsForFeedback(wordPartsIndex, roundWord.getWord(), playersWord)){
            return absentOrPresentCheck(roundWord, playersWord);
        } else {
            return invalidFeedback(playersWord);
        }
    }

    public Feedback absentOrPresentCheck(Word roundWord, String playersWord){
        Feedback feedback = new Feedback();
        for(int i =0; i < playersWord.length(); i++) {
            char charPlayer = playersWord.charAt(i);
            if(roundWord.getWord().charAt(i) == charPlayer) {
                feedback.addFeedback(charPlayer, feedback.CORRECT);
                feedback.addCorrectLettersIndex(i);
            } else if(roundWord.getWord().contains(Character.toString(charPlayer))) {
                feedback.addFeedback(charPlayer, feedback.PRESENT);
            } else {
                feedback.addFeedback(charPlayer, feedback.ABSENT);
            }
        }
        feedback.setWordCorrect(wordValidator.wordCorrectCheck(roundWord, playersWord));
        return feedback;
    }

    public Feedback invalidFeedback(String playersWord){
        Feedback feedback = new Feedback();
        for(int i = 0; i < playersWord.length(); i++){
            feedback.addFeedback(playersWord.charAt(i), feedback.INVALID);
        }
        feedback.setWordCorrect(false);
        return feedback;
    }

}




//feedback.setWordValidState(correctWord);
//System.out.println(feedback.toString());