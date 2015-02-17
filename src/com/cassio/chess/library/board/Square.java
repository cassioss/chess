package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.Piece;

import java.awt.Color;

/**
 * {@code Square} class - describes a chessboard square and its basic properties: color, position and piece over it. The
 * painting is done according to the chessboard that creates it, and the pieces are set depending on the game - which
 * requires these properties to be protected.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Square {

    protected Piece squarePiece;
    protected Color squareColor;
    private int posX, posY;

    public Square(int posX, int posY) {
        squarePiece = null;
        squareColor = null;
        this.posX = posX;
        this.posY = posY;
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
     * Returns the piece on the square.
     *
     * @return the Piece on the square, if any.
     */
    public Piece getSquarePiece() {
        return squarePiece;
    }


    /**
     * Returns the X-coordinate of the square in a chessboard.
     *
     * @return an integer containing the X-coordinate of a square.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Returns the Y-coordinate of the square in a chessboard.
     *
     * @return an integer containing the Y-coordinate of a square.
     */
    public int getPosY() {
        return posY;
    }

}