package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.KingMoveSet;

/**
 * <strong>King</strong> class - defines a king and its basic commands. If a king's square can be captured by one of the
 * opponent's pieces, the king is in check. If the king cannot defend itself from a check, a checkmate happens, and the
 * other player wins the gui. If a king is (or will) not be in check due to its own moves, it can move one square to its
 * side (either horizontally, vertically or diagonally). Basically, a king is a royal piece.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class King extends Piece {

    /**
     * Creates a king based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if <em>true</em>, white otherwise).
     */
    public King(boolean colorChoice) {
        super(colorChoice);
    }

    /**
     * Gets a MoveSet implementation to ease updating. This method is only called by a chessboard.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new KingMoveSet(referenceSquare, referenceBoard, this.isBlack);
    }
}
