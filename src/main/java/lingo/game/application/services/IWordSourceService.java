package lingo.game.application.services;

import lingo.game.domain.model.Word;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IWordSourceService {
    Word generateNewWord(int length) throws IOException, URISyntaxException;
}
