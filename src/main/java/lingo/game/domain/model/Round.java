package lingo.game.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Objects;

public class Round {
    @JsonIgnore private Word word;
    private ArrayList<Integer> wordPartsIndexes = new ArrayList<Integer>();
    private ArrayList<Turn> turns = new ArrayList<Turn>();
    private boolean active;


    public Round(Word word, Turn turn) {
        this.word = word;
        this.turns.add(turn);
        this.active = true;
        wordPartsIndexes.add(0);
    }

    public ArrayList<Turn> getTurns() {
        return turns;
    }

    public void setTurns(ArrayList<Turn> turns) {
        this.turns = turns;
    }

    public boolean isActive() {
        return active;
    }

/*    public int getTurn() {
        return turn;
    }*/

    public void addTurn(Turn turn) {
        turns.add(turn);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<Integer> getWordPartsIndexes() {
        return wordPartsIndexes;
    }

    public void setWordPartsIndexes(ArrayList<Integer> wordPartsIndexes) {
        for(int i : wordPartsIndexes){
      //      int wordPartsIndex = wordPartsIndexes.get(i);
            if(!this.wordPartsIndexes.contains(i)){
                this.wordPartsIndexes.add(i);
            }
        }
    }

    @Override
    public String toString() {
        return "Round{" +
                "word=" + word +
                ", turns=" + turns +
                ", active=" + active +
                '}';
    }

    /*    public ArrayList<String> getPlayerGuesses() {
        if(playerGuesses.size() > 0){
            return playerGuesses;
        }
        ArrayList<String> emptyList = new ArrayList<String>();
        emptyList.add("Null");
        return emptyList;
    }*/

/*    public String getPlayerGuessesByIndex(int index) {
        if (playerGuesses.size() < index) {
            return playerGuesses.get(index);
        } else return "Null";
    }*/

/*
    public void addPlayerGuesses(String playerGuess) {
        this.playerGuesses.add(playerGuess);
    }
*/

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
            if(wordPartsIndexes.contains(count) ){
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
            if(wordPartsIndexes.contains(count) ){
                guessString += c;
            } else {
                guessString += "_";
            }
            count++;
        }
        return guessString;
    }

    /*public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }



    public void setTurns(int turn) {
        this.turn = turn;
    }

    public ArrayList<Feedback> getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback.add(feedback);
    }*/

/*    @Override
    public String toString() {
        return "Round{" +
                "word=" + word +
                ", timer=" + timer +
                ", turn=" + turn +
                ", feedback='" + feedback + '\'' +
                '}';
    }*/

/*    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return timer == round.timer &&
                turn == round.turn &&
                Objects.equals(word, round.word) &&
                Objects.equals(feedback, round.feedback);
    }*/

 /*   @Override
    public int hashCode() {
        return Objects.hash(word, timer, turn, feedback);
    }*/
}
