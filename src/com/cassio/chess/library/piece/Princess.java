package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.PrincessMoveSet;

/**
 * <strong>Princess</strong> class - defines a princess and its basic moves. A princess is a fairy chess piece with the
 * compound moves of a Knight piece and a Bishop piece. Although this piece gets the moves of a Knight, it can only jump
 * to other squares when it moves as a Knight.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see <a href="http://en.wikipedia.org/wiki/Fairy_chess_piece">Fairy Chess pieces - Wikipedia</a>
 */
public class Princess extends Piece {

    /**
     * Creates a princess based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if <em>true</em>, white otherwise).
     */
    public Princess(boolean colorChoice) {
        super(colorChoice);
    }

    /**
     * Gets a specific MoveSet implementation to ease updating. This method is only called by a chessboard, right after
     * the piece's creation.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public void learnMoveSetFrom(Square referenceSquare, Board referenceBoard) {
        referenceMoveSet = new PrincessMoveSet(referenceSquare, referenceBoard, this.isBlack);
    }
}
