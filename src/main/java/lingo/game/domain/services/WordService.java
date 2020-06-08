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

    public ArrayList<Word> GetAll(){
        return this.WordList;
    }

    public void AddList(ArrayList<Word> words) {

        this.WordList.addAll(words);
/*		for(Word word : words) {
			this.Add(word);
		}*/
    }

	/*public void Add(Word word) {
		this.WordList.add(word);
	}

	public boolean Remove(Word word) {
		return this.WordList.remove(word);
	}*/

    public void Clear() {
        WordList.clear();
    }
}
