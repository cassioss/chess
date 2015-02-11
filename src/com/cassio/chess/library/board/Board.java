package com.cassio.chess.library.board;

import java.awt.*;

/**
 * Created by Cassio on 07/02/2015.
 */

public class Board {

    private Square[][] maze;
    private int rowCount = 8, columnCount = 8;

    private boolean blackColorParity = true;

    public Board() {
        setTiles();
    }

    private void setTiles() {
        maze = new Square[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++)
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
        return checkParity(tile) == blackColorParity ? Color.black : Color.white;
    }

    public void setSquareColor(Square tile) {
        tile.squareColor = chooseBlackOrWhite(tile);
    }
}
