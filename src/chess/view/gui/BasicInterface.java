package chess.view.gui;

import chess.model.board.Board;

import javax.swing.*;
import java.awt.*;

public abstract class BasicInterface {
    protected JPanel chessPanel;
    protected JPanel scoreBoard;
    private JButton restart;
    private JButton forfeit;
    private JButton undo;
    protected Board chessModel;
    protected GridLayout chessLayout;
    protected JButton[][] buttons;

    public BasicInterface(Board chessModel) {
        restart = new JButton("Restart game");
        forfeit = new JButton("Forfeit game");
        undo = new JButton("Undo last move");
        scoreBoard = new JPanel(new GridLayout(1, 0, 10, 10));
        JPanel buttonBoard = new JPanel(new GridLayout(3, 0, 10, 10));
        buttonBoard.add(restart);
        buttonBoard.add(forfeit);
        buttonBoard.add(undo);
        this.chessModel = chessModel;
        chessPanel = new JPanel();
        setChessLayout();
        chessPanel.setLayout(chessLayout);
        setButtons();
        scoreBoard.add(buttonBoard);
        scoreBoard.add(chessPanel);
    }

    protected abstract void setChessLayout();

    protected abstract void setButtons();

    public JPanel getChessPanel() {
        return scoreBoard;
    }

}