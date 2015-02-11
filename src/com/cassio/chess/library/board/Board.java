package com.cassio.chess.library.board;

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
            for (int column = 0; column < COLUMN_COUNT; column++)
                maze[row][column] = new Square(row, column);
        }
    }

    public Square getSquare(int row, int column) {
        return maze[row][column];
    }


    private boolean checkParity(Square tile) {
        int tileX = tile.getX();
        int tileY = tile.getY();
        return tileX % 2 == tileY % 2;
    }

    private Color chooseBlackOrWhite(Square tile) {
        return checkParity(tile) ? Color.black : Color.white;
    }

    public void setSquareColor(Square tile) {
        tile.squareColor = chooseBlackOrWhite(tile);
    }

    public char getLetterCoordinate(int x) {
        return LETTER_COORDINATES[x];
    }

}
