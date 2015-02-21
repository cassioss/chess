package com.cassio.chess.library.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.moves.EmpressMoveSet;

/**
 * <strong>Empress</strong> class - defines an empress and its basic moves. An empress is a fairy chess piece with the
 * compound moves of a Knight piece and a Rook piece. Although this piece gets the moves of a Knight, it can only jump
 * to other squares when it moves as a Knight.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see <a href="http://en.wikipedia.org/wiki/Fairy_chess_piece">Fairy Chess pieces - Wikipedia</a>
 */
public class Empress extends Piece {

    /**
     * Creates an empress based on its color (black or white).
     *
     * @param colorChoice a boolean value defining the color of the piece (black if <em>true</em>, white otherwise).
     */
    public Empress(boolean colorChoice) {
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
        referenceMoveSet = new EmpressMoveSet(referenceSquare, referenceBoard, this.isBlack);
    }
}
