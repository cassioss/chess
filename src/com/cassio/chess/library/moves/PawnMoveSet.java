package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * {@code PawnMoveSet} class - implementation of MoveSet class for pawns. Pawns can only move one square ahead (which is
 * different depending on the piece color) if it's not blocked by any piece (even an opponent's piece), and can only
 * capture pieces one diagonal square ahead (for any side). If it is the first move of a pawn, it may move two squares
 * to its front.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see com.cassio.chess.library.moves.MoveSet
 */
public class PawnMoveSet extends MoveSet {

    /**
     * Creates a new move set for a Pawn having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public PawnMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

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

    private void addSquareWithReferenceIfCanCapture(int posX, int posY) {
        int refX = posX + getRefX();
        int refY = posY + getRefY();
        if (referenceBoard.hasPieceAt(refX, refY) && !playerPieceAt(refX, refY))
            addSquareAt(refX, refY);
    }

    private void addSquareWithReferenceIfNotBlocked(int posX, int posY) {
        int refX = posX + getRefX();
        int refY = posY + getRefY();
        if (!referenceBoard.hasPieceAt(refX, refY))
            addSquareAt(refX, refY);
    }

}
