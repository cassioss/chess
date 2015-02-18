package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.MoveSet;

import java.util.HashSet;

/**
 * <code>Piece</code> class - defines basic attributes of a piece (color, move set and how up-to-date is the move set).
 * The creation of a piece and its positioning (as well as implementation of moves) is dependent on the board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */

public abstract class Piece {

    protected boolean isBlack;
    protected HashSet<Square> possibleMoves;
    protected boolean isUpToDate;
    protected MoveSet referenceMoveSet;

    /**
     * Creates a piece based on its color (black or white). As the piece was probably just added to a board, its move
     * set is empty, and the piece is outdated.
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Piece(boolean colorChoice) {
        isBlack = colorChoice;
        isUpToDate = false;
    }

    /**
     * Gets the color choice of the piece.
     *
     * @return {@code true} if the piece color is black, {@code false} if the piece color is white.
     */
    public boolean isBlack() {
        return this.isBlack;
    }

    /**
     * Gets the set of available moves (squares) for a piece. It is implemented as a HashSet to benefit from O(1)
     * searches and non-repeated squares.
     *
     * @return a HashSet of available squares that the piece can move to.
     */
    public HashSet<Square> getPossibleMoves() {
        if (!isUpToDate)
            updateMoveSet();
        return possibleMoves;
    }

    /**
     * Abstract method to update a piece's move set.
     */
    protected abstract void updateMoveSet();

    /**
     * Gets a MoveSet implementation to ease updating. This method is only called by a chessboard.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public abstract void learnMoveSetFrom(Square referenceSquare, Board referenceBoard);


}
