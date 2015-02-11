package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
 */

public abstract class Piece {

    protected Color pieceColor;
    private int posX, posY;
    private Board chessBoard;

    public Piece(Color color) {
        setColor(color);
    }
    
    public void bePutOnBoard(Board chessBoard, Square initialSquare){
        this.chessBoard = chessBoard;
    }

    public Color getColor() {
        return this.pieceColor;
    }

    private void setColor(Color color) {
        this.pieceColor = color;
    }

    protected abstract void moveTo(int targetX, int targetY);
    protected abstract boolean validMovement(int targetX, int targetY);
}
