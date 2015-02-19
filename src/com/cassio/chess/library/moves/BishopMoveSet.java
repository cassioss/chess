package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

/**
 * {@code BishopMoveSet} class - implementation of MoveSet class for bishops. Bishops can move diagonally (with the same
 * displacement at both the X-axis and the Y-axis) in any direction as many squares as possible. The move set stops its
 * updates in a certain direction if it finds a piece (which can be captured if it is an opponent's piece) or the limits
 * of the board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see com.cassio.chess.library.moves.MoveSet
 */
public class BishopMoveSet extends MoveSet {

    /**
     * Creates a new bishop move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public BishopMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to. In the case of a bishop,
     */
    protected void learnMoveSet() {
        learnDiagonalMoves();
    }

    /**
     * Goes through all the squares diagonally too see which ones allow a valid move.
     */
    private void learnDiagonalMoves() {
        learnDiagonalMovesAtMainDiagonal(1);
        learnDiagonalMovesAtMainDiagonal(-1);
        learnDiagonalMovesAtSecondaryDiagonal(1);
        learnDiagonalMovesAtSecondaryDiagonal(-1);
    }

    /**
     * Goes through all the diagonal squares in the piece's main diagonal, according to a pace.
     *
     * @param pace how both coordinates changes with time. (+1) means right up, (-1) means left down.
     */
    private void learnDiagonalMovesAtMainDiagonal(int pace) {
        boolean foundPiece = false;
        for (int dist = pace; !outOfBounds(getRefX() + dist, getRefY() + dist) && !foundPiece; dist += pace) {
            if (referenceBoard.hasPieceAt(getRefX() + dist, getRefY() + dist)) {
                foundPiece = true;
                if (opponentPieceAt(getRefX() + dist, getRefY() + dist))
                    addSquareAt(getRefX() + dist, getRefY() + dist);
            } else addSquareAt(getRefX() + dist, getRefY() + dist);
        }
    }

    /**
     * Goes through all the diagonal squares in the piece's secondary diagonal, according to a pace.
     *
     * @param pace how both coordinates changes with time. (+1) means left up, (-1) means right down.
     */
    private void learnDiagonalMovesAtSecondaryDiagonal(int pace) {
        boolean foundPiece = false;
        for (int dist = pace; !outOfBounds(getRefX() - dist, getRefY() + dist) && !foundPiece; dist += pace) {
            if (referenceBoard.hasPieceAt(getRefX() - dist, getRefY() + dist)) {
                foundPiece = true;
                if (opponentPieceAt(getRefX() - dist, getRefY() + dist))
                    addSquareAt(getRefX() - dist, getRefY() + dist);
            } else addSquareAt(getRefX() - dist, getRefY() + dist);
        }
    }

    /**
     * Checks both instances of outOfBounds(int) - the X-axis and the Y-axis - at the same time.
     *
     * @param xPos X-coordinate to be verified.
     * @param yPos Y-coordinate to be verified.
     * @return {@code true} if any of the coordinates is out of bounds on the referenced chessboard.
     */
    private boolean outOfBounds(int xPos, int yPos) {
        return referenceBoard.xPosOutOfBounds(xPos) ||
                referenceBoard.yPosOutOfBounds(yPos);
    }
}
