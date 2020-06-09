package lingo.game.domain.model;

import java.util.ArrayList;

public class Feedback {
    private boolean wordValidState;
    private ArrayList<String> feedback = new ArrayList<String>();
    private ArrayList<Integer> correctLettersIndex = new ArrayList<Integer>();
    private int correctCount;
    public final String CORRECT = "correct";
    public final String INVALID = "invalid";
    public final String PRESENT = "present";
    public final String ABSENT = "absent";

    public Feedback() {
        this.wordValidState = false;
    }

    public boolean isWordValidState() {
        return wordValidState;
    }

    public void setWordValidState(boolean wordValidState) {
        this.wordValidState = wordValidState;
    }

    public Feedback(ArrayList<String> feedback) {
        this();
        this.feedback = feedback;
    }

    public ArrayList<String> getFeedback() {
      //  if(feedback.size() > 0){
            return feedback;
     //   }
     //   ArrayList<String> emptyList = new ArrayList<String>();
     //   emptyList.add("Null");
     //   return emptyList;
    }

    private String feedbackType(int type){
        switch(type){
            case 1:
                return CORRECT;
            case 2:
                return PRESENT;
            case 3:
                return ABSENT;
            case 4:
                return INVALID;
            default:
                return INVALID;
        }
    }

    public ArrayList<Integer> getCorrectLettersIndex() {
        return correctLettersIndex;
    }

    public void addCorrectLettersIndex(int correctLettersIndex) {
        this.correctLettersIndex.add(correctLettersIndex);
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }

    public void addFeedback(char wordChar, String newFeedback){
        feedback.add(wordChar + " "+ newFeedback);
    }

/*    public String getCORRECT() {
        return CORRECT;
    }

    public String getINVALID() {
        return INVALID;
    }

    public String getABSENT() {
        return ABSENT;
    }*/

    @Override
    public String toString() {
        return "Feedback " + feedback;
    }
}
