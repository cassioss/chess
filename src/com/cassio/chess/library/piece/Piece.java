package com.cassio.chess.library.piece;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
 */

public class Piece {
    
    private Color pieceColor;

    public Piece(Color color) {
        setColor(color);
    }

    public Color getColor(){
        return pieceColor;
    }
    
    private void setColor(Color color){
        this.pieceColor = color;
    }
}
