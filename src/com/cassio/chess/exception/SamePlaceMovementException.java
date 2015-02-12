package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class SamePlaceMovementException extends RuntimeException {
    public SamePlaceMovementException(String message) {
        super(message);
    }
}
