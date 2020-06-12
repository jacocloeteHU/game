package lingo.game.domain.model;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private Round round;
    private boolean active;
    private String gameKey;
    private int wordLength;
    private int score;

    public Game() {
        wordLength = 5;
        score = 0;
    }

    public Game(String gameKey) {
        this();
        this.gameKey = gameKey;
    }

    public String getGameKey() {
        return gameKey;
    }

    public void setGameKey(String gameKey) {
        this.gameKey = gameKey;
    }

    public void setRound(Round round)
    {
        this.round = round;
    }

    public int getWordLength(){
        return this.wordLength;
    }

    public void reset(){
        this.wordLength = 5;
        this.score = 0;
    }

    public void addWordLength(){
        if(wordLength < 7){
            this.wordLength += 1;
        } else {
            this.wordLength = 5;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void addScore(int turns){
        this.score += (5 - turns) * 10;
    }

    public void start(){
        active = true;
    }

    public void stop(){
        active = false;
    }

    public Round getRound() {
        return round;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Game{" +
                "round=" + round +
                ", active=" + active +
                ", score=" + score +
                ", gameKey=" + gameKey +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameKey, game.gameKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, active, gameKey, wordLength, score);
    }
}
