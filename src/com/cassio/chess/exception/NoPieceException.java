package com.cassio.chess.exception;

/**
 * Created by Cassio on 11/02/2015.
 */
public class NoPieceException extends NullPointerException {

    public NoPieceException(String errorMessage) {
        super(errorMessage);
    }

}
