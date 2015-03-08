package chess.view.gui;

import chess.model.board.Board;
import chess.model.board.Square;
import chess.model.piece.Piece;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * <strong>ChessInterface</strong> class - class that handles how a chessboard (including squares and pieces) is going
 * to be drawn. Set as abstract to be extensible for different kinds of boards.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
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
    protected JPanel scoreBoard;

    /**
     * Creates a basic interface for a chessboard.
     *
     * @param chessModel a chessboard used as reference for square creation and piece positioning.
     */
    public BasicInterface(Board chessModel) {
        createLateralButtons();
        createLabels();
        setScoreBoard();
        setChessPanel(chessModel);
        setChessBoardAsButtons();
        setSplitPanel();
    }

    /**
     * Creates the needed lateral buttons for a chess game.
     */
    private void createLateralButtons() {
        restart = new JButton("Restart game");
        forfeit = new JButton("Forfeit game");
        undo = new JButton("Undo last move");
        rename = new JButton("Change player names");
    }

    /**
     * Creates basic JLabels to show the main messages of the game and the score of each player.
     */
    private void createLabels() {
        gameMessages = blackBoardLabel("Welcome to Chess!");
        whitePlayerScore = blackBoardLabel("Player 1 (White) -  0 points");
        blackPlayerScore = blackBoardLabel("Player 2 (Black) -  0 points");
    }

    /**
     * Sets a JLabel with black borders, centered message and white background.
     *
     * @param message a string that contains the JLabel's message.
     * @return a JLabel with white background and black borders.
     */
    private JLabel blackBoardLabel(String message) {
        JLabel simpleLabel = new JLabel(message);
        simpleLabel.setBorder(new LineBorder(Color.BLACK));
        simpleLabel.setBackground(Color.WHITE);
        simpleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        return simpleLabel;
    }

    /**
     * Creates the score board, with all the JButtons and JPanels needed for the chess game.
     */
    private void setScoreBoard() {
        scoreBoard = new JPanel(new GridLayout(9, 0));
        scoreBoard.add(undo);
        scoreBoard.add(restart);
        scoreBoard.add(forfeit);
        scoreBoard.add(gameMessages);
        scoreBoard.add(whitePlayerScore);
        scoreBoard.add(blackPlayerScore);
        scoreBoard.add(rename);
    }

    /**
     * Creates the chess interface itself.
     *
     * @param chessModel a chessboard with all the pieces and images of reference.
     */
    private void setChessPanel(Board chessModel) {
        this.chessModel = chessModel;
        setChessLayout();
        chessPanel = new JPanel();
        chessPanel.setLayout(chessLayout);
    }

    /**
     * Creates a JSplitPanel that divides the screen in two: on the left, the chess interface. On the right, the score
     * and the required buttons for the game.
     */
    private void setSplitPanel() {
        split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        split.setLeftComponent(chessPanel);
        split.setRightComponent(scoreBoard);
        split.setDividerLocation(0.8);
        split.setEnabled(false);
    }

    /**
     * Creates a JPanel with a GridLayout set specifically for the chess interface. As this method is board-dependent,
     * it is also abstract.
     */
    protected abstract void setChessLayout();

    /**
     * Creates a JButton for each square on the chessboard. As this method is board-dependent, it is also abstract.
     */
    protected abstract void setChessBoardAsButtons();

    /**
     * Gets the JSplitPane containing all the information the JFrame (on the Controller) needs.
     *
     * @return a JSplitPane with all the information the Controller needs.
     */
    public JSplitPane getChessPanel() {
        return split;
    }

    /**
     * Gets the button at a certain position of the board.
     *
     * @param posX X-coordinate of a targeted JButton.
     * @param posY Y-coordinate of a targeted JButton.
     * @return a JButton at the desired position.
     */
    public JButton getButtonAt(int posX, int posY) {
        return buttons[posX][posY];
    }

    public boolean hasPieceAt(int posX, int posY) {
        return chessModel.hasPieceAt(posX, posY);
    }

    public Square getSquareAt(int posX, int posY) {
        return chessModel.getSquareAt(posX, posY);
    }

    public void originalPainting() {
        chessModel.deselectPiece();
        resetColors();
    }

    public void movesOf(Piece piece) {
        chessModel.showAvailableMovesOf(piece);
        resetColors();
    }

    protected abstract void resetColors();

}