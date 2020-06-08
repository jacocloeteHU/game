package lingo.game.domain.model;

import java.util.ArrayList;

public class Feedback {
    private boolean wordValidState;
    private ArrayList<String> feedback = new ArrayList<String>();
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
        return feedback;
    }

    public void setFeedback(ArrayList<String> feedback) {
        this.feedback = feedback;
    }

    public void addFeedback(char wordChar, String newFeedback){
        feedback.add(wordChar + " "+ newFeedback);
    }

    public String getCORRECT() {
        return CORRECT;
    }

    public String getINVALID() {
        return INVALID;
    }

    public String getABSENT() {
        return ABSENT;
    }

    @Override
    public String toString() {
        return "Feedback " + feedback;
    }
}
