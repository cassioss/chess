package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.Piece;

/**
 * {@code Board} class - abstract class for chessboards. Common methods are implemented, and board-dependent methods
 * (such as Square setup, Square painting, initial disposition of Pieces, and so on) are set as abstract.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */

public abstract class Board {

    protected Square[][] squareBoard;

    public Board() {
        setupSquares();
        paintSquares();
    }

    protected abstract void setupSquares();

    protected abstract void paintSquares();

    /**
     * Checks the existence of a square on the board at a specific position of the cartesian plane.
     *
     * @param targetX desired X-coordinate on the board to be verified.
     * @param targetY desired Y-coordinate on the board to be verified.
     * @return {@code true} if there is a square at the requested position of the plane.
     */
    public boolean hasSquareAt(int targetX, int targetY) {
        return squareBoard[targetX][targetY] != null;
    }

    /**
     * Gets the square at a certain position of the board.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     * @return the square at (posX, posY).
     */
    public Square getSquareAt(int posX, int posY) {
        return squareBoard[posX][posY];
    }

    protected void putPieceAt(Piece piece, int posX, int posY) {
        squareBoard[posX][posY].squarePiece = piece;
    }

    /**
      * Gets the piece at a certain position of the board.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     * @return the piece at (posX, posY).
     */
    public Piece getPieceAt(int posX, int posY){
        return squareBoard[posX][posY].getSquarePiece();
    }


    /**
     * Paints all the squares of the board. The loops treat the double array as jagged, so it goes through the entire
     * board.
     */
    /*private void paintSquares() {
        for (int posX = 0; posX < maze.length; posX++)
            for (int posY = 0; posY < maze[posX].length; posY++)
                paintSquare(posX, posY);
    }

    /**
     * Paints a square based on its position on the board. The algorithm may differ for different types of boards, so it
     * was kept as abstract.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     */
/*    protected abstract void paintSquare(int posX, int posY);

    

    /**
     * Gets the maximum value for an X-coordinate on the board.
     *
     * @return the length of the maze.
     */
    /*public int getLimitX() {
        return maze.length;
    }

    /**
     * Gets the maximum value for an Y-coordinate on the board, given the respective X-coordinate.
     *
     * @return the height of the maze at a certain X-coordinate.
     */
    /*public int getLimitY(int posX) {
        return maze[posX].length;
    }

    /**
     * Says if there is a piece of any kind at a certain position of the board.
     *
     * @param posX desired X-coordinate of a piece.
     * @param posY desired Y-coordinate of a piece.
     * @return {@code true} if there is a piece at that coordinate of the board.
     *//*
    public boolean hasPieceAt(int posX, int posY) {
        return maze[posX][posY].getPiece() != null;
    }*/

    /**
     * Says if there is a square at a certain position of the cartesian plane containing the board.
     *
     * @param posX desired X-coordinate of a piece.
     * @param posY desired Y-coordinate of a piece.
     * @return {@code true} if there is a square at that location.
     */
/*    public boolean hasSquareAt(int posX, int posY) {
        return maze[posX][posY] != null;
    }
    
    
    
    
/*
    public Board() {
        setupSquares();
        paintSquares();
        clearBoard();
    }

    public void paintSquares() {
        for (int posX = 0; posX < maze.length; posX++)
            for (int posY = 0; posY < maze[posX].length; posY++)
                paintSquare(posX, posY);
    }

    protected void putSquareAt(int posX, int posY) {
        maze[posX][posY] = new Square(this);
    }

    public boolean hasPieceAt(int posX, int posY) {
        return maze[posX][posY].hasPiece();
    }

    public boolean hasNoPieces() {
        for (Square[] squareColumn : maze) {
            for (Square square : squareColumn) {
                if (square.getPiece() != null)
                    return false;
            }
        }
        return true;
    }

    public void clearBoard() {
        for (Square[] squareColumn : maze) {
            for (Square square : squareColumn) {
                if (square.getPiece() != null)
                    square.removePiece();
            }
        }
    }

    // Abstract (board-dependent) methods

    protected abstract void setupSquares();

    protected abstract void paintSquare(int posX, int posY);

    public abstract void setupPieces();

    public abstract void putPieceAt(Piece piece, int targetX, int targetY);

    public abstract char getLetterCoordinate(int posX);

    public boolean hasSquareAt(int posX, int posY) {
        return maze[posX][posY] != null;
    }*/
}
