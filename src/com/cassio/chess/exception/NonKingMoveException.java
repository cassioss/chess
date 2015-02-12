package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class NonKingMoveException extends IllegalChessMoveException {
    public NonKingMoveException(String message) {
        super(message);
    }
}
