package chess.controller;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.view.gui.BasicInterface;
import chess.view.gui.ChessInterface;

import javax.swing.*;
import java.util.Stack;

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
    private Stack<Board> previous_games;
    private boolean canRedo, canUndo;
    private boolean whitePlayerTurn;
    private JFrame chessFrame;

    /**
     * Configures the main JFrame object for the chess game.
     */
    private void setFrame() {
        chessFrame = new JFrame("♚ Chess Game ♔");
        chessFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chessFrame.setSize(1100, 880);
        chessFrame.setResizable(false);
        chessFrame.setLocation(350, 50);
        chessFrame.setVisible(true);
    }

    /**
     * Fills the frame with.
     */
    private void fillFrame() {
        JSplitPane gamePanel = gameGUI.getChessPanel();
        chessFrame.add(gamePanel);
        chessFrame.setVisible(true);
    }

    /**
     * Starts a new game.
     */
    public Game() {
        gameBoard = new ChessBoard();
        gameBoard.setupPieces();
        gameGUI = new ChessInterface(gameBoard);
        previous_games = new Stack<Board>();
        canRedo = canUndo = false;
        whitePlayerTurn = true;
        setFrame();
        fillFrame();
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
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        Game chessGame = new Game();
    }

}
