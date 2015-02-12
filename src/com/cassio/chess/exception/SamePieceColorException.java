package com.cassio.chess.exception;

/**
 * Created by Cassio on 11/02/2015.
 */
public class SamePieceColorException extends RuntimeException {
    public SamePieceColorException(String message) {
        super(message);
    }
}
