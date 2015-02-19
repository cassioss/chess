package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.MoveSet;

import java.util.HashSet;

/**
 * {@code Piece} class - defines basic attributes of a piece (color, move set, path to image and how up-to-date is its
 * move set). The creation of a piece and its positioning (as well as implementation of moves) is dependent on the
 * board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public abstract class Piece {

    protected boolean isBlack;
    protected boolean isUpToDate;
    protected MoveSet referenceMoveSet;
    protected HashSet<Square> moveSet;
    String pathToImage;

    /**
     * Creates a piece based on its color (black or white). As the piece was probably just added to a board, its move
     * set is empty, and the piece is outdated.
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Piece(boolean colorChoice) {
        isBlack = colorChoice;
        isUpToDate = false;
        moveSet = new HashSet<Square>();
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
        return referenceMoveSet.getMoves();
    }

    /**
     * Updates a piece's MoveSet. This function is only called by a chessboard.
     */
    public void updateMoveSet() {
        moveSet.clear();
        moveSet = new HashSet<Square>();
        referenceMoveSet.requestUpdate();
        moveSet = referenceMoveSet.getMoves();
    }

    /**
     * Gets a specific MoveSet implementation to ease updating. This method is only called by a chessboard, right after
     * the piece's creation.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public abstract void learnMoveSetFrom(Square referenceSquare, Board referenceBoard);

    /**
     * Checks if a square is in the piece's move set, in order to verify if a specific move is possible.
     *
     * @param square a desired square for movement.
     * @return {@code true} if the square is in the move set of the piece.
     */
    public boolean canMoveTo(Square square) {
        return moveSet.contains(square);
    }

    /**
     * @return {@code true} if the piece is blocked by other pieces.
     */
    public boolean pieceIsBlocked() {
        return moveSet.size() == 0;
    }

}
