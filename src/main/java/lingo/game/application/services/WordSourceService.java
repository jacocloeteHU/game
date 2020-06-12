package lingo.game.application.services;

import lingo.game.domain.model.IWordSource;
import lingo.game.domain.model.Word;
import lingo.game.infrastructure.source.ApiWordSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class WordSourceService implements IWordSourceService {

    public WordSourceService(){

    }
    public Word generateNewWord(int length) throws IOException, URISyntaxException {
        IWordSource wordSource = new ApiWordSource("https://lingo-words.herokuapp.com");
        Word newWord = wordSource.readWord(length);
        return newWord;
    }
}
