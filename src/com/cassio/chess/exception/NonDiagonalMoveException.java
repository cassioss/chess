package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class NonDiagonalMoveException extends IllegalChessMoveException {
    public NonDiagonalMoveException(String message) {
        super(message);
    }
}
