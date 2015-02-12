package com.cassio.chess.library.board;

import com.cassio.chess.exception.NoPieceException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.library.piece.Piece;

import java.awt.*;

/**
 * Square class - describes a chessboard square and its properties (color, score and piece).
 *
 * @author Cassio dos Santos Sousa
 */

public class Square {

    public Square() {
        setScore(0);
        squarePiece = null;
    }

    private int score;
    private Piece squarePiece;
    protected Color squareColor;

    // Simple getters and setters

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

    public void putPiece(Piece newPiece) {
        if (hasPiece() && hasSameColor(this.squarePiece, newPiece))
            throw new SamePieceColorException("You tried to capture your own piece.");
        else {
            if (hasPiece()) movePiece();
            putNewPiece(newPiece);
        }
    }

    public void movePiece() {
        if (hasPiece()) {
            this.squarePiece = null;
            setScore(0);
        } else throw new NoPieceException("You tried to move a piece that does not exist.");
    }

    private void putNewPiece(Piece piece) {
        this.squarePiece = piece;
        if (piece.getColor() == Color.BLACK)
            setScore(-1);
        else if (piece.getColor() == Color.WHITE)
            setScore(1);
    }
}
