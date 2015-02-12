package com.cassio.chess.library.piece;

import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.Board;

import java.awt.*;

/**
 * <code>Piece</code> class - defines basic attributes (position, piece color and board containing the Piece) and
 * methods (like moves and addition to a Board). The only type-dependent moves are determined by the (abstract) method
 * validMovement.
 *
 * @author Cassio dos Santos Sousa
 */

public abstract class Piece {

    protected Color pieceColor;
    protected int posX, posY;
    protected Board chessBoard;

    protected Piece(Color color) {
        this.pieceColor = color;
    }

    public void bePutOnBoard(Board chessBoard, int initialX, int initialY) {
        this.chessBoard = chessBoard;
        posX = initialX;
        posY = initialY;
    }

    public Color getColor() {
        return this.pieceColor;
    }

    /**
     * Basic move Sanity Check - you will never declare a move to the same place or capture your own piece
     *
     * @param targetX - desired X-coordinate of the piece
     * @param targetY - desired Y-coordinate of the piece
     */
    protected void moveSanityCheck(int targetX, int targetY) {
        checkMovementToTheSamePlace(targetX, targetY);
        checkOwnPlayerPieceAt(targetX, targetY);
    }


    protected boolean notCapturingOwnPiece(int targetX, int targetY) {
        return noPieceAt(targetX, targetY) || opponentPieceAt(targetX, targetY);
    }

    /**
     * @param targetX - desired X-coordinate of the piece
     * @param targetY - desired Y-coordinate of the piece
     * @throws com.cassio.chess.exception.SamePieceColorException - you tried to capture your own piece
     */
    protected void checkOwnPlayerPieceAt(int targetX, int targetY) {
        if (!notCapturingOwnPiece(targetX, targetY))
            throw new SamePieceColorException("You tried to capture a Piece of the same color.");
    }

    /**
     * @param targetX - desired X-coordinate of the piece
     * @param targetY - desired Y-coordinate of the piece
     * @throws com.cassio.chess.exception.SamePlaceMoveException - you tried to move a Piece to the same place, which
     *                                                           could make you lose a turn
     */
    protected void checkMovementToTheSamePlace(int targetX, int targetY) {
        if (targetX == posX && targetY == posY)
            throw new SamePlaceMoveException("You tried to move your piece to the same place.");
    }

    protected boolean noPieceAt(int targetX, int targetY) {
        return chessBoard.maze[targetX][targetY].getPiece() == null;
    }

    protected boolean opponentPieceAt(int targetX, int targetY) {
        return chessBoard.maze[targetX][targetY].getPiece() != null &&
                chessBoard.maze[targetX][targetY].getPiece().getColor() != this.pieceColor;
    }

    /**
     * Moves to a desired Square of the Board. The only difference between two different types of Pieces (like Rook and
     * Pawn) is the movement validation - determined by the (abstract) method validMovement.
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     */

    public void moveTo(int targetX, int targetY) {
        if (validMovement(targetX, targetY)) {
            chessBoard.maze[posX][posY].movePiece();
            chessBoard.maze[targetX][targetY].putPiece(this);
            posX = targetX;
            posY = targetY;
        }
    }

    /**
     * Determines parameters for valid movements, specific for each type of Piece. Each Piece type has to treat invalid
     * moves accordingly.
     *
     * @param targetX - desired X-coordinate for movement
     * @param targetY - desired Y-coordinate for movement
     * @return <code>true</code> if the movement is valid, according to the Chess rule book
     */
    protected abstract boolean validMovement(int targetX, int targetY);

}
