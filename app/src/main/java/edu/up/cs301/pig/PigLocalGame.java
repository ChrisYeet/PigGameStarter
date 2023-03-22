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
        //determine if player id given matches the id of the player of the
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
        boolean pigHoldAction = action instanceof PigHoldAction;
        boolean pigRollAction = action instanceof PigRollAction;

        if(pigHoldAction) {

        }else if (pigRollAction) {

        }else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //makes a copy of current game state
        //use send info from game player to the given player object
        PigGameState pgsCopy = pgs;
        p.sendInfo(pgsCopy);

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
        //check if player's score meets or exceeds 50
        //if game is over, return the name of player and their score
        String winner;
        if(pgs.getPlayer1score() >= 50){
            winner = "Player 1 Won! Score: " + pgs.getPlayer1score();
            return winner;
        }
        else if(pgs.getPlayer2score() >= 50){
            winner = "Player 2 Won! Score: " + pgs.getPlayer2score();
            return winner;
        }
        return null;
    }

}// class PigLocalGame
