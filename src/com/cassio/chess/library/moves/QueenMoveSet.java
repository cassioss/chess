package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * Created by Cassio on 18/02/2015.
 */
public class QueenMoveSet extends MoveSet {
    /**
     * Creates a new move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public QueenMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to.
     */
    protected void learnMoveSet() {
        MoveSet bishopMoves = new BishopMoveSet(referenceSquare, referenceBoard, colorChoice);
        MoveSet rookMoves = new RookMoveSet(referenceSquare, referenceBoard, colorChoice);
        bishopMoves.learnMoveSet();
        rookMoves.learnMoveSet();
    }
}
