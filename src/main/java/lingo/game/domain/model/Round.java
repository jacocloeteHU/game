package lingo.game.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Objects;

public class Round {
    @JsonIgnore private Word word;
    private ArrayList<Integer> correctLetterIndexList = new ArrayList<Integer>();
    private ArrayList<Turn> turns = new ArrayList<Turn>();
    private boolean active;


    public Round(Word word, Turn turn) {
        this.word = word;
        this.turns.add(turn);
        this.active = true;
        correctLetterIndexList.add(0);
    }

    public ArrayList<Turn> getTurns() {
        return turns;
    }

    public boolean isActive() {
        return active;
    }

    public void addTurn(Turn turn) {
        turns.add(turn);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<Integer> getWordPartsIndexes() {
        return correctLetterIndexList;
    }

    public void setWordPartsIndexes(ArrayList<Integer> wordPartsIndexes) {
        for(int i : wordPartsIndexes){
            if(!this.correctLetterIndexList.contains(i)){
                this.correctLetterIndexList.add(i);
            }
        }
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    private String getCorrectLetterParts(String placeholder){
        String wordString = word.getWord();
        String guessString = "";
        int count = 0;
        for(char c : wordString.toCharArray()){
            if(correctLetterIndexList.contains(count) ){
                guessString += c;
            } else {
                guessString += placeholder;
            }
            count++;
        }
        return guessString;
    }

    public String getWordParts() {
        return getCorrectLetterParts("_");
    }

    @Override
    public String toString() {
        return "Round{" +
                "word=" + word +
                ", correctLetterIndexList=" + correctLetterIndexList +
                ", turns=" + turns +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return active == round.active &&
                Objects.equals(word, round.word) &&
                Objects.equals(correctLetterIndexList, round.correctLetterIndexList) &&
                Objects.equals(turns, round.turns);
    }

}
