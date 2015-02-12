package com.cassio.chess.library.board;

import com.cassio.chess.exception.AlreadyHasPieceException;
import com.cassio.chess.library.piece.*;

import java.awt.*;

/**
 * <code>ChessBoard</code> class - the classic Chess board - 8x8 Squares, 16 Pieces for each player, alternate painting
 * of Squares as black or white.
 *
 * @author Cassio dos Santos Sousa
 */

public class Chessboard extends Board {

    private static final int ROW_COUNT = 8, COLUMN_COUNT = 8;

    public Chessboard() {
        super();
    }

    private static final char[] LETTER_COORDINATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public char getLetterCoordinate(int posX) {
        return LETTER_COORDINATES[posX];
    }

    public void setupPieces() {
        cleanBoard();
        for (int posY = 0; posY < ROW_COUNT; posY++) {
            putPieceAt(new Pawn(Color.WHITE), 1, posY);
            putPieceAt(new Pawn(Color.BLACK), 6, posY);
        }
        putPieceAt(new Rook(Color.WHITE), 0, 0);
        putPieceAt(new Knight(Color.WHITE), 0, 1);
        putPieceAt(new Bishop(Color.WHITE), 0, 2);
        putPieceAt(new Queen(Color.WHITE), 0, 3);
        putPieceAt(new King(Color.WHITE), 0, 4);
        putPieceAt(new Bishop(Color.WHITE), 0, 5);
        putPieceAt(new Knight(Color.WHITE), 0, 6);
        putPieceAt(new Rook(Color.WHITE), 0, 7);

        putPieceAt(new Rook(Color.BLACK), 7, 0);
        putPieceAt(new Knight(Color.BLACK), 7, 1);
        putPieceAt(new Bishop(Color.BLACK), 7, 2);
        putPieceAt(new Queen(Color.BLACK), 7, 3);
        putPieceAt(new King(Color.BLACK), 7, 4);
        putPieceAt(new Bishop(Color.BLACK), 7, 5);
        putPieceAt(new Knight(Color.BLACK), 7, 6);
        putPieceAt(new Rook(Color.BLACK), 7, 7);
    }

    public void setupSquares() {
        maze = new Square[COLUMN_COUNT][ROW_COUNT];
        for (int posX = 0; posX < COLUMN_COUNT; posX++)
            for (int posY = 0; posY < ROW_COUNT; posY++)
                putSquareAt(posX, posY);
    }

    public boolean checkParity(int a, int b) {
        return (a + b) % 2 == 0;
    }

    protected void paintSquare(int posX, int posY) {
        if (checkParity(posX, posY))
            paintBlack(posX, posY);
        else paintWhite(posX, posY);
    }

    protected void paintBlack(int posX, int posY) {
        maze[posX][posY].squareColor = Color.BLACK;
    }

    protected void paintWhite(int posX, int posY) {
        maze[posX][posY].squareColor = Color.WHITE;
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
    }
}
