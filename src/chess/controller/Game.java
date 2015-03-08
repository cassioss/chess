package chess.controller;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.board.Square;
import chess.model.piece.Piece;
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
    private boolean aPieceWasSelected;
    private boolean blackTurn;

    /**
     * Starts a new game.
     */
    public Game() {
        Board gameBoard = new ChessBoard();
        gameBoard.setupPieces();
        gameGUI = new ChessInterface(gameBoard);
        aPieceWasSelected = false;
        chosenSquare = null;
        blackTurn = false;
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
                        if (!aPieceWasSelected) {
                            if (gameGUI.hasPieceAt(xPos, yPos)) {
                                if (gameGUI.getPieceAt(xPos, yPos).isBlack() ==
                                        blackTurn) {
                                    aPieceWasSelected = true;
                                    chosenSquare = gameGUI.getSquareAt(xPos, yPos);
                                    gameGUI.movesOf(chosenSquare.getSquarePiece());
                                    button.setBackground(Color.CYAN);
                                } else {
                                    wrongPieceColor();
                                }
                            }
                        } else {
                            Square newSquare = gameGUI.getSquareAt(xPos, yPos);
                            if (newSquare != chosenSquare)
                                if (chosenSquare.getSquarePiece() != null && chosenSquare.getSquarePiece().canMoveTo
                                        (newSquare)) {
                                    final Piece piece = chosenSquare.getSquarePiece();
                                    piece.moveTo(xPos, yPos);
                                    cleanBoardAndReferences();
                                    blackTurn = !blackTurn;
                                } else {
                                    chosenSquare = newSquare;
                                    gameGUI.originalPainting();
                                    if (chosenSquare.getSquarePiece() != null)
                                        gameGUI.movesOf(chosenSquare.getSquarePiece());
                                    button.setBackground(Color.CYAN);
                                }
                            else {
                                cleanBoardAndReferences();
                                cancelMove();
                            }
                        }
                        System.out.println(xPos + "," + yPos);
                    }
                });
            }
        }
    }

    /**
     * Cleans board after a move was successfully made or cancelled.
     */
    private void cleanBoardAndReferences() {
        gameGUI.originalPainting();
        chosenSquare = null;
        aPieceWasSelected = false;
    }

    private void cancelMove() {
        gameGUI.setMessage(playerColorUppercase() + "player has cancelled his selection. Try another one.");
    }

    private void wrongPieceColor() {
        gameGUI.setMessage("You tried to move an opponent's piece. You only move " + playerColorLowercase() + "pieces.");
    }

    private String playerColorUppercase() {
        return blackTurn ? "Black " : "White ";
    }

    private String playerColorLowercase() {
        return playerColorUppercase().toLowerCase();
    }

}
