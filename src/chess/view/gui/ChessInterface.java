package chess.view.gui;

import chess.model.board.Board;

/**
 * <strong>ChessInterface</strong> class - class that handles how the chessboard (including squares and pieces) is going
 * to be drawn.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class ChessInterface extends BasicInterface {

    public ChessInterface(Board chessModel) {
        super(chessModel);
    }
}