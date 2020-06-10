package lingo.game.domain.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface IWordSource {

    public ArrayList<Word> readWords() throws IOException, URISyntaxException;
    public ArrayList<Word> readWords(int length) throws IOException, URISyntaxException;
    public Word readWord() throws IOException, URISyntaxException;
    public Word readWord(int length) throws IOException, URISyntaxException;
    boolean checkWord(String word) throws IOException, URISyntaxException;
}
