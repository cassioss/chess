package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.BishopMoveSet;

/**
 * Created by Cassio on 16/02/2015.
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
