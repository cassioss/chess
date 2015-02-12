package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class VerticalMoveException extends IllegalChessMoveException {
    public VerticalMoveException(String message) {
        super(message);
    }
}
