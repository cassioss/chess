package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class PieceColorMoveException extends IllegalChessMoveException {
    public PieceColorMoveException(String message) {
        super(message);
    }
}
