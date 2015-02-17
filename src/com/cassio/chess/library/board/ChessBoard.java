package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.*;

import java.awt.*;

/**
 * {@code ChessBoard} class - the classic Chess board: 8x8 Squares, 16 Pieces for each player, alternate painting of
 * Squares as either black or white.
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
     * Paints a square with the color BLACK.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     */
    private void paintBlack(int posX, int posY) {
        squareBoard[posX][posY].squareColor = Color.BLACK;
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
     * Paints a square either BLACK or WHITE, based on the parity of the coordinates. On the traditional chessboard, if
     * the coordinates of a square have the same parity, the square is painted BLACK.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     */
    protected void paintSquareAt(int posX, int posY) {
        if (checkParity(posX, posY))
            paintBlack(posX, posY);
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


    public void putPieceAt(Piece piece, int targetX, int targetY) {
        if (targetX < 0 || targetX > COLUMN_COUNT)
            throw new IndexOutOfBoundsException("You tried to put a piece out of the board.");
        if (targetY < 0 || targetY > ROW_COUNT)
            throw new IndexOutOfBoundsException("You tried to put a piece out of the board.");
        if (maze[targetX][targetY].hasPiece())
            throw new AlreadyHasPieceException("You tried to put a piece over another one.");
        maze[targetX][targetY].putPiece(piece);
        piece.bePutOnBoard(this, targetX, targetY);
    }*/
}
