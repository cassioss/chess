package chess.model.moves;

import chess.model.board.Board;
import chess.model.board.Square;

/**
 * <strong>RoyalMoveSet</strong> class - implementation of MoveSet class for a royal piece. A royal piece cannot be
 * attacked by an enemy piece or move to a square where it can be threatened by an enemy piece.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see chess.model.moves.MoveSet
 */
public abstract class RoyalMoveSet extends MoveSet {

    private boolean isInCheck;

    /**
     * Creates a new move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public RoyalMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
        isInCheck = false;
    }

    /**
     * Checks whether a square is being threatened on the board.
     *
     * @param posX X-coordinate to be verified.
     * @param posY Y-coordinate to be verified.
     * @return <em>true</em> if the intended square is being threatened by the opponent.
     */
    private boolean squareThreatenedAt(int posX, int posY) {
        return !referenceBoard.xPosOutOfBounds(posX) && !referenceBoard.yPosOutOfBounds(posY) &&
                referenceBoard.checkThreatAt(posX, posY, colorChoice);
    }

    /**
     * Checks whether the referenced square is being threatened on the board.
     *
     * @return <em>true</em> if the referenced square is being threatened by the opponent.
     */
    private boolean isBeingAttacked() {
        return squareThreatenedAt(getRefX(), getRefY());
    }

    /**
     * Gets the value of the isInCheck boolean.
     *
     * @return <em>true</em> if the piece is in check.
     */
    public boolean getInCheck() {
        if(isBeingAttacked())
            isInCheck = true;
        return isInCheck;
    }

    /**
     * Adds a square to the move set if it is not being threatened by an opponent piece.
     *
     * @param posX X-coordinate of a square being checked on the board.
     * @param posY Y-coordinate of a square being checked on the board.
     */
    protected void addSquareIfNotThreatened(int posX, int posY) {
        if (referenceBoard.hasSquareAt(posX, posY))
            if (!squareThreatenedAt(posX, posY))
                addSquareAt(posX, posY);
    }

}
