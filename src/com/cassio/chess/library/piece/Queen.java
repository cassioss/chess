package com.cassio.chess.library.piece;

import com.cassio.chess.exception.BlockingPieceException;
import com.cassio.chess.exception.NonQueenMoveException;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Queen extends Piece {
    public Queen(Color color) {
        super(color);
    }

    protected boolean validMovement(int targetX, int targetY) {
        moveSanityCheck(targetX, targetY);
        checkNonQueenMoveExceptions(targetX, targetY);
        return true;
    }

    /**
     * Checks exceptions for Queen moves - Queens can move diagonally, vertically or horizontally in any direction.
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     * @throws com.cassio.chess.exception.NonQueenMoveException - not a valid Queen movement
     */
    private void checkNonQueenMoveExceptions(int targetX, int targetY) {
        if (targetX != posX && targetY != posY) {
            if (Math.abs(targetX - posX) != Math.abs(targetY - posY)) {
                throw new NonQueenMoveException("The Queen has not tried a diagonal, horizontal or vertical move.");
            } else {
                checkDiagonalMoveBlockage(targetX, targetY);
            }
        } else { checkLinearMoveBlockage(targetX, targetY);}
    }
    
    // Checks if there are Pieces in a diagonal move

    private void checkDiagonalMoveBlockage(int targetX, int targetY) {
        if (targetX > posX) {
            if (targetY > posY) checkPiecesDiagonally(posX, posY, targetX - posX);
            else checkPiecesDiagonally(posX, targetY, targetX - posX);
        } else {
            if (targetY > posY) checkPiecesDiagonally(targetX, posY, posX - targetX);
            else checkPiecesDiagonally(targetX, targetY, posX - targetX);
        }
    }

    private void checkPiecesDiagonally(int smallX, int smallY, int difference) {
        for (int diff = 1; diff < difference; diff++) {
            if (chessBoard.hasPieceAt(smallX + diff, smallY + diff))
                throw new BlockingPieceException("There is a Piece in the way of the Queen");
        }
    }

    // Checks if there are Pieces in a linear move

    private void checkLinearMoveBlockage(int targetX, int targetY) {
        if(targetX != posX){
            if(targetX > posX) checkPiecesInVerticalLine(posX, targetX);
            else checkPiecesInVerticalLine(targetX, posX);
        }
        if(targetY != posY){
            if(targetY > posY) checkPiecesInHorizontalLine(posY, targetY);
            else checkPiecesInHorizontalLine(targetY, posY);
        }
    }

    private void checkPiecesInVerticalLine(int smallX, int bigX) {
        for(int verifyX = smallX +1; verifyX < bigX; verifyX++)
            if(chessBoard.hasPieceAt(verifyX, posY))
                throw new BlockingPieceException("There is a piece in the way of the Queen.");
    }

    private void checkPiecesInHorizontalLine(int smallY, int bigY) {
        for(int verifyY = smallY +1; verifyY < bigY; verifyY++)
            if(chessBoard.hasPieceAt(posX, verifyY))
                throw new BlockingPieceException("There is a piece in the way of the Queen.");
    }
}
