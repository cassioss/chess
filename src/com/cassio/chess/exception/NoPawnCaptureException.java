package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class NoPawnCaptureException extends IllegalChessMoveException {
    public NoPawnCaptureException(String message) {
        super(message);
    }
}
