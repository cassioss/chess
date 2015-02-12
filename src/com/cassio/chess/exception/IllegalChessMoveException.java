package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class IllegalChessMoveException extends RuntimeException {
    public IllegalChessMoveException(String message) {
        super(message);
    }
}
