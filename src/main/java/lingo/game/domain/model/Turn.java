package lingo.game.domain.model;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Turn {
    private int timer;
    private String playerInput;
    private Feedback feedback;
    private int turnNumber;
    private Date timeStamp;

    public Turn(int turnNumber, int timer) {
        this.turnNumber = turnNumber;
        this.timer = timer;
        this.playerInput = null;
        this.feedback = null;
        this.timeStamp = new Date();
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public int getTimer() {
        return timer;
    }

    public boolean inTime(Date currentTime){
        long seconds = (currentTime.getTime()-this.timeStamp.getTime())/1000;
        System.out.println(seconds <= 10);
        System.out.println(seconds);
        return seconds <= 10;
    }

    public String getPlayerInput() {
        return playerInput;
    }

    public void setPlayerInput(String playerInput) {
        this.playerInput = playerInput;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "timer=" + timer +
                ", playerInput='" + playerInput + '\'' +
                ", feedback=" + feedback +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turn turn = (Turn) o;
        return timer == turn.timer &&
                turnNumber == turn.turnNumber &&
                Objects.equals(playerInput, turn.playerInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timer, playerInput, turnNumber);
    }
}
