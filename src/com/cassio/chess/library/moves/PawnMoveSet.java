package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * <strong>PawnMoveSet</strong> class - implementation of MoveSet class for pawns. Pawns can only move one square ahead
 * (which is different depending on the piece color) if it's not blocked by any piece (even an opponent's piece), and
 * can only capture pieces one diagonal square ahead (for any side). If it is the first move of a pawn, it may move two
 * squares to its front.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see com.cassio.chess.library.moves.MoveSet
 */
public class PawnMoveSet extends MoveSet {

    private boolean isFirstMove;

    /**
     * Creates a new move set for a Pawn having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public PawnMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
        isFirstMove = true;
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to. For pawns, there is a specific
     * move set for each piece color.
     */
    protected void learnMoveSet() {
        if (colorChoice)
            learnBlackPawnMoveSet();
        else
            learnWhitePawnMoveSet();
    }

    /**
     * Moves to be learnt by a white pawn. They can only move or capture upwards. If it is their initial move, they may
     * move two squares downwards.
     */
    private void learnWhitePawnMoveSet() {
        addSquareWithReferenceIfNotBlocked(0, 1);
        addSquareWithReferenceIfCanCapture(1, 1);
        addSquareWithReferenceIfCanCapture(-1, 1);
        if (isFirstMove)
            addSquareWithReferenceIfNotBlocked(0, 2);
    }

    /**
     * Moves to be learnt by a black pawn. They can only move or capture downwards. If it is their initial move, they
     * may move two squares downwards.
     */
    private void learnBlackPawnMoveSet() {
        addSquareWithReferenceIfNotBlocked(0, -1);
        addSquareWithReferenceIfCanCapture(1, -1);
        addSquareWithReferenceIfCanCapture(-1, -1);
        if (isFirstMove)
            addSquareWithReferenceIfNotBlocked(0, -2);
    }

    /**
     * Tries to add a square with a specified distance to referenceSquare, but only if there is a piece to be captured.
     *
     * @param distX the X-distance from a square to referenceSquare.
     * @param distY the Y-distance from a square to referenceSquare.
     */
    private void addSquareWithReferenceIfCanCapture(int distX, int distY) {
        int refX = distX + getRefX();
        int refY = distY + getRefY();
        if (referenceBoard.hasPieceAt(refX, refY) && !playerPieceAt(refX, refY))
            addSquareAt(refX, refY);
    }

    /**
     * Tries to add a square with a specified distance to referenceSquare, but only if there are no pieces on it.
     *
     * @param distX the X-distance from a square to referenceSquare.
     * @param distY the Y-distance from a square to referenceSquare.
     */
    private void addSquareWithReferenceIfNotBlocked(int distX, int distY) {
        int refX = distX + getRefX();
        int refY = distY + getRefY();
        if (!referenceBoard.hasPieceAt(refX, refY))
            addSquareAt(refX, refY);
    }

}
