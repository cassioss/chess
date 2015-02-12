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
    protected boolean validMovement(int targetX, int targetY) {
        moveSanityCheck(targetX, targetY);
        checkHorizontalMoveException(targetX, targetY);
        checkVerticalMoveExceptions(targetX, targetY);
        checkDiagonalMoveExceptions(targetX, targetY);
        checkOtherMoveExceptions(targetX, targetY);
        return true;
    }

    private void checkHorizontalMoveException(int targetX, int targetY) {
        if (targetY == posY && targetX != posX)
            throw new HorizontalMoveException("You tried to move your Pawn horizontally.");
    }

    private void checkVerticalMoveExceptions(int targetX, int targetY) {
        if (targetX == posX) {
            if (pieceColor == Color.WHITE)
                checkWhitePawnVerticalMoveExceptions(targetY);
            if (pieceColor == Color.BLACK)
                checkBlackPawnVerticalMoveExceptions(targetY);
        }
    }

    private void checkWhitePawnVerticalMoveExceptions(int targetY) {
        if (targetY - posY > 1)
            throw new PieceColorMoveException("You tried to move your white Pawn too many squares up.");
        if (targetY - posY <= -1)
            throw new PieceColorMoveException("You tried to move your white Pawn downwards.");
    }

    private void checkBlackPawnVerticalMoveExceptions(int targetY) {
        if (targetY - posY < -1)
            throw new PieceColorMoveException("You tried to move your black Pawn too many squares down.");
        if (targetY - posY >= 1)
            throw new PieceColorMoveException("You tried to move your black Pawn upwards.");
    }

    private void checkDiagonalMoveExceptions(int targetX, int targetY) {
        if (Math.abs(targetX - posX) == Math.abs(targetY - posY)) {
            if (pieceColor == Color.WHITE)
                checkWhitePawnDiagonalMoveExceptions(targetX,targetY);
            if (pieceColor == Color.BLACK)
                checkBlackPawnDiagonalMoveExceptions(targetX,targetY);
        }
    }

    private void checkWhitePawnDiagonalMoveExceptions(int targetX, int targetY) {
        if (targetY - posY > 1)
            throw new PieceColorMoveException("You tried to move your white Pawn too many squares diagonally up.");
        if (targetY - posY <= -1)
            throw new PieceColorMoveException("You tried to move your white Pawn downwards.");
        if (targetY - posY == 1 && !opponentPieceAt(targetX, targetY))
            throw new NoPawnCaptureException("Your white Pawn will not capture any piece.");
    }

    private void checkBlackPawnDiagonalMoveExceptions(int targetX, int targetY) {
        if (Math.abs(targetY - posY) < -1)
            throw new PieceColorMoveException("You tried to move your black Pawn too many squares diagonally down.");
        if (Math.abs(targetY - posY) > 1)
            throw new PieceColorMoveException("You tried to move your black Pawn upwards.");
        if (targetY - posY == -1 && !opponentPieceAt(targetX, targetY))
            throw new NoPawnCaptureException("Your black Pawn will not capture any piece.");
    }

    private void checkOtherMoveExceptions(int targetX, int targetY) {
        if(Math.abs(targetX - posX) > 1 || Math.abs(targetY - posY) > 1)
            throw new IllegalChessMoveException("Illegal movement for Pawn piece.");
    }

}
