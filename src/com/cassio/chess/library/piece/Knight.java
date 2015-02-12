package com.cassio.chess.library.piece;

import java.awt.*;

/**
 * Created by Cassio on 11/02/2015.
 */
public class Knight extends Piece {

    public boolean isInCheck, isInCheckMate;

    public Knight(Color color) {
        super(color);
        check();
        checkMate();
    }

    private void check() {
    }

    private void checkMate() {
        if (isInCheck) {

        }
    }

    @Override
    public void moveTo(int targetX, int targetY) {

    }

    @Override
    protected boolean validMovement(int targetX, int targetY) {
        return false;
    }
}
