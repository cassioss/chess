package chess.model.moves;

import chess.model.board.Board;
import chess.model.board.Square;

import java.util.HashSet;

/**
 * <strong>MoveSet</strong> class - has a list of possible squares for a piece to move in a board. The main reasons for
 * creating this class is that (1) most pieces share the same moves (for example, the Queen can move the same way as a
 * Rook or a Bishop), (2) sets do not accept copies, and (3) having a set of possible moves eases the job to find
 * whether a King piece is in check or checkmate. It is abstract so it can be implemented differently for each piece.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public abstract class MoveSet {

    protected HashSet<Square> possibleMoves;
    protected Square referenceSquare;
    protected Board referenceBoard;
    protected boolean colorChoice;
    private boolean isFirstMove;

    /**
     * Creates a new move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public MoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        this.referenceSquare = referenceSquare;
        this.referenceBoard = referenceBoard;
        this.colorChoice = colorChoice;
        isFirstMove = true;
        possibleMoves = new HashSet<Square>();
        learnMoveSet();
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to.
     */
    protected abstract void learnMoveSet();

    /**
     * Returns a set with all the squares that a piece is allowed to move to.
     *
     * @return a HashSet with all the squares on the move set.
     */
    public HashSet<Square> getMoves() {
        return possibleMoves;
    }

    /**
     * Checks if a piece in a certain square of the chessboard (if any) is the player's piece.
     *
     * @param posX X-coordinate of the piece to be compared.
     * @param posY Y-coordinate of the piece to be compared.
     * @return <em>true</em> if there is a piece on that position and if the pieces have the same color.
     */
    protected boolean playerPieceAt(int posX, int posY) {
        return referenceBoard.hasPieceAt(posX, posY) && referenceBoard.getPieceAt(posX, posY).isBlack() ==
                this.colorChoice;
    }

    /**
     * Checks if a piece in a certain square of the chessboard (if any) is the opponent's piece.
     *
     * @param posX X-coordinate of the piece to be compared.
     * @param posY Y-coordinate of the piece to be compared.
     * @return <em>true</em> if there is a piece on that position and if the pieces have different colors.
     */
    protected boolean opponentPieceAt(int posX, int posY) {
        return referenceBoard.hasPieceAt(posX, posY) && referenceBoard.getPieceAt(posX, posY).isBlack() !=
                this.colorChoice;
    }

    /**
     * Adds a square to the move set having referenceBoard's origin as reference. For most pieces, you only need to
     * avoid squares that have a player's piece on it.
     *
     * @param posX cartesian X-coordinate of the square on the board.
     * @param posY cartesian Y-coordinate of the square on the board.
     */
    protected void addSquareAt(int posX, int posY) {
        if (referenceBoard.hasSquareAt(posX, posY) && !playerPieceAt(posX, posY))
            possibleMoves.add(referenceBoard.getSquareAt(posX, posY));
    }

    /**
     * Returns the X-coordinate of the referenced square.
     *
     * @return the X-coordinate of referenceSquare on the board.
     */
    protected int getRefX() {
        return referenceSquare.getPosX();
    }

    /**
     * Returns the Y-coordinate of the referenced square.
     *
     * @return the Y-coordinate of referenceSquare on the board.
     */
    protected int getRefY() {
        return referenceSquare.getPosY();
    }

    /**
     * Checks whether this is the first move of a piece. Useful for pawns, which may move two squares instead of one on
     * the first turn.
     *
     * @return <em>true</em> if it is the first move of a piece.
     */
    public boolean isFirstMove() {
        return isFirstMove;
    }

    /**
     * Updates a piece's move set by request.
     */
    public void requestUpdate() {
        learnMoveSet();
    }

    /**
     * Effectively declares a move on the board. If the intended position for the move is available on the
     * chessboard, all variables involved change accordingly.
     *
     * @param posX the intended X-coordinate of a move.
     * @param posY the intended Y-coordinate of a move.
     */
    public void declareMove(int posX, int posY) {
        if (possibleMoves.contains(referenceBoard.getSquareAt(posX, posY))) {
            Square previousSquare = referenceSquare;
            changeReferenceSquareTo(posX, posY);
            possibleMoves.clear();
            possibleMoves = new HashSet<Square>();
            notFirstMove();
            referenceBoard.movePieceTo(previousSquare, posX, posY);
        }
    }

    /**
     * Helper method that turns the first-move boolean into <em>false</em>.
     */
    private void notFirstMove(){
        if(isFirstMove)
            isFirstMove = false;
    }

    /**
     * Changes the referenced square used for the moveSet to one of the squares on the referenced Board.
     *
     * @param posX desired X-coordinate of a square.
     * @param posY desired Y-coordinate of a square.
     */
    private void changeReferenceSquareTo(int posX, int posY) {
        referenceSquare = referenceBoard.getSquareAt(posX, posY);
    }
}
