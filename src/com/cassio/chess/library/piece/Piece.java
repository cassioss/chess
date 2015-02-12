package com.cassio.chess.library.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
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
        setColor(color);
    }

    public void bePutOnBoard(Board chessBoard, int initialX, int initialY) {
        this.chessBoard = chessBoard;
        posX = initialX;
        posY = initialY;
    }

    public Color getColor() {
        return this.pieceColor;
    }

    private void setColor(Color color) {
        this.pieceColor = color;
    }

    public Board getBoard() {
        return chessBoard;
    }

    protected void checkPlayerPieceAt(int targetX, int targetY) throws SamePieceColorException {
        if (!basicConditionsToMoveTo(targetX, targetY))
            throw new SamePieceColorException("You tried to capture a Piece of the same color.");
    }

    protected void checkMovementToTheSamePlace(int targetX, int targetY) throws SamePlaceMoveException {
        if (targetX == posX && targetY == posY)
            throw new SamePlaceMoveException("You tried to move your piece to the same place.");
    }

    protected void moveSanityCheck(int targetX, int targetY) {
        try {
            checkPlayerPieceAt(targetX, targetY);
            checkMovementToTheSamePlace(targetX, targetY);
        } catch (SamePieceColorException e) {
            e.printStackTrace();
        } catch (SamePlaceMoveException e){
            e.printStackTrace();
        }
    }

    protected boolean basicConditionsToMoveTo(int targetX, int targetY) {
        return noPieceAt(targetX, targetY) || opponentPieceAt(targetX, targetY);
    }

    protected boolean noPieceAt(int targetX, int targetY) {
        return chessBoard.maze[targetX][targetY].getPiece() == null;
    }

    protected boolean opponentPieceAt(int targetX, int targetY) {
        return chessBoard.maze[targetX][targetY].getPiece().getColor() == this.pieceColor;
    }

    public abstract void moveTo(int targetX, int targetY);

    protected abstract boolean validMovement(int targetX, int targetY) throws IllegalChessMoveException;

}
