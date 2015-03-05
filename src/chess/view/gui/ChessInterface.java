package chess.view.gui;

import chess.model.board.ChessBoard;
import chess.model.board.Square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
public class ChessInterface {

    SquareBoardPaint squarePane;
    JButton[][] buttonGrid;

    /**
     * Draws a chessboard on the screen.
     *
     * @param referenceBoard chessboard used as reference for painting.
     */
    public ChessInterface(ChessBoard referenceBoard) {
        JFrame frame = new JFrame("\u265A Chess Game \u2654");
        buttonGrid = new JButton[8][8];
        paintBoardIn(referenceBoard, frame);
        setFrame(frame);
    }

    /**
     * Paints a chessboard by creating a JPanel inside a JFrame.
     *
     * @param board chessboard used as reference.
     * @param frame JFrame object used for the GUI.
     */
    private void paintBoardIn(ChessBoard board, JFrame frame) {
        squarePane = new SquareBoardPaint();
        fillBoard(board);
        frame.setContentPane(squarePane);
        frame.pack();
    }

    /**
     * Set properties of a chessboard JFrame.
     *
     * @param frame JFrame used for GUI View.
     */
    private void setFrame(JFrame frame) {
        frame.setSize(1207, 830);
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
     * <strong>SquareBoardPaint</strong> class - inner class that keeps track of every square that needs to be drawn on
     * the board. Left as inner class because it only concerns the GUI, so it is less important.
     *
     * @author Cassio dos Santos Sousa
     * @version 1.0
     */
    protected class SquareBoardPaint extends JPanel {

        private final ArrayList<SquarePaint> squares = new ArrayList<SquarePaint>();

        /**
         * Adds a square to an array list of items to be painted.
         *
         * @param square a Square object to be checked.
         * @param xPos   the X-coordinate of the square on the chessboard.
         * @param yPos   the Y-coordinate of the square on the chessboard.
         */
        protected void addSquareAt(Square square, int xPos, int yPos) {
            squares.add(new SquarePaint(square, xPos, yPos));
        }

        /**
         * Painting method that access all items of the array list.
         *
         * @param g Graphics object used for painting.
         */
        protected void paintComponent(Graphics g) {
            for (final SquarePaint square : squares) {
                Graphics2D g2 = (Graphics2D) g;
                square.paint(g2);
            }
        }
    }

    /**
     * <strong>SquarePaint</strong> class - inner class that handles how each square is going to be drawn. Left as inner
     * class because it only concerns the GUI, so it is less important.
     *
     * @author Cassio dos Santos Sousa
     * @version 1.0
     */
    protected class SquarePaint {
        private int xPos, yPos;
        private Square referenceSquare;

        protected SquarePaint(Square square, int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.referenceSquare = square;
        }

        /**
         * Paint method for squares. If the square has a piece, the method paints the piece as well.
         *
         * @param g Graphics2D object accessed by the GUI's JPanel.
         */
        protected void paint(Graphics2D g) {
            g.drawRect(xPos, yPos, 100, 100);
            g.setColor(referenceSquare.getSquareColor());
            g.fillRect(xPos + 1, yPos + 1, 99, 99);
            g.setColor(Color.BLACK);
            paintExistentPiece(g);
        }

        /**
         * Paints the image of a piece if the referenced Square object has one.
         *
         * @param g Graphics2D object that paints all the items on the GUI's JPanel.
         */
        private void paintExistentPiece(Graphics2D g) {
            if (referenceSquare.getSquarePiece() != null) {
                try {
                    BufferedImage img = ImageIO.read(new File(referenceSquare.getSquarePiece().getPathToImage()));
                    g.drawImage(img, xPos, yPos, null);
                } catch (IOException e) {
                    System.out.println("You tried to draw a non-existent image for a piece.");
                }
            }
        }
    }
}