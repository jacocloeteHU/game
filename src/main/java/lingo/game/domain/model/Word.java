package lingo.game.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    public void setWord(String wordString) {
        Word = wordString;
        Length = wordString.length();
    }

    @Override
    public String toString() {
        return "word [Length=" + Length + ", Word=" + Word + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Length == word.Length &&
                Objects.equals(Word, word.Word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Length, Word);
    }
}
