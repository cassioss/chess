package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * {@code RookMoveSet} class - implementation of MoveSet class for rooks. Rooks can move horizontally or vertically as
 * many squares as possible. The move set stops its updates in a certain direction if it finds a piece (which can be
 * captured if it is an opponent's piece) or the limits of the board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see com.cassio.chess.library.moves.MoveSet
 */
public class RookMoveSet extends MoveSet {
    
    /**
     * Creates a new rook move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public RookMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    protected void learnMoveSet() {
        learnVerticalMoves();
        learnHorizontalMoves();
    }

    private void learnVerticalMoves() {

    }

    private void learnHorizontalMoves() {

    }
}
