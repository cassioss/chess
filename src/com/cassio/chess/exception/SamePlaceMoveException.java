package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class SamePlaceMoveException extends IllegalChessMoveException {
    public SamePlaceMoveException(String message) {
        super(message);
    }
}
