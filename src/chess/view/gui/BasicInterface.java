package chess.view.gui;

import chess.model.board.Board;

import javax.swing.*;
import java.awt.*;

public abstract class BasicInterface {
    protected JPanel chessPanel;
    protected Board chessModel;
    private GridLayout chessLayout;
    protected JButton[][] buttons;

    public BasicInterface(Board chessModel) {
        chessLayout = new GridLayout(8, 8);
        this.chessModel = chessModel;
        chessPanel = new JPanel();
        chessPanel.setLayout(chessLayout);
        setButtons();
    }

    protected abstract void setButtons();

    public JPanel getChessPanel() {
        return chessPanel;
    }

}