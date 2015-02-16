package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.Piece;

import java.awt.Color;

/**
 * {@code Square} class - describes a chessboard square and its properties: color, piece over it (if any), chessboard *
 * that contains it and a score determining the existence of a piece or not. Its existence is exclusively dependent on
 * the existence of a chessboard, and the chessboard determines how the square is going to be painted.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Square {

    private Piece squarePiece;
    protected Color squareColor;
    private int posX, posY;
    private Board parentBoard;

    /**
     * Receives the parent chessboard as parameter, setting everything else to either {@code null} or zero.
     *
     * @param parent the chessboard that will create the board.
     */
    public Square(Board parent) {
        squarePiece = null;
        this.parentBoard = parent;
    }

    /**
     * Returns the piece on the square.
     *
     * @return the Piece on the square, ir any, or {@code null} otherwise.
     */
    public Piece getPiece() {
        return squarePiece;
    }

    /**
     * Returns the color of the square, which is set by the chessboard.
     *
     * @return the square color.
     */
    public Color getSquareColor() {
        return squareColor;
    }

    /**
     * Checks if there is a piece on the square.
     *
     * @return {@code true} if there is a piece on the square.
     */
    public boolean hasPiece() {
        return this.squarePiece != null;
    }

    /**
     * Verifies whether the piece on the square has the same color as another piece, probably trying to
     *
     * @param otherPiece a piece to be compared.
     * @return {@code true} if the colors (set by a boolean value) are equal.
     */
    public boolean pieceHasSameColorAs(Piece otherPiece) {
        return this.squarePiece.getColor() == otherPiece.getColor();
    }

    /**
     * Sets new piece in the square. Protected visibility is set to be visible by chessboards only.
     *
     * @param piece new piece to be set
     */
    protected void putNewPiece(Piece piece) {
        this.squarePiece = piece;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

}
