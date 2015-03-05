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
    
    /**
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        ChessBoard newBoard = new ChessBoard();
        newBoard.setupPieces();
        new ChessInterface(newBoard);
    }
}
