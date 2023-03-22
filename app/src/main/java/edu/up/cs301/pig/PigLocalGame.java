package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.MyNameIsAction;
import edu.up.cs301.game.actionMsg.ReadyAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState pgs;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //instantiating a new piggamestate
        pgs = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == pgs.getPlayerId()){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        GamePlayer player = action.getPlayer();
        int whodis = getPlayerIdx(player);
        boolean pigHoldAction = action instanceof PigHoldAction;
        boolean pigRollAction = action instanceof PigRollAction;

        if(pigHoldAction && !pigRollAction) {
            if(whodis == 1) {
                pgs.setPlayer1score(pgs.getPlayer1score() + 1);
                pgs.setRunningTotal(0);
                if(players.length == 2) {
                    action.setPlayer(players[1]);
                }
            }else {
                pgs.setPlayer2score(pgs.getPlayer2score() + 1);
                pgs.setRunningTotal(0);
                if(players.length == 2) {
                    action.setPlayer(players[0]);
                }
            }
            return true;
        }else if (pigRollAction && !pigHoldAction) {
            int value = (int) (Math.random() * 6) + 1;
            if(value != 1) {
                pgs.setDieVal(value);
            }else {
                pgs.setRunningTotal(0);
            }
            return true;
        }else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState piggy = pgs;
        p.sendInfo(piggy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        String winner;
        if(pgs.getPlayer1score() == 50) {
            return winner = "Player 1 won! Waowzers";
        }else if(pgs.getPlayer2score() == 50) {
            return winner = "Player 2 won! Waowzers";
        }
        return null;
    }

}// class PigLocalGame
