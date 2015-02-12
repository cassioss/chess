package com.cassio.chess.library.piece;

import com.cassio.chess.exception.DiagonalMoveException;
import com.cassio.chess.exception.IllegalChessMovementException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMovementException;

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
        } catch (IllegalChessMovementException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean validMovement(int targetX, int targetY) {
        try {
            super.moveSanityCheck(targetX, targetY);
            checkDiagonalMove(targetX, targetY);
            
        } catch (IllegalChessMovementException e) {
            e.printStackTrace();
        } catch (SamePlaceMovementException e){
            e.printStackTrace();
        } catch (SamePieceColorException e){
            e.printStackTrace();
        }
    }
    
    private void checkDiagonalMove(int targetX, int targetY) throws DiagonalMoveException {
        if (targetX - posX == targetY - posY)
            throw new DiagonalMoveException("You tried to move your pawn diagonally.");
            
    }

    private void checkHorizontalMove(int targetX, int targetY) throws IllegalChessMovementException {
        if (targetY == posY && targetX != posX)
            throw new IllegalChessMovementException("You tried to move a pawn horizontally.");
    }
    
    private void checkRookVerticalMove(int targetX, int targetY) throws IllegalChessMovementException {
        if(targetX == posX && Math.abs(targetY - posY) > 1)
            
        
    }

}
