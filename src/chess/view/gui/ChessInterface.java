package chess.view.gui;

import chess.model.board.Board;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * <strong>ChessInterface</strong> class - class that handles how the chessboard (including squares and pieces) is going
 * to be drawn.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class ChessInterface extends BasicInterface {

    public ChessInterface(Board chessModel) {
        super(chessModel);
    }

    protected void setButtons() {
        buttons = new JButton[8][8];
        for (int posX = 0; posX < 8; posX++) {
            for (int posY = 0; posY < 8; posY++) {
                JButton new_button = new JButton();
                new_button.setMinimumSize(new Dimension(110, 110));
                new_button.setPreferredSize(new Dimension(110, 110));
                new_button.setBorder(new LineBorder(Color.BLACK));
                new_button.setBackground(chessModel.getSquareAt(posX, posY).getSquareColor());
                addPieceAt(new_button, posX, posY);
                //new_button.setContentAreaFilled(false);
                buttons[posX][posY] = new_button;
                chessPanel.add(buttons[posX][posY]);
            }
        }
    }

    /**
     * Adds a piece to a square on the GUI board, if existent.
     *
     * @param button a button that may receive the piece image.
     * @param posX   X-coordinate of the square on the board where a piece may be.
     * @param posY   Y-coordinate of the square on the board where a piece may be.
     */
    private void addPieceAt(JButton button, int posX, int posY) {
        if (chessModel.hasPieceAt(posX, posY)) {
            try {
                Image img = ImageIO.read(new File(chessModel.getSquareAt(posX, posY).getSquarePiece().getPathToImage()));
                button.setIcon(new ImageIcon(img));
            } catch (IOException e) {
                System.out.println("You tried to draw a non-existent image for a piece.");
            }
        }
    }

}