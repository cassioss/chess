package com.cassio.chess.library.piece;

import com.cassio.chess.exception.*;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    /**
     * Checks if a Rook movement is valid - a Rook can only move vertically or horizontally, without pieces in the way
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     * @return <code>true</code> if there is no Exception (illegal Chess move)
     */

    protected boolean validMovement(int targetX, int targetY) {
        moveSanityCheck(targetX, targetY);
        checkNonLinearMoveException(targetX, targetY);
        checkPiecesInTheWay(targetX, targetY);
        return true;
    }

    /**
     * Checks exceptions for non-linear moves of Rooks.
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     * @throws com.cassio.chess.exception.NonLinearMoveException - the Rook did not perform a vertical/horizontal move
     */
    private void checkNonLinearMoveException(int targetX, int targetY) {
        if (targetX != posX && targetY != posY)
            throw new NonLinearMoveException("You tried to move a Rook in a non-linear way.");
    }

    /**
     * Checks for pieces in the Rook's way.
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     * @throws com.cassio.chess.exception.BlockingPieceException - there was a piece in the way
     */
    private void checkPiecesInTheWay(int targetX, int targetY) {
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
                throw new BlockingPieceException("There is a piece in the way of the Rook.");
    }

    private void checkPiecesInHorizontalLine(int smallY, int bigY) {
        for(int verifyY = smallY +1; verifyY < bigY; verifyY++)
            if(chessBoard.hasPieceAt(posX, verifyY))
                throw new BlockingPieceException("There is a piece in the way of the Rook.");
    }

}
