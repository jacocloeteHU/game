package lingo.game.domain.model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public interface IWordSource {

    public ArrayList<Word> ReadWords() throws IOException, URISyntaxException;
    public ArrayList<Word> ReadWords(int length) throws IOException, URISyntaxException;
    public Word ReadWord() throws IOException, URISyntaxException;
    public Word ReadWord(int length) throws IOException, URISyntaxException;
    boolean checkWord(String word) throws IOException, URISyntaxException;
}
