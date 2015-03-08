package chess.controller;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.board.Square;
import chess.view.gui.BasicInterface;
import chess.view.gui.ChessInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <strong>Game</strong> class - implements the actual game of Chess.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class Game {

    private BasicInterface gameGUI;
    private JFrame chessFrame;
    private Square chosenSquare;
    private boolean squareSelected;

    /**
     * Starts a new game.
     */
    public Game() {
        Board gameBoard = new ChessBoard();
        gameBoard.setupPieces();
        gameGUI = new ChessInterface(gameBoard);
        squareSelected = false;
        chosenSquare = null;
        setFrame();
        fillFrame();
    }

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
    }

    /**
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        Game chessGame = new Game();
        chessGame.defineMouseListener();
        chessGame.chessFrame.setVisible(true);
    }

    /**
     * Defines a MouseListener for each square button on the GUI.
     */
    private void defineMouseListener() {
        for (int posX = 0; posX < 8; posX++) {
            for (int posY = 0; posY < 8; posY++) {
                final JButton button = gameGUI.getButtonAt(posX, posY);
                final int xPos = posX;
                final int yPos = posY;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (!squareSelected) {
                            if (gameGUI.hasPieceAt(xPos, yPos)) {
                                squareSelected = true;
                                chosenSquare = gameGUI.getSquareAt(xPos, yPos);
                                gameGUI.movesOf(chosenSquare.getSquarePiece());
                                button.setBackground(Color.CYAN);
                            }
                        } else {
                            Square newSquare = gameGUI.getSquareAt(xPos, yPos);
                            if (newSquare != chosenSquare) {
                                chosenSquare = newSquare;
                                gameGUI.originalPainting();
                                if (chosenSquare.getSquarePiece() != null)
                                    gameGUI.movesOf(chosenSquare.getSquarePiece());
                                button.setBackground(Color.CYAN);
                            } else {
                                gameGUI.originalPainting();
                                squareSelected = false;
                                chosenSquare = null;
                            }
                        }
                        System.out.println(xPos + "," + yPos);
                    }
                });
            }
        }
    }

}
