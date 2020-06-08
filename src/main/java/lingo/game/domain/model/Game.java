package lingo.game.domain.model;

import java.util.ArrayList;

public class Game {
    private ArrayList<Round> rounds;
    private boolean active;
    private int score;

    public Game() {
        rounds = new ArrayList<Round>();
        score = 0;
    }

    public void addRound(Round round){
        rounds.add(round);
    }

    public void addScore(int score){
        this.score += score;
    }

    public void start(){
        active = true;
    }

    public void stop(){
        active = false;
    }

    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public Round getCurrentRound(){
        int i = rounds.size() - 1;
        return rounds.get(i);
    }

    public int getScore() {
        return score;
    }
}
