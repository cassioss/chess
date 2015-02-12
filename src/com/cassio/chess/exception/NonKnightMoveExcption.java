package com.cassio.chess.exception;

/**
 * Created by Cassio on 12/02/2015.
 */
public class NonKnightMoveExcption extends IllegalChessMoveException {
    public NonKnightMoveExcption(String message) {
        super(message);
    }
}
