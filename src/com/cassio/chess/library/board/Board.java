package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.Piece;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
 */

public class Board {

    private Square[][] maze;
    private static final char[] LETTER_COORDINATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
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
        //for(int column = 0; column < COLUMN_COUNT; column++)
            
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

    private void paintBlack(int row, int column) {
        maze[row][column].squareColor = Color.BLACK;
    }

    private void paintWhite(int row, int column) {
        maze[row][column].squareColor = Color.WHITE;
    }

    public char getLetterCoordinate(int x) {
        return LETTER_COORDINATES[x];
    }

    public void putPieceAt(Piece piece, int targetX, int targetY) {
        maze[targetX][targetY].putPiece(piece);
    }

    public Piece getPieceAt(int posX, int posY) {
        return maze[posX][posY].getPiece();
    }
}
