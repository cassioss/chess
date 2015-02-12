package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class IllegalChessMovementException extends RuntimeException {
    public IllegalChessMovementException(String message) {
        super(message);
    }
}
