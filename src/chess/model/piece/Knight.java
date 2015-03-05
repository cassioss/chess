package chess.model.piece;

import chess.model.board.Board;
import chess.model.board.Square;
import chess.model.moves.KnightMoveSet;

/**
 * <strong>Knight</strong> class - defines a knight and its basic moves. Knights can "jump" directly to the squares,
 * and their moves have an L-shape: two squares to one direction, one square to the other direction.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Knight extends Piece {

    /**
     * Creates a knight based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if <em>true</em>, white otherwise).
     */
    public Knight(boolean colorChoice) {
        super(colorChoice);
    }

    /**
     * Gets a MoveSet implementation to ease updating. This method is only called by a chessboard.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new KnightMoveSet(referenceSquare, referenceBoard, isBlack);
    }
}
