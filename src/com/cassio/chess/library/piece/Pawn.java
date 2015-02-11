package com.cassio.chess.library.piece;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    protected void moveTo(int targetX, int targetY) {

    }

    @Override
    protected boolean validMovement(int targetX, int targetY) {
        return false;
    }
}
