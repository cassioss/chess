package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.PawnMoveSet;

/**
 * <code>Pawn</code> class - defines a pawn and its basic moves. A pawn can only capture an opponent piece that's on one
 * of its front diagonal squares (different for each side) or move to the square directly to its front. If this is the
 * beginning of the game, the pawn may move two squares to its front.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Pawn extends Piece {

    /**
     * Creates a pawn based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */

    public Pawn(boolean colorChoice) {
        super(colorChoice);
    }

    /**
     * Abstract method to update a pawns's move set.
     */
    @Override
    protected void updateMoveSet() {
        isUpToDate = true;
    }

    /**
     * Gets a specific MoveSet implementation to ease updating.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new PawnMoveSet(referenceSquare, referenceBoard, isBlack());
    }


}
