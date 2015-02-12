package com.cassio.chess.library.piece;

import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.Board;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
 */

public abstract class Piece {

    protected Color pieceColor;
    protected int posX, posY;
    protected Board chessBoard;

    public Piece(Color color) {
        this.pieceColor = color;
    }

    public void bePutOnBoard(Board chessBoard, int initialX, int initialY) {
        this.chessBoard = chessBoard;
        posX = initialX;
        posY = initialY;
    }

    public Color getColor() {
        return this.pieceColor;
    }

    /**
     * As basic condition for moves, the player cannot capture his own piece.
     *
     * @param targetX - desired X-coordinate of the piece
     * @param targetY - desired Y-coordinate of the piece
     * @return <code>true</code> if the basic condition is met
     */

    protected boolean basicConditionToMoveTo(int targetX, int targetY) {
        return noPieceAt(targetX, targetY) || opponentPieceAt(targetX, targetY);
    }

    protected void checkPlayerPieceAt(int targetX, int targetY) {
        if (!basicConditionToMoveTo(targetX, targetY))
            throw new SamePieceColorException("You tried to capture a Piece of the same color.");
    }

    protected void checkMovementToTheSamePlace(int targetX, int targetY) {
        if (targetX == posX && targetY == posY)
            throw new SamePlaceMoveException("You tried to move your piece to the same place.");
    }

    protected void moveSanityCheck(int targetX, int targetY) {
        checkMovementToTheSamePlace(targetX, targetY);
        checkPlayerPieceAt(targetX, targetY);
    }

    protected boolean noPieceAt(int targetX, int targetY) {
        return chessBoard.maze[targetX][targetY].getPiece() == null;
    }

    protected boolean opponentPieceAt(int targetX, int targetY) {
        return chessBoard.maze[targetX][targetY].getPiece() != null &&
                chessBoard.maze[targetX][targetY].getPiece().getColor() != this.pieceColor;
    }

    public void moveTo(int targetX, int targetY) {
        if (validMovement(targetX, targetY)) {
            chessBoard.maze[posX][posY].movePiece();
            chessBoard.maze[targetX][targetY].putPiece(this);
            posX = targetX;
            posY = targetY;
        }
    }

    protected abstract boolean validMovement(int targetX, int targetY);

}
