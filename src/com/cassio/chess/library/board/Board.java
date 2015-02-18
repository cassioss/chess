package com.cassio.chess.library.board;

import com.cassio.chess.exception.board.InGameException;
import com.cassio.chess.exception.board.AlreadyHasPieceException;
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
    protected boolean gameFlag;

    /**
     * Creates a chess board with two abstract methods: one to set the positioning of the squares, and one to paint each
     * square accordingly (which is determined by the implementation of the board). As the board is only being created,
     * the game flag is set to {@code false}.
     */
    public Board() {
        setupSquares();
        paintSquares();
        gameFlag = false;
    }

    /**
     * Abstract method to create squares at specific positions of the board.
     */
    protected abstract void setupSquares();

    /**
     * Abstract method to paint (assign a awt.Color to) each square of the board accordingly.
     */
    protected abstract void paintSquares();

    /**
     * Abstract method to set pieces for a board-specific game. No pieces can be added after a game has begun.
     */
    public abstract void setupPieces();

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

    /**
     * Checks if there is a piece in a certain position of the board.
     *
     * @param posX desired X-coordinate of a square to be inspected.
     * @param posY desired Y-coordinate of a square to be inspected.
     * @return {@code true} if there is a piece on that position.
     */
    public boolean hasPieceAt(int posX, int posY) {
        return squareBoard[posX][posY].getSquarePiece() != null;
    }

    /**
     * Puts a piece on a square. As this function is specific for piece setup, if a person tries to put a piece on the
     * square of another piece, an exception must be thrown.
     *
     * @param piece a piece to be put at a specific position.
     * @param posX  desired Y-coordinate of the piece.
     * @param posY  desired Y-coordinate of the piece.
     */
    public void putPieceAt(Piece piece, int posX, int posY) {
        if (isInGame())
            throw new InGameException("You tried to set a piece when a game is already being played");
        else {
            if (hasPieceAt(posX, posY))
                throw new AlreadyHasPieceException("You tried to set a piece on the same place as another piece");
            else {
                squareBoard[posX][posY].squarePiece = piece;
                piece.learnMoveSetFrom(squareBoard[posX][posY], this);
            }
        }
    }

    /**
     * Gets the piece at a certain position of the board.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     * @return the piece at (posX, posY).
     */
    public Piece getPieceAt(int posX, int posY) {
        return squareBoard[posX][posY].getSquarePiece();
    }

    /**
     * Checks whether a board is being used in a game. If it is, no pieces can be added to the board.
     *
     * @return {@code true} if the board is already being used in the game.
     */
    public boolean isInGame() {
        return gameFlag;
    }

    public int getLimitX() {
        return squareBoard.length;
    }


    public int getLimitY(int posX) {
        return squareBoard[posX].length;
    }


/*
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
