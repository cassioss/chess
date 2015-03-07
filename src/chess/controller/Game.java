package chess.controller;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.view.gui.BasicInterface;

import java.util.LinkedList;

/**
 * <strong>Game</strong> class - implements the actual game of Chess.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Game {

    private Board gameBoard;
    private BasicInterface gameGUI;
    private int plays_counter;
    private LinkedList<Board> previous_games;
    private boolean canRedo, canUndo;
    private boolean whitePlayerTurn;

    /**
     * Starts a new game.
     */
    public Game(Board gameBoard) {
        this.gameBoard = gameBoard;
        previous_games = new LinkedList<Board>();
        canRedo = canUndo = false;
        whitePlayerTurn = true;
        plays_counter = 0;
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
    private void begin() {
        gameBoard.setupPieces();
      //  gameGUI = new ChessInterface(gameBoard);
    }

    /**
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        Game chessGame = new Game(new ChessBoard());
        chessGame.begin();
    }

}
