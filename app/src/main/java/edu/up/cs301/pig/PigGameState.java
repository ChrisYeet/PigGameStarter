package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int playerId;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayer1score() {
        return player1score;
    }

    public void setPlayer1score(int player1score) {
        this.player1score = player1score;
    }

    public int getPlayer2score() {
        return player2score;
    }

    public void setPlayer2score(int player2score) {
        this.player2score = player2score;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public int getDieVal() {
        return dieVal;
    }

    public void setDieVal(int dieVal) {
        this.dieVal = dieVal;
    }

    private int player1score;
    private int player2score;
    private int runningTotal;
    private int dieVal;

    public PigGameState() {
        playerId = 0;
        player1score = 0;
        player2score = 0;
        runningTotal = 0;
        dieVal = 0;
    }

    public PigGameState(PigGameState other) {
        this.playerId = getPlayerId();
        this.player1score = getPlayer1score();
        this.player2score = getPlayer2score();
        this.runningTotal = getRunningTotal();
        this.dieVal = getDieVal();
    }
}
