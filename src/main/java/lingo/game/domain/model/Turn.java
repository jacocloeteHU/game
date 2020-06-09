package lingo.game.domain.model;

import java.util.ArrayList;
import java.util.Objects;

public class Turn {
    private int timer;
    private String playerInput;
    private Feedback feedback;
    private int turnNumber;
    public Turn(int turnNumber, int timer) {
        this.turnNumber = turnNumber;
        this.timer = timer;
        this.playerInput = null;
        this.feedback = null;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
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
        return Objects.equals(playerInput, turn.playerInput) &&
                Objects.equals(feedback, turn.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerInput, feedback);
    }
}
