package chess.view.gui;

import chess.model.board.Board;

import javax.swing.*;
import java.awt.*;

public abstract class BasicInterface {
    protected JPanel chessPanel;
    private JButton restart;
    private JButton forfeit;
    private JButton undo;
    private JButton rename;
    protected Board chessModel;
    protected GridLayout chessLayout;
    protected JButton[][] buttons;
    protected JSplitPane split;
    protected JLabel gameMessages;
    protected JLabel whitePlayerScore;
    protected JLabel blackPlayerScore;

    public BasicInterface(Board chessModel) {
        restart = new JButton("Restart game");
        forfeit = new JButton("Forfeit game");
        undo = new JButton("Undo last move");
        rename = new JButton("Change player names");
        gameMessages = new JLabel("Welcome to Chess!");
        whitePlayerScore = new JLabel("White player: 0");
        blackPlayerScore = new JLabel("Black player: 0");
        gameMessages.setHorizontalAlignment(SwingConstants.CENTER);
        whitePlayerScore.setHorizontalAlignment(SwingConstants.CENTER);
        blackPlayerScore.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel scoreBoard = new JPanel(new GridLayout(9,0));
        scoreBoard.add(undo);
        scoreBoard.add(restart);
        scoreBoard.add(forfeit);
        scoreBoard.add(gameMessages);
        scoreBoard.add(whitePlayerScore);
        scoreBoard.add(blackPlayerScore);
        scoreBoard.add(rename);
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