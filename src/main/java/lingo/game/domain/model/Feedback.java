package lingo.game.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Feedback {
    private boolean wordCorrect;
    private ArrayList<String> feedback = new ArrayList<String>();
    private ArrayList<Integer> correctLettersIndex = new ArrayList<Integer>();
    @JsonIgnore public final String CORRECT = "correct";
    @JsonIgnore public final String INVALID = "invalid";
    @JsonIgnore public final String PRESENT = "present";
    @JsonIgnore public final String ABSENT = "absent";

    public Feedback() {
        this.wordCorrect = false;
    }

    public boolean isWordCorrect() {
        return wordCorrect;
    }

    public void setWordCorrect(boolean wordCorrect) {
        this.wordCorrect = wordCorrect;
    }

    public ArrayList<String> getFeedback() {
            return feedback;
    }

    public ArrayList<Integer> getCorrectLettersIndex() {
        return correctLettersIndex;
    }

    public void addCorrectLettersIndex(int correctLettersIndex) {
        this.correctLettersIndex.add(correctLettersIndex);
    }

    public void addFeedback(char wordChar, String newFeedback){
        feedback.add(wordChar + " "+ newFeedback);
    }

    @Override
    public String toString() {
        return "Feedback " + feedback;
    }
}
