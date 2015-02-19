package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

import java.util.HashSet;

/**
 * {@code MoveSet} class - has a list of possible squares for a piece to move in a board. The main reasons for creating
 * this class is that (1) most pieces share the same moves (for example, the Queen can move the same way as a Rook or a
 * Bishop), (2) sets do not accept copies, and (3) having a set of possible moves eases the job to find whether a King
 * piece is in check or checkmate. It is abstract so it can be implemented differently for each piece.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public abstract class MoveSet {

    protected HashSet<Square> possibleMoves;
    protected Square referenceSquare;
    protected Board referenceBoard;
    protected boolean colorChoice;

    /**
     * Creates a new move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public MoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        this.referenceSquare = referenceSquare;
        this.referenceBoard = referenceBoard;
        this.colorChoice = colorChoice;
        possibleMoves = new HashSet<Square>();
        learnMoveSet();
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to.
     */
    protected abstract void learnMoveSet();

    /**
     * Returns a set with all the squares that a piece is allowed to move to.
     *
     * @return a HashSet with all the squares on the move set.
     */
    public HashSet<Square> getMoves() {
        return possibleMoves;
    }

    /**
     * Checks if a piece in a certain square of the chessboard (if any) is the player's piece.
     *
     * @param posX X-coordinate of the piece to be compared.
     * @param posY Y-coordinate of the piece to be compared.
     * @return {@code true} if there is a piece on that position and if the pieces have the same color.
     */
    protected boolean playerPieceAt(int posX, int posY) {
        return referenceBoard.hasPieceAt(posX, posY) && referenceBoard.getPieceAt(posX, posY).isBlack() ==
                this.colorChoice;
    }

    /**
     * Checks if a piece in a certain square of the chessboard (if any) is the opponent's piece.
     *
     * @param posX X-coordinate of the piece to be compared.
     * @param posY Y-coordinate of the piece to be compared.
     * @return {@code true} if there is a piece on that position and if the pieces have different colors.
     */
    protected boolean opponentPieceAt(int posX, int posY) {
        return referenceBoard.hasPieceAt(posX, posY) && referenceBoard.getPieceAt(posX, posY).isBlack() !=
                this.colorChoice;
    }

    /**
     * Adds a square to the move set having referenceBoard's origin as reference. For most pieces, you only need to
     * avoid squares that have a player's piece on it.
     *
     * @param posX cartesian X-coordinate of the square on the board.
     * @param posY cartesian Y-coordinate of the square on the board.
     */
    protected void addSquareAt(int posX, int posY) {
        if (referenceBoard.hasSquareAt(posX, posY) && !playerPieceAt(posX, posY))
            possibleMoves.add(referenceBoard.getSquareAt(posX, posY));
    }

    /**
     * Returns the X-coordinate of the referenced square.
     *
     * @return the X-coordinate of referenceSquare on the board.
     */
    protected int getRefX() {
        return referenceSquare.getPosX();
    }

    /**
     * Returns the Y-coordinate of the referenced square.
     *
     * @return the Y-coordinate of referenceSquare on the board.
     */
    protected int getRefY() {
        return referenceSquare.getPosY();
    }

    /**
     * Updates a piece's move set by request.
     */
    public void requestUpdate() {
        learnMoveSet();
    }
}
