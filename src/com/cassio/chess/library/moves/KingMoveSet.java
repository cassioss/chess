package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * <strong>KingMoveSet</strong> class - implementation of MoveSet class for kings. A king's move set has all the eight
 * squares close to the referenced square (diagonally, horizontally and vertically at any direction). There is no check
 * or checkmate verification here, as this is a property of royal pieces.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see com.cassio.chess.library.moves.MoveSet
 */
public class KingMoveSet extends MoveSet {
    
    /**
     * Creates a new king move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public KingMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to.
     */
    protected void learnMoveSet() {
        addSquareWithReferenceAt(0, 1);
        addSquareWithReferenceAt(-1, 1);
        addSquareWithReferenceAt(1, 1);
        addSquareWithReferenceAt(1, 0);
        addSquareWithReferenceAt(-1, 0);
        addSquareWithReferenceAt(0, -1);
        addSquareWithReferenceAt(1, -1);
        addSquareWithReferenceAt(-1, -1);
    }

    /**
     * Tries to add a square with a specified distance to referenceSquare.
     *
     * @param distX the X-distance from a square to referenceSquare.
     * @param distY the Y-distance from a square to referenceSquare.
     */
    private void addSquareWithReferenceAt(int distX, int distY) {
        addSquareAt(getRefX() + distX, getRefY() + distY);
    }
}
