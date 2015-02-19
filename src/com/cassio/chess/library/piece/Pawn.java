package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.PawnMoveSet;

/**
 * {@code Pawn} class - defines a pawn and its basic moves. Pawns can only move one square ahead (which is different
 * depending on the piece color) if it's not blocked by any piece (even an opponent's piece), and can only capture
 * pieces one diagonal square ahead (for any side). If it is the first move of a pawn, it may move two squares to its
 * front.
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
        if (colorChoice)
            pathToImage = "src/com/cassio/chess/img/black_pawn_500_500_transparent.png";
        else
            pathToImage = "src/com/cassio/chess/img/white_pawn_500_500_transparent.png";
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
