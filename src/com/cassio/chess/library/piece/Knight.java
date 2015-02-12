package com.cassio.chess.library.piece;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public void moveTo(int targetX, int targetY) {

    }

    @Override
    protected boolean validMovement(int targetX, int targetY) {
        return false;
    }
}
