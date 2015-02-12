package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class NonQueenMoveException extends IllegalChessMoveException {
    public NonQueenMoveException(String message) {
        super(message);
    }
}
