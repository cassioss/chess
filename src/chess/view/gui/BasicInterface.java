package chess.view.gui;

import chess.model.board.Board;

import javax.swing.*;
import java.awt.*;

public abstract class BasicInterface {
    protected JPanel chessPanel;
    private JButton restart;
    private JButton forfeit;
    private JButton undo;
    protected Board chessModel;
    protected GridLayout chessLayout;
    protected JButton[][] buttons;
    protected JSplitPane split;

    public BasicInterface(Board chessModel) {
        restart = new JButton("Restart game");
        forfeit = new JButton("Forfeit game");
        undo = new JButton("Undo last move");
        JPanel scoreBoard = new JPanel(new GridLayout(3,0));
        scoreBoard.add(undo);
        scoreBoard.add(restart);
        scoreBoard.add(forfeit);
        this.chessModel = chessModel;
        chessPanel = new JPanel();
        setChessLayout();
        chessPanel.setLayout(chessLayout);
        setButtons();
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        split.setLeftComponent(chessPanel);
        split.setRightComponent(scoreBoard);
        split.setDividerLocation(0.8);
        split.setEnabled(false);
    }

    protected abstract void setChessLayout();

    protected abstract void setButtons();

    public JSplitPane getChessPanel() {
        return split;
    }

}