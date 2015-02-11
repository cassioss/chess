package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.Piece;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
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

    public Piece getPiece(){
        return squarePiece;
    }
    
    public void putPiece(Piece piece) {
        this.squarePiece = piece;
    }

    public Color getSquareColor() {
        return squareColor;
    }
}
