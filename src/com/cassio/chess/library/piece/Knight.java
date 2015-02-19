package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.KnightMoveSet;

/**
 * <code>Knight</code> class - defines a knight and its basic moves. Knights can "jump" directly to the squares, and
 * their moves have an L-shape: two squares to one direction, one square to the other direction.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Knight extends Piece {

    /**
     * Creates a knight based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Knight(boolean colorChoice) {
        super(colorChoice);
        if (colorChoice)
            pathToImage = "src/com/cassio/chess/img/black_knight_500_500_transparent.png";
        else
            pathToImage = "src/com/cassio/chess/img/white_knight_500_500_transparent.png";
    }

    /**
     * Gets a MoveSet implementation to ease updating. This method is only called by a chessboard.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new KnightMoveSet(referenceSquare, referenceBoard, isBlack);
        moveSet = referenceMoveSet.getMoves();
    }
}
