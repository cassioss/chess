package com.cassio.chess.exception.board;

/**
 * {@code AlreadyHasPieceException class} - called whenever a piece is set or created on the same place as another
 * piece. This exception is not related to piece moves or captures.
 */
public class AlreadyHasPieceException extends RuntimeException {

    /**
     * Throws an AlreadyHasPieceException and returns a message to the user.
     *
     * @param message an error message related to the exception clause.
     */
    public AlreadyHasPieceException(String message) {
        super(message);
    }
}
