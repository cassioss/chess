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

    private ChessBoard gameBoard;
    private ChessInterface chessGui;
    private int plays_counter;
    private LinkedList<ChessBoard> previous_games;
    private boolean canRedo, canUndo;
    private boolean whitePlayerTurn;

    /**
     * Starts a new game.
     */
    public Game() {
        previous_games = new LinkedList<ChessBoard>();
        plays_counter = 0;
        canRedo = canUndo = false;
        gameBoard = new ChessBoard();
        whitePlayerTurn = true;
    }

    /**
     * Method that undoes the previous move, if possible.
     */
    private void undo() {
        if (canUndo) {
            gameBoard = previous_games.get(--plays_counter);
        }
    }

    /**
     * Method that redoes an undone move, if possible.
     */
    private void redo() {
        if (canRedo) {
            gameBoard = previous_games.get(plays_counter++);
        }
    }

    /**
     * Saves the existing game.
     */
    private void saveGame() {
        previous_games.add(plays_counter++, gameBoard);
        canRedo = false;
    }

    /**
     * Starts the game itself.
     */
    private void beginGame() {
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
