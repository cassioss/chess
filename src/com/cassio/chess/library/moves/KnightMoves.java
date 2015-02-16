package com.cassio.chess.library.moves;

/**
 * Created by Cassio on 15/02/2015.
 */
public class KnightMoves extends Moves {

    public KnightMoves() {
        super();
    }

    /**
     * Adds all the possible moves for a Knight. His moves have an L-shape that counts for three squares of distance.
     */
    protected void getMoves() {

        // L-shape movement: one square for the lower displacement, two squares for the bigger displacement

        for (int range = 1; range <= 2; range++) {
            addSquareWithReference(range, 3 - range);
            addSquareWithReference(range, range - 3);
            addSquareWithReference(-range, 3 - range);
            addSquareWithReference(-range, range - 3);
        }

    }
}
