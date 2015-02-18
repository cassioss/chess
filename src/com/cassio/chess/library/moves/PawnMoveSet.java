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
        int refX = posX + referenceSquare.getPosX();
        int refY = posY + referenceSquare.getPosY();
        if (referenceBoard.hasPieceAt(refX, refY) && !playerPieceAt(refX, refY))
            addSquareAt(refX, refY);
    }

    @Override
    protected void learnMoveSet() {
        if (colorChoice)
            learnBlackPawnMoveSet();
        else
            learnWhitePawnMoveSet();
    }

    private void learnWhitePawnMoveSet() {
        addSquareWithReferenceIfNotBlocked(0, 1);
        addSquareWithReferenceIfCanCapture(1, 1);
        addSquareWithReferenceIfCanCapture(-1, 1);
    }

    private void learnBlackPawnMoveSet() {
        addSquareWithReferenceIfNotBlocked(0, -1);
        addSquareWithReferenceIfCanCapture(1, -1);
        addSquareWithReferenceIfCanCapture(-1, -1);
    }

    private void addSquareWithReferenceIfNotBlocked(int posX, int posY) {
        int refX = posX + referenceSquare.getPosX();
        int refY = posY + referenceSquare.getPosY();
        if (!referenceBoard.hasPieceAt(refX, refY))
            addSquareAt(refX, refY);
    }
}
