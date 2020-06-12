package lingo.game.domain.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TurnTest {

    public TurnTest() {
    }

    @Test
    @DisplayName("Turn Creation Object Test")
    public void turnObjectTest() throws IOException, URISyntaxException {
        Turn turn    = new Turn(1,10);
        Assertions.assertEquals(1,turn.getTurnNumber());
        Assertions.assertEquals(10,turn.getTimer());
    }

    @Test
    @DisplayName("Turn timer Test")
    public void turnTimerTest() throws IOException, URISyntaxException {
        Turn turn    = new Turn(1,10);
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, 11);
        Assertions.assertFalse(turn.inTime(cal.getTime()));
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, 5);
        Assertions.assertTrue(turn.inTime(cal.getTime()));
    }

    @Test
    @DisplayName("Turn user input Test")
    public void turnUserInputTest() throws IOException, URISyntaxException {
        Turn turn = new Turn(1, 10);
        turn.setPlayerInput("hallo");
        Assertions.assertEquals("hallo",turn.getPlayerInput());
    }


}
