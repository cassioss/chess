package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class DiagonalMoveException extends IllegalChessMovementException {
    public DiagonalMoveException(String message) {
        super(message);
    }
}
