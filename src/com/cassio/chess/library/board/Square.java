package com.cassio.chess.library.board;

import com.cassio.chess.exception.NoPieceException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.library.piece.Piece;

import java.awt.*;

/**
 * Created by Cassio dos Santos Sousa on 07/02/2015.
 */

public class Square {

    public Square() {
        setScore(0);
    }

    private int score;
    private Piece squarePiece;
    protected Color squareColor;

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }

    public Piece getPiece() {
        return squarePiece;
    }

    public Color getSquareColor() {
        return squareColor;
    }

    public boolean hasPiece() {
        return this.squarePiece != null;
    }

    public boolean hasSameColor(Piece firstPiece, Piece secondPiece) {
        return firstPiece.getColor() == secondPiece.getColor();
    }

    public void putPiece(Piece piece) {
        this.squarePiece = piece;
        if (piece.getColor() == Color.BLACK)
            setScore(-1);
        else if (piece.getColor() == Color.WHITE)
            setScore(1);
    }

    public void captureAndPut(Piece piece) throws SamePieceColorException {
        if (!hasSameColor(piece, getPiece())) {
            movePiece();
            putPiece(piece);
        } else
            throw new SamePieceColorException("You tried to capture a piece of the same color.");
    }

    public void movePiece() {
        if (hasPiece()) {
            this.squarePiece = null;
            setScore(0);
        } else
            throw new NoPieceException("You tried to move a piece that does not exist.");
    }
}
