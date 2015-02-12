package com.cassio.chess.library.piece;

import com.cassio.chess.exception.HorizontalMoveException;
import com.cassio.chess.exception.NonKnightMoveExcption;
import com.cassio.chess.exception.VerticalMoveException;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    protected boolean validMovement(int targetX, int targetY) {
        moveSanityCheck(targetX, targetY);
        checkNonKnightMoveExceptions(targetX, targetY);
        checkLinearMoveExceptions(targetX, targetY);
        return true;
    }

    /**
     * Checks exceptions for vertical and horizontal moves of Knights.
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     */

    private void checkLinearMoveExceptions(int targetX, int targetY) {
        if (targetX == posX)
            throw new VerticalMoveException("You tried to move your Knight vertically.");
        if (targetY == posY)
            throw new HorizontalMoveException("You tried to move your Knight horizontally.");
    }

    /**
     * Checks exceptions for non-Knight moves - basically every non-linear (horizontal or vertical) displacement 
     * where the Manhattam sum (vertical displacement + horizontal displacement) is equal to 3.
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     */
    private void checkNonKnightMoveExceptions(int targetX, int targetY) {
        if(Math.abs(targetX - posX) + Math.abs(targetY - posY) != 3)
            throw new NonKnightMoveExcption("You did not perform a Knight (L-form) move");
    }


}
