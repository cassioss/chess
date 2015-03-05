package chess.model.moves;

import chess.model.board.Board;
import chess.model.board.Square;

/**
 * <strong>KnightMoveSet</strong> class - implementation of MoveSet class for knights. Knights can "jump" directly to
 * the squares, and their moves have an L-shape: two squares to one direction, one square to the other direction.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see chess.model.moves.MoveSet
 */
public class KnightMoveSet extends MoveSet {

    /**
     * Creates a new move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public KnightMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to.
     */
    protected void learnMoveSet() {
        for (int range = 1; range <= 2; range++) {
            addSquareWithReferenceAt(range, 3 - range);
            addSquareWithReferenceAt(range, range - 3);
            addSquareWithReferenceAt(-range, 3 - range);
            addSquareWithReferenceAt(-range, range - 3);
        }
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
