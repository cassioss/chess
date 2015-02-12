package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class BlockingPieceException extends IllegalChessMoveException {
    public BlockingPieceException(String message) {
        super(message);
    }
}
