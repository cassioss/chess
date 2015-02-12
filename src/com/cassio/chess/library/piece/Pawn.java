package com.cassio.chess.library.piece;

import com.cassio.chess.exception.*;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public void moveTo(int targetX, int targetY) {
        try {
            if (validMovement(targetX, targetY)) {
                chessBoard.maze[posX][posY].movePiece();
                chessBoard.maze[targetX][targetY].putPiece(this);
            }
        } catch (IllegalChessMoveException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean validMovement(int targetX, int targetY) {
        super.moveSanityCheck(targetX, targetY);
        checkDiagonalMoveException(targetX, targetY);
        checkHorizontalMoveException(targetX, targetY);
        checkVerticalMoveExceptions(targetX,targetY);
    }
    
    private void checkDiagonalMoveException(int targetX, int targetY) {
        if (targetX - posX == targetY - posY)
            throw new DiagonalMoveException("You tried to move your pawn diagonally.");
            
    }

    private void checkHorizontalMoveException(int targetX, int targetY) {
        if (targetY == posY && targetX != posX)
            throw new HorizontalMoveException("You tried to move a pawn horizontally.");
    }
    
    private void checkVerticalMoveExceptions(int targetX, int targetY) {
        if(targetX == posX && Math.abs(targetY - posY) > 1)
            throw new VerticalMoveException("You tried to move a pawn ");
        
    }

}
