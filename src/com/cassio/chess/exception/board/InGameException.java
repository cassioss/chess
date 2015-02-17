package com.cassio.chess.exception.board;

/**
 * {@code InGameException class} - called whenever a piece is set or created after a game has already begun, regardless
 * of having a piece at the same square or not.
 */
public class InGameException extends RuntimeException {

    /**
     * Throws an InGameException and returns a message to the user.
     *
     * @param message an error message related to the exception clause.
     */
    public InGameException(String message) {
        super(message);
    }
}
