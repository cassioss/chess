package com.cassio.chess.exception.board;

/**
 * {@code PieceInPlaceException} class - called whenever a piece is set or created on the same place as another piece.
 * This exception is not related to piece moves or captures.
 */
public class PieceInPlaceException extends RuntimeException {

    /**
     * Throws an PieceInPlaceException and returns a message to the user.
     *
     * @param message an error message related to the exception clause.
     */
    public PieceInPlaceException(String message) {
        super(message);
    }
}