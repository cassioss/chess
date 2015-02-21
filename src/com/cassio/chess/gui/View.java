package com.cassio.chess.gui;

import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.board.Square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * <strong>View</strong> class - class that handles how the chessboard (including squares and pieces) is going to be
 * drawn.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class View implements ActionListener {

    SquareBoardPaint squarePane;

    /**
     * Draws a chessboard on the screen.
     *
     * @param referenceBoard chessboard used as reference.
     */
    public View(ChessBoard referenceBoard) {
        JFrame frame = new JFrame("\u265A Chess Game \u2654");
        squarePane = new SquareBoardPaint();
        fillBoard(referenceBoard);
        frame.setContentPane(squarePane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(807, 830);
        frame.setLocation(350, 50);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Goes through an entire board to get each one of the squares in it. Having only the square colors is enough to
     * draw the board, but having the squares referenced eases up the drawing of pieces. The change of xPos for yPos on
     * the positioning coordinates is required to present the pieces in the expected way.
     *
     * @param referenceBoard chessboard used as reference.
     */
    private void fillBoard(ChessBoard referenceBoard) {
        for (int xPos = 0; xPos < 8; xPos++) {
            for (int yPos = 0; yPos < 8; yPos++)
                squarePane.addSquareAt(referenceBoard.getSquareAt(xPos, yPos), yPos * 100, xPos * 100);
        }
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e some action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * {@code SquareBoardPaint} class - inner class that keeps track of every square that needs to be drawn on the
     * board.
     *
     * @author Cassio dos Santos Sousa
     * @version 1.0
     */
    protected class SquareBoardPaint extends JPanel {

        private final ArrayList<SquarePaint> squares = new ArrayList<SquarePaint>();

        protected void addSquareAt(Square square, int xPos, int yPos) {
            squares.add(new SquarePaint(square, xPos, yPos));
        }

        protected void paintComponent(Graphics g) {
            for (final SquarePaint square : squares) {
                Graphics2D g2 = (Graphics2D) g;
                square.paint(g2);
            }
        }
    }

    /**
     * <strong>SquarePaint</strong> class - inner class that handles how each square is going to be drawn.
     *
     * @author Cassio dos Santos Sousa
     * @version 1.0
     */
    protected class SquarePaint {
        private int xPos, yPos;
        private Square referenceSquare;

        public SquarePaint(Square square, int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.referenceSquare = square;
        }

        public void paint(Graphics2D g) {
            g.drawRect(xPos, yPos, 100, 100);
            g.setColor(referenceSquare.getSquareColor());
            g.fillRect(xPos + 1, yPos + 1, 99, 99);
            g.setColor(Color.BLACK);
            if (referenceSquare.getSquarePiece() != null) {
                try {
                    BufferedImage img = ImageIO.read(new File(referenceSquare.getSquarePiece().getPathToImage()));
                    g.drawImage(img, xPos, yPos, null);
                } catch (IOException e) {
                    System.out.println("Exception happened:" + e.getMessage());
                }

            }
        }
    }

    /**
     * Main function that draws a new chessboard.
     *
     * @param args String entries - none are required.
     */
    public static void main(String[] args) {
        ChessBoard newBoard = new ChessBoard();
        newBoard.setupPieces();
        new View(newBoard);
    }
}