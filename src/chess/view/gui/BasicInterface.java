package chess.view.gui;

import chess.model.board.Board;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BasicInterface {
    private JPanel chessPanel;
    private JButton[][] buttons;
    private final int COLUMN_OR_ROW = 8;
    private Board chessModel;

    public BasicInterface(Board chessModel) {

        GridLayout experimentLayout = new GridLayout(COLUMN_OR_ROW, COLUMN_OR_ROW);
        this.chessModel = chessModel;

        chessPanel = new JPanel();
        chessPanel.setLayout(experimentLayout);

        buttons = new JButton[COLUMN_OR_ROW][COLUMN_OR_ROW];
        addButtons(chessPanel);
    }

    private void addButtons(JPanel panel) {
        for (int posX = 0; posX < COLUMN_OR_ROW; posX++) {
            for (int posY = 0; posY < COLUMN_OR_ROW; posY++) {
                JButton new_button = new JButton();
                new_button.setMinimumSize(new Dimension(110, 110));
                new_button.setPreferredSize(new Dimension(110, 110));
                new_button.setBorder(new LineBorder(Color.BLACK));
                new_button.setBackground(chessModel.getSquareAt(posX, posY).getSquareColor());
                addPieceAt(new_button, posX, posY);
                //new_button.setContentAreaFilled(false);
                buttons[posX][posY] = new_button;
                panel.add(buttons[posX][posY]);
            }
        }
    }

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

    public JPanel getChessPanel() {
        return chessPanel;
    }

}