package chess.view.gui;

import chess.model.board.Board;
import chess.model.board.Square;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * <strong>ChessInterface</strong> class - class that handles how the chessboard (including squares and pieces) is going
 * to be drawn.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class ChessInterface extends BasicInterface {

    /**
     * Creates a chessboard GUI using a board as a model.
     *
     * @param modelBoard a chessboard used as a model for the displacement
     */
    public ChessInterface(Board modelBoard) {
        super(modelBoard);
    }

    /**
     * Creates a grid of buttons corresponding to each one of the squares.
     */
    protected void setSquareButtons() {
        squareButtonGrid = new JButton[8][8];
        for (int xPos = 0; xPos < 8; xPos++) {
            for (int yPos = 0; yPos < 8; yPos++) {
                squareButtonGrid[xPos][yPos] = createSquareButton(modelBoard.getSquareAt(xPos, yPos));
            }
        }
    }

    /**
     * Creates a JButton with all the properties of a square (including piece over it).
     */
    protected JButton createSquareButton(Square referenceSquare) {
        JButton squareButton = new JButton();
        squareButton.setPreferredSize(new Dimension(100, 100));

        // Border and background painting
        squareButton.setBorder(new LineBorder(Color.BLACK));
        squareButton.setBackground(referenceSquare.getSquareColor());

        // Setups required to make the square visually pleasant
        squareButton.setContentAreaFilled(false);
        squareButton.setOpaque(true);
        squareButton.setFocusPainted(false);

        return squareButton;
    }
}