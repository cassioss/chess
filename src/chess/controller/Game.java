package chess.controller;

import chess.model.board.ChessBoard;
import chess.view.gui.ChessInterface;

import java.util.LinkedList;

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
    private LinkedList<ChessBoard> previous_games;
    private boolean canRedo, canUndo;
    private boolean whitePlayerTurn;

    /**
     * Starts a new game.
     */
    public Game(){
        previous_games = new LinkedList<ChessBoard>();
        plays_counter = 0;
        canRedo = canUndo = false;
        gameBoard = new ChessBoard();
        whitePlayerTurn = true;
    }

    private void undo(){

    }

    /**
     * Returns the game to the previous play.
     */
    private void redo(){

    }

    /**
     * Saves the existing game.
     */
    private void saveGame(){
        previous_games.add(plays_counter++, gameBoard);
        canRedo = false;
    }

    /**
     * Starts the game itself.
     */
    private void beginGame(){
        gameBoard.setupPieces();
        chessGui = new ChessInterface(gameBoard);
    }

    /**
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        Game chessGame = new Game();
        chessGame.beginGame();
    }


}
