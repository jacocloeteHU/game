package lingo.game.domain.services;

import lingo.game.domain.model.Word;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class WordService implements IWordService {
    private ArrayList<Word> WordList;

    public WordService() {
        this.WordList = new ArrayList<Word>();
    }

    public ArrayList<Word> getAll(){
        return this.WordList;
    }

    public void addList(ArrayList<Word> words) {
        this.WordList.addAll(words);
    }

    public void clear() {
        WordList.clear();
    }
}
