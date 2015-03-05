package chess.controller;

import chess.model.board.ChessBoard;
import chess.view.gui.ChessInterface;

import java.util.HashMap;

/**
 * <strong>Game</strong> class - implements the actual game of Chess.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Game {

    private static final String PIECE_IN_CHECK = "King";
    private static ChessBoard gameBoard;
    private static ChessInterface chessGui;
    private int plays_counter;
    private HashMap<Integer, ChessBoard> previous_games;

    /**
     * Starts a new game.
     */
    public Game(){
        previous_games = new HashMap<Integer, ChessBoard>();
        plays_counter = 0;
        gameBoard = new ChessBoard();
        gameBoard.setupPieces();
        chessGui = new ChessInterface(gameBoard);
    }

    /**
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        new Game();
    }


}
