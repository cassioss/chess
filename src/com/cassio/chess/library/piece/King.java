package com.cassio.chess.library.piece;

import com.cassio.chess.exception.NonKingMoveException;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class King extends Piece {

    public boolean isInCheck, isInCheckMate;

    public King(Color color) {
        super(color);
        isInCheck = false;
        isInCheckMate = false;
    }

    private void check() {}

    private void checkMate() {}


    protected boolean validMovement(int targetX, int targetY) {
        moveSanityCheck(targetX, targetY);
        checkNonKingMoveException(targetX, targetY);
        return !isInCheck;
    }

    private void checkNonKingMoveException(int targetX, int targetY) {
        if(Math.abs(targetX - posX) > 1 || Math.abs(targetY - posY) > 1)
            throw new NonKingMoveException("You tried to make an invalid move for the King.");
    }
}
