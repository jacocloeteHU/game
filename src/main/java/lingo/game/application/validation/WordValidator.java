package lingo.game.application.validation;

import lingo.game.domain.model.IWordSource;
import lingo.game.domain.model.Word;
import lingo.game.infrastructure.source.ApiWordSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Component
public class WordValidator implements IWordValidator {

    @Override
    public boolean validateWord(String word) throws IOException, URISyntaxException {
        if(validGameWordCheck(word)){
            return realWordCheck(word);
        } else {
            return false;
        }
    }

    public boolean validateWordsForFeedback(ArrayList<Integer> givenPartsIndex, String roundWord, String playersWord) throws IOException, URISyntaxException {
        return validateWord(playersWord) && validLengthCheck(roundWord, playersWord) && validPartsCheck(givenPartsIndex, roundWord, playersWord);
    }

    private boolean validPartsCheck(ArrayList<Integer> givenPart, String roundWord, String playersWord){
        for(int i : givenPart){
            if(roundWord.charAt(i) != playersWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validLengthCheck(String roundWord, String playersWord){
        if(roundWord.length() == playersWord.length()){
            return true;
        }
        return false;
    }

    public boolean wordCorrectCheck(Word roundWord, String playersWord){
        return roundWord.getWord().equals(playersWord);
    }

    private boolean realWordCheck(String word) throws IOException, URISyntaxException {
        IWordSource wordSource = new ApiWordSource("https://lingo-words.herokuapp.com");
        boolean validWord = wordSource.checkWord(word);
        return validWord;
    }

    private boolean validGameWordCheck(String word) {
        return word.matches("^[a-z]{5,7}+$");
    }
}
