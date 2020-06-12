package lingo.game.domain.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoundTest {

    public RoundTest() {
    }

    @Test
    @DisplayName("Round Creation Object Test")
    public void roundObjectTest() throws IOException, URISyntaxException {
        Round round = new Round(new Word("pinda"), new Turn(1, 10));
        Assertions.assertEquals("pinda", round.getWord().getWord());
        Assertions.assertEquals(1, round.getTurns().get(0).getTurnNumber());
    }

    @Test
    @DisplayName("Round correctLetterIndexList Test")
    public void roundLetterIndexTest() throws IOException, URISyntaxException {
        Round round = new Round(new Word("pinda"), new Turn(1, 10));
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(0);
        indexList.add(1);
        round.setWordPartsIndexes(indexList);

        Assertions.assertEquals("pi___", round.getWordParts());
        Assertions.assertEquals(indexList, round.getWordPartsIndexes());
    }

    @Test
    @DisplayName("Round correctLetterIndexList random letters Test")
    public void roundLetterIndexRandomTest() throws IOException, URISyntaxException {
        Round round = new Round(new Word("pinda"), new Turn(1, 10));
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        indexList.add(0);
        indexList.add(2);
        round.setWordPartsIndexes(indexList);

        Assertions.assertEquals("p_n__", round.getWordParts());
        Assertions.assertEquals(indexList, round.getWordPartsIndexes());
    }



}
