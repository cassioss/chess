package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class NonLinearMoveException extends IllegalChessMoveException {
    public NonLinearMoveException(String message) {
        super(message);
    }
}
