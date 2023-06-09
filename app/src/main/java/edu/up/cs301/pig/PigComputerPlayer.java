package edu.up.cs301.pig;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState pgs = new PigGameState((PigGameState) info);

        if (playerNum != pgs.getPlayerId()) {
            return;
        }

        int chance = (int) (Math.random() * 2);
        if (chance == 0) {
            PigHoldAction hold = new PigHoldAction(this);
            game.sendAction(hold);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // handle the exception
                e.printStackTrace();
            }
        } else {
            PigRollAction roll = new PigRollAction(this);
            game.sendAction(roll);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // handle the exception
                e.printStackTrace();
            }
        }
    }//receiveInfo

}
