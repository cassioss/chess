package com.cassio.chess.library.piece;

import com.cassio.chess.exception.BlockingPieceException;
import com.cassio.chess.exception.NonDiagonalMoveException;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    protected boolean validMovement(int targetX, int targetY) {
        moveSanityCheck(targetX, targetY);
        checkNonDiagonalMoveException(targetX, targetY);
        checkPieceInTheWay(targetX, targetY);
        return true;
    }

    /**
     * Checks exceptions for non-diagonal moves - Bishops only move diagonally
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     * @throws NonDiagonalMoveException - the Bishop's move was not diagonal
     */
    private void checkNonDiagonalMoveException(int targetX, int targetY) {
        if (targetX == posX || Math.abs(targetX - posX) != Math.abs(targetY - posY))
            throw new NonDiagonalMoveException("You did not try to move your Bishop diagonally.");
    }

    private void checkPieceInTheWay(int targetX, int targetY) {
        if (targetX > posX) {
            if (targetY > posY) checkPiecesDiagonally(posX, posY, targetX - posX);
            else checkPiecesDiagonally(posX, targetY, targetX - posX);
        } else {
            if (targetY > posY) checkPiecesDiagonally(targetX, posY, posX - targetX);
            else checkPiecesDiagonally(targetX, targetY, posX - targetX);
        }
    }

    private void checkPiecesDiagonally(int smallX, int smallY, int difference) {
        for(int diff = 1; diff < difference; diff++){
            if(chessBoard.hasPieceAt(smallX + diff, smallY + diff))
                throw new BlockingPieceException("There is a Piece in the way of the Bishop.");
        }
    }
}
