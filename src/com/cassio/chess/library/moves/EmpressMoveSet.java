package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * {@code EmpressMoveSet} class - implementation of MoveSet class for empresses. An empress is a fairy chess piece with
 * the compound moves of a Knight piece and a Rook piece. Although this piece gets the moves of a Knight, it can only
 * jump to other squares when it moves as a Knight.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see <a href="http://en.wikipedia.org/wiki/Fairy_chess_piece">Fairy Chess pieces - Wikipedia</a>
 */
public class EmpressMoveSet extends MoveSet {

    /**
     * Creates a new move Empress set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public EmpressMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to.
     */
    protected void learnMoveSet() {
        MoveSet knightMoves = new KnightMoveSet(referenceSquare, referenceBoard, colorChoice);
        MoveSet rookMoves = new RookMoveSet(referenceSquare, referenceBoard, colorChoice);
        knightMoves.learnMoveSet();
        rookMoves.learnMoveSet();
        possibleMoves.addAll(knightMoves.getMoves());
        possibleMoves.addAll(rookMoves.getMoves());
    }
}
