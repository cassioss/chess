package com.cassio.chess.library.moves;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;

import java.util.HashSet;

/**
 * {@code Moves} class - has a list of possible squares for a piece to move in a board. The main reasons for creating
 * this class is that (1) most pieces share the same moves (for example, the Queen can move the same way as a Rook or a
 * Bishop), (2) sets do not accept copies, and (3) having a set of possible moves eases the job to find whether a King
 * piece is in check or checkmate. It is abstract so it can be implemented differently for each piece.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public abstract class Moves {
    protected HashSet<Square> possibleMoves;
    protected Square referenceSquare;
    protected Board referenceBoard;
    protected boolean colorChoice;

    protected void addMoves(HashSet<Square> moveSet) {
        possibleMoves.addAll(moveSet);
    }

    protected void addMove(Square move) {
        possibleMoves.add(move);
    }

    public Moves(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        this.referenceSquare = referenceSquare;
        this.referenceBoard = referenceBoard;
        this.colorChoice = colorChoice;
    }

    public abstract void learnMoves();

    public HashSet<Square> getMoveSet() {
        return new HashSet<Square>(possibleMoves);
    }

    /**
     * Adds a square to the moveset having referenceBoard's origin as reference.
     *
     * @param posX cartesian X-coordinate of the square.
     * @param posY cartesian Y-coordinate of the square.
     */
    protected void addSquareAt(int posX, int posY) {
        if (referenceBoard.hasSquareAt(posX, posY) && !hasPlayerPieceAt(posX, posY))
            addMove(referenceBoard.getSquareAt(posX, posY));
    }

    /**
     * Adds a square to the moveset having referenceSquare's coordinates as reference.
     *
     * @param distX horizontal distance from referenceSquare.
     * @param distY vertical distance from referenceSquare.
     */
    protected void addSquareWithReference(int distX, int distY) {
        addSquareAt(getX() + distX, getY() + distY);
    }

    private int getX() {
        return referenceSquare.getPosX();
    }

    private int getY() {
        return referenceSquare.getPosY();
    }

    private int newPositionX(int displacement) {
        return getX() + displacement;
    }

    private int newPositionY(int displacement) {
        return getY() + displacement;
    }

    private boolean hasPlayerPieceAt(int posX, int posY) {
        return false;
    }

    private boolean hasOpponentPieceAt(int posX, int posY) {
        return false;
    }

    private boolean hasPieceAt(int posX, int posY) {
        return referenceBoard.getSquareAt(posX, posY) != null;
    }

    private boolean limitForXPath(int increment) {
        return newPositionX(increment) < 0 || newPositionX(increment) == referenceBoard.getLimitX();
    }

    private boolean limitForYPath(int increment) {
        return newPositionX(increment) < 0 || newPositionY(increment) == referenceBoard.getLimitY(getX());
    }

    protected void getSemiInfiniteXPath(int pace) {
        for (; !limitForXPath(pace); pace += pace) {
            if (hasPieceAt(getX() + pace, getY())) {
                if (hasOpponentPieceAt(getX() + pace, getY()))
                    addMove(referenceBoard.getSquareAt(getX() + pace, getY()));
                break;
            } else addMove(referenceBoard.getSquareAt(getX() + pace, getY()));
        }
    }

    protected void getInfiniteXPath() {
        getSemiInfiniteXPath(1);
        getSemiInfiniteXPath(-1);
    }

    protected void getSemiInfiniteYPath(int pace) {
        for (; !limitForYPath(pace); pace += pace) {
            if (hasPieceAt(getX(), getY() + pace)) {
                if (hasOpponentPieceAt(getX(), getY() + pace))
                    addMove(referenceBoard.getSquareAt(getX(), getY() + pace));
                break;
            } else addMove(referenceBoard.getSquareAt(getX(), getY() + pace));
        }
    }

    protected void getInfiniteYPath() {
        getSemiInfiniteYPath(1);
        getSemiInfiniteYPath(-1);
    }

    protected void getSemiInfiniteMainDiagonalPath(int pace) {
        for (; !limitForXPath(pace) && !limitForYPath(pace); pace += pace) {
            if (hasPieceAt(getX() + pace, getY() + pace)) {
                if (hasOpponentPieceAt(getX() + pace, getY() + pace))
                    addMove(referenceBoard.getSquareAt(getX() + pace, getY() + pace));
                break;
            } else addMove(referenceBoard.getSquareAt(getX() + pace, getY() + pace));
        }
    }

    protected void getSemiInfiniteSecondaryDiagonalPath(int pace) {
        for (; !limitForXPath(pace) && !limitForYPath(pace); pace += pace) {
            if (hasPieceAt(getX() - pace, getY() + pace)) {
                if (hasOpponentPieceAt(getX() - pace, getY() + pace))
                    addMove(referenceBoard.getSquareAt(getX() - pace, getY() + pace));
                break;
            } else addMove(referenceBoard.getSquareAt(getX() - pace, getY() + pace));
        }
    }

    protected void getInfiniteDiagonalPaths() {
        getSemiInfiniteMainDiagonalPath(1);
        getSemiInfiniteMainDiagonalPath(-1);
        getSemiInfiniteSecondaryDiagonalPath(1);
        getSemiInfiniteSecondaryDiagonalPath(-1);
    }

}
