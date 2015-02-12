package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class AlreadyHasPieceException extends RuntimeException {
    public AlreadyHasPieceException(String message) {
        super(message);
    }
}
