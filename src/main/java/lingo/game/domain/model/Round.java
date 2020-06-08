package lingo.game.domain.model;

import java.util.Objects;

public class Round {
    private Word word;
    private int timer;
    private int turn;
    private boolean active;
    private Feedback feedback;

    public Round(Word word, int timer) {
        this.word = word;
        this.timer = timer;
        this.turn = 1;
        this.active = true;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getWordParts(){
        String wordString = word.getWord();
        String guessString = "";
        int count = 0;
        for(char c : wordString.toCharArray()){
            if(count < turn){
                guessString += c;
            }
            count++;
        }
        return guessString;
    }

    public String getWordPartWithPlaceholder(){
        String wordString = word.getWord();
        String guessString = "";
        int count = 0;
        for(char c : wordString.toCharArray()){
            if(count < turn){
                guessString += c;
            } else {
                guessString += "_";
            }
            count++;
        }
        return guessString;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTurn() {
        return turn;
    }

    public int nextTurn() {
        turn += 1;
        return turn;
    }

    public void setTurns(int turn) {
        this.turn = turn;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Round{" +
                "word=" + word +
                ", timer=" + timer +
                ", turn=" + turn +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return timer == round.timer &&
                turn == round.turn &&
                Objects.equals(word, round.word) &&
                Objects.equals(feedback, round.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, timer, turn, feedback);
    }
}
