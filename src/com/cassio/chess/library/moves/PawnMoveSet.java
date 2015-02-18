package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * {@code PawnMoveSet} class - implementation of MoveSet class for pawns.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see com.cassio.chess.library.moves.MoveSet
 */
public class PawnMoveSet extends MoveSet {
    public PawnMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    private void addSquareWithReferenceIfCanCapture(int posX, int posY) {
        if (referenceBoard.hasPieceAt(posX, posY) && !playerPieceAt(posX, posY))
            addSquareWithReference(posX, posY);
    }

    @Override
    protected void learnMoveSet() {
        if (colorChoice)
            learnBlackPawnMoveSet();
        else
            learnWhitePawnMoveSet();
    }

    private void learnWhitePawnMoveSet() {
        addSquareWithReference(0, 1);
        addSquareWithReferenceIfCanCapture(1, 1);
        addSquareWithReferenceIfCanCapture(-1, 1);
    }

    private void learnBlackPawnMoveSet() {
        addSquareWithReference(0, -1);
        addSquareWithReferenceIfCanCapture(1, -1);
        addSquareWithReferenceIfCanCapture(-1, -1);
    }
}
