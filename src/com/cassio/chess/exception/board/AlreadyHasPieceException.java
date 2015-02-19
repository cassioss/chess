package com.cassio.chess.exception.board;

/**
 * {@code AlreadyHasPieceException} class - called whenever a piece is set twice in a board.
 */
public class AlreadyHasPieceException extends RuntimeException {

    /**
     * Throws an InGameException and returns a message to the user.
     *
     * @param message an error message related to the exception clause.
     */
    public AlreadyHasPieceException(String message) {
        super(message);
    }
}