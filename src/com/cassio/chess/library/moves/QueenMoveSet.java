package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * <strong>QueenMoveSet</strong>  class - implementation of MoveSet class for queens. Queens have the same move freedom
 * as rooks and bishops, being able to move diagonally, vertically and horizontally as many squares as possible.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see com.cassio.chess.library.moves.MoveSet
 */

public class QueenMoveSet extends MoveSet {

    /**
     * Creates a new queen move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public QueenMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to. As said before, queens have the
     * move set from rooks and bishops - and their move set can be implemented as such.
     */
    protected void learnMoveSet() {
        MoveSet bishopMoves = new BishopMoveSet(referenceSquare, referenceBoard, colorChoice);
        MoveSet rookMoves = new RookMoveSet(referenceSquare, referenceBoard, colorChoice);
        bishopMoves.learnMoveSet();
        rookMoves.learnMoveSet();
        possibleMoves.addAll(bishopMoves.getMoves());
        possibleMoves.addAll(rookMoves.getMoves());
    }
}
