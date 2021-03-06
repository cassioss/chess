package chess.model.board;

import chess.model.piece.Piece;

import java.awt.Color;

/**
 * <strong>Square</strong> class - describes a chessboard square and its basic properties: color, position and piece
 * over it. The painting is done according to the chessboard that creates it, and the pieces are set depending on the
 * GUI - which requires these properties to be protected.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class Square {

    protected Piece squarePiece;
    protected Color squareColor;
    private int posX, posY;

    /**
     * Creates a square in a certain position of a board. The coordinates are the only things the square knows about its
     * board, as identifying a square on a board could take a lot of time.
     *
     * @param posX the X-coordinate chosen to create the square on a certain board.
     * @param posY the Y-coordinate chosen to create the square on a certain board.
     */
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