package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.BishopMoveSet;

/**
 * <code>Bishop</code> class - defines a bishop and its basic moves. Bishops can move diagonally (with the same
 * displacement at both the X-axis and the Y-axis) in any direction as many squares as possible. The move set stops its
 * updates in a certain direction if it finds a piece (which can be captured if it is an opponent's piece) or the limits
 * of the board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Bishop extends Piece {
    
    /**
     * Creates a bishop based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Bishop(boolean colorChoice) {
        super(colorChoice);
        if (colorChoice)
            pathToImage = "src/com/cassio/chess/img/black_bishop_500_500_transparent.png";
        else
            pathToImage = "src/com/cassio/chess/img/white_bishop_500_500_transparent.png";
    }

    /**
     * Gets a MoveSet implementation to ease updating. This method is only called by a chessboard.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    @Override
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new BishopMoveSet(referenceSquare, referenceBoard, this.isBlack);
        moveSet = referenceMoveSet.getMoves();
    }
}
