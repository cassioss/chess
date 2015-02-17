package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Square;

import java.util.HashSet;

/**
 * <code>Piece</code> class - defines basic attributes of a piece (color and moveSet). The creation of a piece and its
 * positioning (as well as implementation of moves) is dependent on the board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */

public abstract class Piece {

    protected boolean isBlack;
    protected HashSet<Square> moveSet;

    /**
     * Creates a piece based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Piece(boolean colorChoice) {
        isBlack = colorChoice;
        moveSet = new HashSet<Square>();
    }

    /**
     * Gets the color choice of the piece.
     *
     * @return {@code true} if the piece color is black, {@code false} if the piece color is white.
     */
    public boolean isBlack() {
        return this.isBlack;
    }

    /**
     * Gets the set of available moves (squares) for a piece. It is implemented as a HashSet to benefit from O(1)
     * searches and non-repeated squares.
     *
     * @return a HashSet of available squares that the piece can move to.
     */
    public HashSet<Square> getMoveSet() {
        return moveSet;
    }


}
