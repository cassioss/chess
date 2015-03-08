package chess.view.gui;

import chess.model.board.Board;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * <strong>ChessInterface</strong> class - class that handles how a classic chessboard (including squares and pieces) is
 * going to be drawn.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class ChessInterface extends BasicInterface {

    /**
     * Creates a complete GUI for the traditional chessboard game.
     *
     * @param chessModel a chessboard taken as reference for square creation and piece positioning.
     */
    public ChessInterface(Board chessModel) {
        super(chessModel);
    }

    /**
     * Creates a JPanel with a GridLayout set specifically for the chess interface.
     */
    protected void setChessLayout() {
        chessLayout = new GridLayout(8, 0);
    }

    /**
     * Creates a JButton for each square on the board.
     */
    protected void setChessBoardAsButtons() {
        buttons = new JButton[8][8];
        for (int posX = 0; posX < 8; posX++) {
            for (int posY = 0; posY < 8; posY++) {
                buttons[posX][posY] = newSquareButton(posX, posY);
                chessPanel.add(buttons[posX][posY]);
            }
        }
    }

    /**
     * Creates a new JButton directly related to a square on the chessboard.
     *
     * @param posX X-coordinate of a square on the chessboard.
     * @param posY Y-coordinate of a square on the chessboard.
     * @return a JButton with all the needed properties of the square.
     */
    private JButton newSquareButton(int posX, int posY) {
        JButton newButton = new JButton();
        newButton.setMinimumSize(new Dimension(110, 110));
        newButton.setPreferredSize(new Dimension(110, 110));
        newButton.setBorder(new LineBorder(Color.BLACK));
        newButton.setBackground(chessModel.getSquareAt(posX, posY).getSquareColor());
        addPieceAt(newButton, posX, posY);
        return newButton;
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