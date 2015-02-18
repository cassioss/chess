package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * Created by Cassio on 16/02/2015.
 */
public class Knight extends Piece {
    /**
     * Creates a knight based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Knight(boolean colorChoice) {
        super(colorChoice);
    }

    /**
     * Abstract method to update a piece's move set.
     */
    @Override
    protected void updateMoveSet() {

    }

    /**
     * Gets a MoveSet implementation to ease updating. This method is only called by a chessboard.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    @Override
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {

    }
}
