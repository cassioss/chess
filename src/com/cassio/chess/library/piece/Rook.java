package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.RookMoveSet;

/**
 * <code>Rook</code> class - defines a rook and its basic moves. Rooks can move horizontally or vertically as many
 * squares as possible. The move set stops its updates in a certain direction if it finds a piece (which can be captured
 * if it is an opponent's piece) or the limits of the board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Rook extends Piece {

    /**
     * Creates a rook based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Rook(boolean colorChoice) {
        super(colorChoice);
        if(colorChoice)
            pathToImage = "src/com/cassio/chess/img/black_rook_500_500_transparent.png";
        else
            pathToImage = "src/com/cassio/chess/img/white_rook_500_500_transparent.png";
    }

    /**
     * Gets a specific MoveSet implementation to ease updating. This method is only called by a chessboard, right after
     * the piece's creation.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new RookMoveSet(referenceSquare, referenceBoard, this.isBlack);
        moveSet = referenceMoveSet.getMoves();
    }
}
