package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.Piece;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
 */

public class Square {
    
    public Square(int xPos, int yPos) {
        setX(xPos);
        setY(yPos);
        setScore(0);
    }

    private int xPos;
    private int yPos;
    private int score;
    private String xString;
    private Piece squarePiece;
    protected Color squareColor;

    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }
    
    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }
    
    private void setX(int x) {
        this.xPos = x;
    }

    private void setY(int y) {
        this.yPos = y;
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
