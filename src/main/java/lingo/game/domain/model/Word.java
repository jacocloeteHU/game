package lingo.game.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Word {
    private int Length;
    private String Word;

    public Word(String word) {
        super();
        Length = word.length();
        Word = word;
    }

    public Word(@JsonProperty("word")String word, @JsonProperty("length")int length) {
        super();
        Length = word.length();
        Word = word;
    }

    public int getLength() {
        return Length;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String content) {
        Word = content;
        Length = content.length();
    }

    @Override
    public String toString() {
        return "word [Length=" + Length + ", Word=" + Word + "]";
    }



}
