package com.cassio.chess.library.board;

import com.cassio.chess.library.piece.Piece;

/**
 * {@code Board} class - the Chess board, seen as a double array of Squares. Common methods are implemented and
 * board-dependent methods (such as Square setup, Square painting, initial disposition of Pieces, and so on) are set as
 * abstract.
 *
 * @author Cassio dos Santos Sousa
 */

public abstract class Board {

    public Square[][] maze;

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

    public Piece getPieceAt(int posX, int posY) {
        return maze[posX][posY].getPiece();
    }

    public Square getSquareAt(int posX, int posY) {
        return maze[posX][posY];
    }

    protected void putSquareAt(int posX, int posY) {
        maze[posX][posY] = new Square();
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
                    square.movePiece();
            }
        }
    }

    // Abstract (board-dependent) methods

    protected abstract void setupSquares();

    protected abstract void paintSquare(int posX, int posY);

    public abstract void setupPieces();

    public abstract void putPieceAt(Piece piece, int targetX, int targetY);

    public abstract char getLetterCoordinate(int posX);
}
