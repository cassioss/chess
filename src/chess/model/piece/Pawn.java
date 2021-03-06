package chess.model.piece;

import chess.model.board.Board;
import chess.model.board.Square;
import chess.model.moves.PawnMoveSet;

/**
 * <strong>Pawn</strong> class - defines a pawn and its basic moves. Pawns can only move one square ahead (which is
 * different depending on the piece color) if it's not blocked by any piece (even an opponent's piece), and can only
 * capture pieces one diagonal square ahead (for any side). If it is the first move of a pawn, it may move two squares
 * to its front.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Pawn extends Piece {

    /**
     * Creates a pawn based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if <em>true</em>, white otherwise).
     */
    public Pawn(boolean colorChoice) {
        super(colorChoice);
    }

    /**
     * Gets a specific MoveSet implementation to ease updating. This method is only called by a chessboard, right after
     * the piece's creation.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new PawnMoveSet(referenceSquare, referenceBoard, isBlack());
    }


}
