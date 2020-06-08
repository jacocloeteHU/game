package lingo.game.application.gameplay;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Word;
import lingo.game.domain.services.IFeedbackService;

import java.io.IOException;
import java.net.URISyntaxException;

public class FeedbackCreator implements IFeedbackCreator {
    @Override
    public Feedback evolveWord(Word roundWord, String wordParts, String playersWord) throws IOException, URISyntaxException {
        Feedback feedback = new Feedback();
        IWordValidator wordValidator = new WordValidator();
        boolean validWord = wordValidator.evaluateWord(playersWord);
        boolean correctWord = wordCorrectCheck(roundWord, playersWord);
        if((validWord) && (validPartsCheck(wordParts, playersWord)) && (validLengthCheck(roundWord.getWord(), playersWord))){
            feedback = absentOrPresentCheck(roundWord, playersWord);
        } else {
            feedback = invalidFeedback(playersWord);
        }

        feedback.setWordValidState(correctWord);
        System.out.println(feedback.toString());
        return feedback;
    }

    private Feedback absentOrPresentCheck(Word roundWord, String playersWord){
        Feedback feedback = new Feedback();
        for(int i =0; i < playersWord.length(); i++) {
            char charPlayer = playersWord.charAt(i);
            if(roundWord.getWord().charAt(i) == charPlayer) {
                feedback.addFeedback(charPlayer, feedback.CORRECT);
            } else if(roundWord.getWord().contains(Character.toString(charPlayer))) {
                feedback.addFeedback(charPlayer, feedback.PRESENT);
            } else {
                feedback.addFeedback(charPlayer, feedback.ABSENT);
            }
        }
        return feedback;
    }

    private Feedback invalidFeedback(String playersWord){
        Feedback feedback = new Feedback();
        for(int i = 0; i < playersWord.length(); i++){
            feedback.addFeedback(playersWord.charAt(i), feedback.INVALID);
        }
        return feedback;
    }

    private boolean validPartsCheck(String givenPart, String playersWord){
        for(int i = 0; i < givenPart.length(); i++){
            if(givenPart.charAt(i) != playersWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validLengthCheck(String roundWord, String playersWord){
        if(roundWord.length() == playersWord.length()){
            return true;
        }
        return false;
    }

    private boolean wordCorrectCheck(Word roundWord, String playersWord){
        return roundWord.getWord().equals(playersWord);
    }

}
