package chess.controller;

import chess.model.board.ChessBoard;
import chess.view.gui.ChessInterface;

/**
 * <strong>Game</strong> class - implements the actual game of Chess.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Game {

    private static final String PIECE_IN_CHECK = "King";
    private static ChessBoard gameBoard;

    /**
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        gameBoard = new ChessBoard();
        gameBoard.setupPieces();
        new ChessInterface(gameBoard);
    }


}
