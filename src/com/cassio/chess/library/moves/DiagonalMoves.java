package com.cassio.chess.library.moves;

/**
 * Created by Cassio on 15/02/2015.
 */
public class DiagonalMoves extends Moves {

    @Override
    protected void getMoves() {
        getInfiniteDiagonalPaths();
    }
}
