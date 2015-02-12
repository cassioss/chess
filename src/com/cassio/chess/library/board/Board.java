package com.cassio.chess.library.board;

import com.cassio.chess.exception.AlreadyHasPieceException;
import com.cassio.chess.library.piece.*;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
 */

public abstract class Board {

    public Square[][] maze;
    private static final int ROW_COUNT = 8, COLUMN_COUNT = 8;

    public Board() {
        createTiles();
    }

    private void createTiles() {
        maze = new Square[ROW_COUNT][COLUMN_COUNT];
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COLUMN_COUNT; column++) {
                putSquareAt(row, column);
                paintBlackOrWhite(row, column);
            }
        }
    }

    public void setupPieces() {
        cleanBoard();
        for (int column = 0; column < COLUMN_COUNT; column++) {
            putPieceAt(new Pawn(Color.WHITE), 1, column);
            putPieceAt(new Pawn(Color.BLACK), 6, column);
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

    private void putSquareAt(int row, int column) {
        maze[row][column] = new Square();
    }

    public Square getSquareAt(int row, int column) {
        return maze[row][column];
    }

    private boolean checkParity(int a, int b) {
        return (a + b) % 2 == 0;
    }

    private void paintBlackOrWhite(int row, int column) {
        if (checkParity(row, column))
            paintBlack(row, column);
        else paintWhite(row, column);
    }

    private void paintBlack(int posX, int posY) {
        maze[posX][posY].squareColor = Color.BLACK;
    }

    private void paintWhite(int posX, int posY) {
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

    public Piece getPieceAt(int posX, int posY) {
        return maze[posX][posY].getPiece();
    }

    public boolean hasNoPieces() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COLUMN_COUNT; column++) {
                if (maze[row][column].getPiece() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void cleanBoard() {
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COLUMN_COUNT; column++) {
                if (maze[row][column].getPiece() != null)
                    maze[row][column].movePiece();
            }
        }
    }

    public abstract char getLetterCoordinate(int posX);
}
