package chess.controller;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.view.gui.BasicInterface;

import javax.swing.*;
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
    private JFrame chessFrame;

    private void setFrame() {
        chessFrame = new JFrame("♚ Chess Game ♔");
        chessFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        chessFrame.setSize(880, 880);
        chessFrame.setResizable(false);
        chessFrame.setLocation(350, 50);
        chessFrame.setVisible(true);
    }

    private void fillFrame() {
        JPanel gamePanel = gameGUI.getChessPanel();
        chessFrame.add(gamePanel);
        chessFrame.setVisible(true);
    }

    /**
     * Starts a new game.
     */
    public Game() {
        gameBoard = new ChessBoard();
        gameBoard.setupPieces();
        gameGUI = new BasicInterface(gameBoard);
        previous_games = new LinkedList<Board>();
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
