package lingo.game.domain.services;

import lingo.game.domain.model.Feedback;
import lingo.game.domain.model.IWordSource;
import lingo.game.domain.model.Round;
import lingo.game.domain.model.Word;
import lingo.game.infrastructure.source.ApiWordSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class RoundService implements IRoundService {
    @Autowired
    IFeedbackService feedbackService;
    RoundService(){

    }
    @Override
    public Round createRound(int timer, int turns) throws IOException, URISyntaxException {
        IWordSource wordSource = new ApiWordSource("https://lingo-words.herokuapp.com");
        Word newWord = wordSource.ReadWord(5);
        return new Round(newWord, timer);
    }

    public Round evaluateGuessedWord(Round round, String guessWord){
        Word word = round.getWord();
        feedbackService.evolveWord(word, round.getWordParts(), guessWord);

        return round;
      //  return round.getWord().equals(guessWord);
    }

    @Override
    public boolean roundStatus() {
        return false;
    }
}
