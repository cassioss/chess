package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.QueenMoveSet;

/**
 * <code>Queen</code> class - defines a queen and its basic moves. Queens have the same move freedom as rooks and
 * bishops, being able to move diagonally, vertically and horizontally as many squares as possible.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Queen extends Piece {
    /**
     * Creates a queen based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Queen(boolean colorChoice) {
        super(colorChoice);
        if (colorChoice)
            pathToImage = "src/com/cassio/chess/img/black_queen_500_500_transparent.png";
        else
            pathToImage = "src/com/cassio/chess/img/white_queen_500_500_transparent.png";
    }

    /**
     * Gets a MoveSet implementation to ease updating. This method is only called by a chessboard.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new QueenMoveSet(referenceSquare, referenceBoard, this.isBlack);
        moveSet = referenceMoveSet.getMoves();
    }
}
