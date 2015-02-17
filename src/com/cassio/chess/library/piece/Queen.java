package com.cassio.chess.library.piece;

/**
 * Created by Cassio on 16/02/2015.
 */
public class Queen extends Piece {
    /**
     * Creates a queen based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Queen(boolean colorChoice) {
        super(colorChoice);
    }
}
