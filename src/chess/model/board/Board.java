package chess.model.board;

import exception.AlreadyHasPieceException;
import exception.InGameException;
import exception.PieceInPlaceException;
import chess.model.piece.Piece;

import java.awt.*;

/**
 * <strong>Board</strong> class - abstract class for chessboards. Common methods are implemented, and board-dependent
 * methods (such as Square setup, Square painting, initial disposition of Pieces, and so on) are set as abstract.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.2
 * @since 1.1
 */
public abstract class Board {

    protected Square[][] squareBoard;
    protected boolean gameFlag;

    /**
     * Creates a chess board with two abstract methods: one to set the positioning of the squares, and one to paint each
     * square accordingly (which is determined by the implementation of the board). As the board is only being created,
     * the GUI flag is set to <em>false</em>.
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
     * Abstract method to set pieces for a board-specific view. No pieces can be added after a view has begun.
     */
    public abstract void setupPieces();

    /**
     * Checks the existence of a square on the board at a specific position of the cartesian plane.
     *
     * @param targetX desired X-coordinate on the board to be verified.
     * @param targetY desired Y-coordinate on the board to be verified.
     * @return <em>true</em> if there is a square at the requested position of the plane.
     */
    public boolean hasSquareAt(int targetX, int targetY) {
        return !(xPosOutOfBounds(targetX) || yPosOutOfBounds(targetY)) && squareBoard[targetX][targetY] != null;
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
     * @return <em>true</em> if there is a piece on that position.
     */
    public boolean hasPieceAt(int posX, int posY) {
        return !(xPosOutOfBounds(posX) || yPosOutOfBounds(posY)) && squareBoard[posX][posY].getSquarePiece() != null;
    }

    /**
     * Puts a piece on a square. As this function is specific for piece setup, if a person tries to put a piece on the
     * square of another piece, an exception must be thrown.
     *
     * @param piece a piece to be put at a specific position.
     * @param posX  desired X-coordinate of the piece.
     * @param posY  desired Y-coordinate of the piece.
     */
    public void putPieceAt(Piece piece, int posX, int posY) {
        if (isInGame())
            throw new InGameException("You tried to set a piece when a game is already being played");
        if (alreadyHasPieceOnBoard(piece))
            throw new AlreadyHasPieceException("You tried to add the same piece twice on the board");
        if (hasPieceAt(posX, posY))
            throw new PieceInPlaceException("You tried to set a piece on the same place as another piece");
        squareBoard[posX][posY].squarePiece = piece;
        piece.learnMoveSetFrom(squareBoard[posX][posY], this);
        updateAllPieces();
    }

    /**
     * Moves a piece to a specific square on the board. After updating the piece, all move sets must be updated.
     *
     * @param originalSquare original square of a piece.
     * @param posX           desired X-coordinate of the piece.
     * @param posY           desired Y-coordinate of the piece.
     */
    public void movePieceTo(Square originalSquare, int posX, int posY) {
        squareBoard[posX][posY].squarePiece = originalSquare.getSquarePiece();
        originalSquare.squarePiece = null;
        updateAllPieces();
    }

    /**
     * Updates the move set of all pieces in the board.
     */
    private void updateAllPieces() {
        for (Square[] squareArray : squareBoard) {
            for (Square square : squareArray) {
                if (square.getSquarePiece() != null) {
                    square.getSquarePiece().updateMoveSet();
                }
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
     * Checks whether a board is being used in a view. If it is, no pieces can be added to the board.
     *
     * @return <em>true</em> if the board is already being used in the view.
     */
    public boolean isInGame() {
        return gameFlag;
    }

    /**
     * Checks if a piece is already on board.
     *
     * @param piece a piece to be compared.
     * @return <em>true</em> if this piece is already on board.
     */
    public boolean alreadyHasPieceOnBoard(Piece piece) {
        for (Square[] squareArray : squareBoard) {
            for (Square square : squareArray) {
                if (square.getSquarePiece() == piece)
                    return true;
            }
        }
        return false;
    }

    /**
     * Says if an X-coordinate is out of bounds on the board.
     *
     * @param posX desired X-coordinate of a square.
     * @return <em>true</em> if the X-coordinate is out of bounds.
     */
    public abstract boolean xPosOutOfBounds(int posX);

    /**
     * Says if a Y-coordinate is out of bounds on the board.
     *
     * @param posY desired Y-coordinate of a square.
     * @return <em>true</em> if the Y-coordinate is out of bounds.
     */
    public abstract boolean yPosOutOfBounds(int posY);

    /**
     * Show all the square a piece can move to.
     *
     * @param selectedPiece piece selected by a player.
     */
    public void showAvailableMovesOf(Piece selectedPiece) {
        for (Square[] squareArray : squareBoard) {
            for (final Square s : squareArray) {
                if (selectedPiece.canMoveTo(s)) {
                    s.squareColor = Color.GREEN;
                    //System.out.println("Painted move");
                }
            }
        }
    }

    /**
     * Returns the original coloring of the chessboard when a piece is unselected.
     */
    public void deselectPiece() {
        paintSquares();
    }

    /**
     * Checks whether a square is being threatened by the opponent.
     *
     * @param posX        X-coordinate to be checked.
     * @param posY        Y-coordinate to be checked.
     * @param colorChoice color of the royal piece in question.
     * @return <em>true</em> if an opponent can move to that square.
     */
    public boolean checkThreatAt(int posX, int posY, boolean colorChoice) {
        for (Square[] squareArray : squareBoard) {
            for (Square square : squareArray) {
                if (square.getSquarePiece() != null && square.getSquarePiece().isBlack() != colorChoice) {
                    if (square.getSquarePiece().canMoveTo(squareBoard[posX][posY]))
                        return true;
                }
            }
        }
        return false;
    }
}
