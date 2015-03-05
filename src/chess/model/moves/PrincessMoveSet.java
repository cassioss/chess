package chess.model.moves;

import chess.model.board.Board;
import chess.model.board.Square;

/**
 * <strong>PrincessMoveSet</strong>  class - implementation of MoveSet class for princesses. A princess is a fairy chess
 * piece with the compound moves of a Knight piece and a Bishop piece. Although this piece gets the moves of a Knight,
 * it can only jump to other squares when it moves as a Knight.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 * @see <a href="http://en.wikipedia.org/wiki/Fairy_chess_piece">Fairy Chess pieces - Wikipedia</a>
 */
public class PrincessMoveSet extends MoveSet {

    /**
     * Creates a new Princess move set having a square, a board and a color as reference.
     *
     * @param referenceSquare the square to be taken as reference for relative moves.
     * @param referenceBoard  the board to be taken as reference for moves.
     * @param colorChoice     the color choice of the piece, in case a piece has color limitations.
     */
    public PrincessMoveSet(Square referenceSquare, Board referenceBoard, boolean colorChoice) {
        super(referenceSquare, referenceBoard, colorChoice);
    }

    /**
     * Process the piece-specific algorithms to acquire the allowed squares to move to.
     */
    protected void learnMoveSet() {
        MoveSet knightMoves = new KnightMoveSet(referenceSquare, referenceBoard, colorChoice);
        MoveSet bishopMoves = new BishopMoveSet(referenceSquare, referenceBoard, colorChoice);
        knightMoves.learnMoveSet();
        bishopMoves.learnMoveSet();
        possibleMoves.addAll(knightMoves.getMoves());
        possibleMoves.addAll(bishopMoves.getMoves());
    }
}
