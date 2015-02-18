package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.*;

import java.awt.*;

/**
 * {@code ChessBoard} class - the classic Chess board: 8x8 Squares, 16 Pieces for each player, alternate painting of
 * Squares as either gray (darker color) or white.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */

public class ChessBoard extends Board {

    private static final int ROW_COUNT = 8, COLUMN_COUNT = 8;

    /**
     * Creates the chessboard as stated on the abstract parent Board.
     */
    public ChessBoard() {
        super();
    }

    /**
     * Sets up the board as a 8x8 matrix of squares.
     */
    protected void setupSquares() {
        squareBoard = new Square[COLUMN_COUNT][ROW_COUNT];
        for (int posX = 0; posX < squareBoard.length; posX++)
            for (int posY = 0; posY < squareBoard[posX].length; posY++)
                squareBoard[posX][posY] = new Square(posX, posY);
    }

    /**
     * Checks if the parity of two numbers is equal.
     *
     * @param a first integer number.
     * @param b second integer number.
     * @return true if a+b is even.
     */
    private boolean checkParity(int a, int b) {
        return (a + b) % 2 == 0;
    }

    /**
     * Paints a square with the color LIGHT_GRAY.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     */
    private void paintGray(int posX, int posY) {
        squareBoard[posX][posY].squareColor = Color.LIGHT_GRAY;
    }

    /**
     * Paints a square with the color WHITE.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     */
    private void paintWhite(int posX, int posY) {
        squareBoard[posX][posY].squareColor = Color.WHITE;
    }

    /**
     * Paints a square either LIGHT_GRAY or WHITE, based on the parity of the coordinates. On the traditional
     * chessboard, if the coordinates of a square have the same parity, the square is painted LIGHT_GRAY (or any dark
     * color).
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     */
    protected void paintSquareAt(int posX, int posY) {
        if (checkParity(posX, posY))
            paintGray(posX, posY);
        else paintWhite(posX, posY);
    }

    /**
     * Paints each square in the board according to the chessboard's specifications. Implementation of Board's abstract
     * method.
     */
    protected void paintSquares() {
        for (int posX = 0; posX < COLUMN_COUNT; posX++)
            for (int posY = 0; posY < ROW_COUNT; posY++)
                paintSquareAt(posX, posY);
    }

    /**
     * Sets up the traditional chessboard, which has a row of pawns defending a row of specific pieces: Rook - Knight -
     * Bishop - Queen - King - Bishop - Knight - Rook.
     */
    public void setupPieces() {
        for (int posY = 0; posY < ROW_COUNT; posY++) {
            putPieceAt(new Pawn(false), 1, posY);   // White pawns
            putPieceAt(new Pawn(true), 6, posY);    // Black pawns
        }

        // White pieces

        putPieceAt(new Rook(false), 0, 0);
        putPieceAt(new Knight(false), 0, 1);
        putPieceAt(new Bishop(false), 0, 2);
        putPieceAt(new Queen(false), 0, 3);
        putPieceAt(new King(false), 0, 4);
        putPieceAt(new Bishop(false), 0, 5);
        putPieceAt(new Knight(false), 0, 6);
        putPieceAt(new Rook(false), 0, 7);

        // Black pieces

        putPieceAt(new Rook(true), 7, 0);
        putPieceAt(new Knight(true), 7, 1);
        putPieceAt(new Bishop(true), 7, 2);
        putPieceAt(new Queen(true), 7, 3);
        putPieceAt(new King(true), 7, 4);
        putPieceAt(new Bishop(true), 7, 5);
        putPieceAt(new Knight(true), 7, 6);
        putPieceAt(new Rook(true), 7, 7);

        // Sets flag for game - if those pieces are in play, no other piece should be added

        gameFlag = true;
    }

    /**
     * Says if an X-coordinate is out of bounds on the board.
     *
     * @param posX desired X-coordinate of a square.
     * @return {@code true} if the X-coordinate is out of bounds.
     */
    public boolean xPosOutOfBounds(int posX) {
        return posX < 0 || posX >= COLUMN_COUNT;
    }

    /**
     * Says if a Y-coordinate is out of bounds on the board.
     *
     * @param posY desired Y-coordinate of a square.
     * @return {@code true} if the Y-coordinate is out of bounds.
     */
    public boolean yPosOutOfBounds(int posY) {
        return posY < 0 || posY >= ROW_COUNT;
    }


/*    private static final char[] LETTER_COORDINATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public char getLetterCoordinate(int posX) {
        return LETTER_COORDINATES[posX];
    }

    public void setupSquares() {
        maze = new Square[COLUMN_COUNT][ROW_COUNT];
        for (int posX = 0; posX < COLUMN_COUNT; posX++)
            for (int posY = 0; posY < ROW_COUNT; posY++)
                putSquareAt(posX, posY);
    }


   */
}
