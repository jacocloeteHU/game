package lingo.game.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Word {
    private int length;
    private String word;

    public Word(String word) {
        super();
        length = word.length();
        this.word = word;
    }

    public Word(@JsonProperty("word")String word, @JsonProperty("length")int length) {
        super();
        this.length = word.length();
        this.word = word;
    }

    public int getLength() {
        return length;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String wordString) {
        word = wordString;
        length = wordString.length();
    }

    public String toString() {
        return "word [Length=" + length + ", Word=" + word + "]";
    }


}
