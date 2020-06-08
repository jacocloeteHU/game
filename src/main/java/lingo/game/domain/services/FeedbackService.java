package lingo.game.domain.services;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.Word;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService implements IFeedbackService {

    public FeedbackService(){ }
    @Override
    public Feedback evolveWord(Word roundWord, String wordParts, String playersWord) {
        Feedback feedback = new Feedback();
        Boolean state = wordCorrectCheck(roundWord, playersWord);
        if(state == false){
            if(validCheck(wordParts, playersWord)){
                feedback = absentOrPresentCheck(roundWord, playersWord);
            } else {
                feedback = invalidFeedback(playersWord);
            }
        }
        feedback.setWordValidState(state);
        System.out.println(feedback.toString());
        return feedback;
    }

    public void addFeedback(Feedback feedback, char c, String feedbackType) {
        feedback.addFeedback(c, feedbackType);
    }

    @Override
    public Feedback getFeedback(Feedback feedback) {
        return feedback;
    }

    @Override
    public void PrintFeedback(Feedback feedback) {
        System.out.println(feedback.toString());
    }

    public Feedback absentOrPresentCheck(Word roundWord, String playersWord){
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
    
    public Feedback invalidFeedback(String playersWord){
        Feedback feedback = new Feedback();
        for(int i = 0; i < playersWord.length(); i++){
            feedback.addFeedback(playersWord.charAt(i), feedback.INVALID);
        }
        return feedback;
    }

    public boolean wordCorrectCheck(Word roundWord, String playersWord){
        return roundWord.getWord().equals(playersWord);
    }



    public boolean validCheck(String givenPart, String playersWord){
        for(int i = 0; i < givenPart.length(); i++){
            if(givenPart.charAt(i) != playersWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

/*    public String checkCorrectChar(char c, char c2){

        switch () {
            case c == c:
                rerturn "Correct

            default:
                return "Invalid"
        }
    }*/




}
