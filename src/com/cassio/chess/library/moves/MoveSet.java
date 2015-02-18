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

    public MoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        this.referenceSquare = referenceSquare;
        this.referenceBoard = referenceBoard;
        this.colorChoice = colorChoice;
        possibleMoves = new HashSet<Square>();
        learnMoveSet();
    }

    protected abstract void learnMoveSet();

    public HashSet<Square> getMoves() {
        return possibleMoves;
    }

    public void changeSquareReferenceTo(Square newSquare) {
        if (this.referenceSquare != newSquare)
            this.referenceSquare = newSquare;
    }

    private boolean equalsSquareAt(int posX, int posY) {
        return referenceBoard.hasSquareAt(posX, posY) && referenceBoard.getSquareAt(posX, posY) == referenceSquare;
    }

    protected boolean playerPieceAt(int posX, int posY) {
        return referenceBoard.hasPieceAt(posX, posY) && referenceBoard.getPieceAt(posX, posY).isBlack() ==
                this.colorChoice;
    }

    /**
     * Adds a square to the move set having referenceBoard's origin as reference.
     *
     * @param posX cartesian X-coordinate of the square.
     * @param posY cartesian Y-coordinate of the square.
     */
    protected void addSquareAt(int posX, int posY) {
        if (referenceBoard.hasSquareAt(posX, posY) && !playerPieceAt(posX, posY))
            possibleMoves.add(referenceBoard.getSquareAt(posX, posY));
    }

    /**
     * Adds a square to the move set having referenceSquare's coordinates as reference.
     *
     * @param distX horizontal distance from referenceSquare.
     * @param distY vertical distance from referenceSquare.
     */
    protected void addSquareWithReference(int distX, int distY) {
        addSquareAt(referenceSquare.getPosX() + distX, referenceSquare.getPosY() + distY);
    }

}
