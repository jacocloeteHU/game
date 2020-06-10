package lingo.game.domain.services;

import lingo.game.domain.model.Word;

import java.util.ArrayList;

public interface IWordService {
    public ArrayList<Word> getAll();

    public void addList(ArrayList<Word> words);

//	public void Add(Word word);
//
//	public boolean Remove(Word word);

    public void clear();
}
