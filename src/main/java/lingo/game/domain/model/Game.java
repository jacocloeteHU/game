package lingo.game.domain.model;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private Round round;
    private boolean active;
    private String gameKey;
    private int score;

    public Game() {
  //      rounds = new ArrayList<Round>();
        score = 0;
    }

    public Game(String gameKey) {
  //      rounds = new ArrayList<Round>();
        score = 0;
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

    public void addScore(int turns){
        turns = turns;
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

/*    public Round getCurrentRound(){
        int i = rounds.size() - 1;
        return rounds.get(i);
    }*/

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
        return Objects.hash(gameKey);
    }

/*    public void setCurrentRound(Round currentRound) {
        int i = rounds.size() - 1;
        rounds.set(i, currentRound);
    }*/
}
