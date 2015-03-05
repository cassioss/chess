package chess.model.piece;

import chess.model.board.Board;
import chess.model.board.Square;
import chess.model.moves.MoveSet;

import java.util.HashSet;

/**
 * <strong>Piece</strong> class - defines basic attributes of a piece (color, move set, path to image and how up-to-date
 * is its move set). The creation of a piece and its positioning (as well as implementation of moves) is dependent on
 * the board.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.2
 * @since 1.1
 */
public abstract class Piece {

    protected boolean isBlack;
    protected boolean isUpToDate;
    protected MoveSet referenceMoveSet;
    protected HashSet<Square> moveSet;

    /**
     * Creates a piece based on its color (black or white). As the piece was probably just added to a board, its move
     * set is empty, and the piece is outdated.
     *
     * @param colorChoice a boolean value defining the color of the piece (black if {@code true}, white otherwise).
     */
    public Piece(boolean colorChoice) {
        isBlack = colorChoice;
        isUpToDate = false;
        moveSet = new HashSet<Square>();
    }

    /**
     * Gets the color choice of the piece.
     *
     * @return <em>true</em> if the piece color is black, <em>false</em> if the piece color is white.
     */
    public boolean isBlack() {
        return this.isBlack;
    }

    /**
     * Updates a piece's MoveSet. This function is only called by a chessboard.
     */
    public void updateMoveSet() {
        moveSet.clear();
        referenceMoveSet.requestUpdate();
        moveSet = referenceMoveSet.getMoves();
    }

    /**
     * Gets a specific MoveSet implementation to ease updating. This method is only called by a chessboard, right after
     * the piece's creation.
     *
     * @param referenceSquare the square to be used as reference for the MoveSet object.
     * @param referenceBoard  the chessboard to be used as reference for the MoveSet object.
     */
    public abstract void learnMoveSetFrom(Square referenceSquare, Board referenceBoard);

    /**
     * Checks if a square is in the piece's move set, in order to verify if a specific move is possible.
     *
     * @param square a desired square for movement.
     * @return <em>true</em> if the square is in the move set of the piece.
     */
    public boolean canMoveTo(Square square) {
        return moveSet.contains(square);
    }

    /**
     * Gets the relative path to a piece's image. The figures follow the same naming pattern.
     *
     * @return a String referring to a path to the piece's image.
     */
    public String getPathToImage() {
        String path = "src/com/cassio/chess/img/";
        if (isBlack())
            path += "black_";
        else
            path += "white_";
        path += this.getClass().getSimpleName().toLowerCase() + ".png";
        return path;
    }

    /**
     * Moves to a determined square of the board.
     *
     * @param targetX desired X-coordinate to move to.
     * @param targetY desired Y-coordinate to move to.
     */
    public void moveTo(int targetX, int targetY) {
        referenceMoveSet.declareMove(targetX, targetY);
    }

}
