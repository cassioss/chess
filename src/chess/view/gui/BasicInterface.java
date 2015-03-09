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
    protected JPanel scoreBoard;
    protected JLabel currentTurn;
    protected JLabel authorName;

    /// Variables responsible for each player's score
    //  White player

    protected JLabel whitePlayerScore;
    protected String whitePlayerName;
    protected int whiteScore;

    //  Black player

    protected JLabel blackPlayerScore;
    protected String blackPlayerName;
    protected int blackScore;

    /**
     * Creates a basic interface for a chessboard.
     *
     * @param chessModel a chessboard used as reference for square creation and piece positioning.
     */
    public BasicInterface(Board chessModel) {
        initialNamingSetup();
        createLateralButtons();
        createLabels();
        setScoreBoard();
        setChessPanel(chessModel);
        setChessBoardAsButtons();
        setSplitPanel();
    }

    private void initialNamingSetup() {
        whitePlayerName = "Player1";
        blackPlayerName = "Player2";
        whiteScore = blackScore = 0;
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
        currentTurn = blackBoardLabel(Color.ORANGE, "White player's turn");
        gameMessages = blackBoardLabel(Color.YELLOW, "Welcome to Chess!");
        whitePlayerScore = blackBoardLabel(Color.CYAN, getScoreForPlayer(false));
        blackPlayerScore = blackBoardLabel(Color.CYAN, getScoreForPlayer(true));
        authorName = blackBoardLabel(Color.GREEN, "Created by Cassio Sousa (dssntss2@illinois.edu)");
    }

    /**
     * Sets a JLabel with black borders, centered message and white background.
     *
     * @param message a string that contains the JLabel's message.
     * @return a JLabel with white background and black borders.
     */
    private JLabel blackBoardLabel(Color color, String message) {
        JLabel simpleLabel = new JLabel(centerWrapMessage(message));
        simpleLabel.setBorder(new LineBorder(Color.BLACK));
        simpleLabel.setBackground(color);
        simpleLabel.setOpaque(true);
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
        scoreBoard.add(currentTurn);
        scoreBoard.add(gameMessages);
        scoreBoard.add(rename);
        scoreBoard.add(whitePlayerScore);
        scoreBoard.add(blackPlayerScore);
        scoreBoard.add(authorName);
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

    /**
     * Checks if the GUI chessboard has a piece at a certain location.
     *
     * @param posX X-coordinate of a square being verified.
     * @param posY Y-coordinate of a square being verified.
     * @return <em>true</em> if there is a piece on the specified location.
     */
    public boolean hasPieceAt(int posX, int posY) {
        return chessModel.hasPieceAt(posX, posY);
    }

    /**
     * Gets the square at a certain position on the board.
     *
     * @param posX the chosen X-coordinate of a square on the board.
     * @param posY the chosen Y-coordinate of a square on the board.
     * @return the Square object located at (X,Y).
     */
    public Square getSquareAt(int posX, int posY) {
        return chessModel.getSquareAt(posX, posY);
    }

    /**
     * Gets the piece at a certain position on the board.
     *
     * @param posX the chosen X-coordinate of a square on the board.
     * @param posY the chosen Y-coordinate of a square on the board.
     * @return a Piece object located at (X,Y).
     */
    public Piece getPieceAt(int posX, int posY) {
        return chessModel.getSquareAt(posX, posY).getSquarePiece();
    }

    /**
     * Returns the original painting of the chessboard (gray and white).
     */
    public void originalPainting() {
        chessModel.deselectPiece();
        resetColors();
    }

    /**
     * Paints the possible moves for a piece on the screen.
     *
     * @param piece a piece that was selected during the game.
     */
    public void paintMovesOf(Piece piece) {
        chessModel.showAvailableMovesOf(piece);
        resetColors();
    }

    /**
     * Repaints the colors and pieces on the chessboard. As iterating over them is board-dependent, this method is
     * abstract.
     */
    protected abstract void resetColors();

    /**
     * Sets a new message on the message board, in order to help players. By default, it will always have center
     * alignment and wrapped content.
     *
     * @param message a new message to be set.
     */
    public void setMessage(String message) {
        gameMessages.setText(centerWrapMessage(message));
    }

    /**
     * Change the current turn.
     *
     * @param newPlayerTurn the new player's turn (<em>true</em> if black).
     */
    public void changeTurn(boolean newPlayerTurn) {
        String playerName = newPlayerTurn ? "Black " : "White ";
        currentTurn.setText(playerName + "player's turn");
    }

    /**
     * Turns a string into a centered, wrapped message for a JLabel (using HTML properties).
     *
     * @param message the original string.
     * @return a string containing the necessary HTML brackets for text centering and wrapping.
     */
    private String centerWrapMessage(String message) {
        return "<html><div style=\"text-align: center;\">" + message + "</html>";
    }

    /**
     * Gets the Restart button. Accessed via Game.
     *
     * @return the restart JButton.
     */
    public JButton getRestart() {
        return restart;
    }

    /**
     * Gets the Forfeit button. Accessed via Game.
     *
     * @return the forfeit JButton.
     */
    public JButton getForfeit() {
        return forfeit;
    }

    /**
     * Gets the Undo button. Accessed via Game.
     *
     * @return the undo JButton.
     */
    public JButton getUndo() {
        return undo;
    }

    /**
     * Gets the Rename button. Accessed via Game.
     *
     * @return the rename JButton.
     */
    public JButton getRename() {
        return rename;
    }

    /**
     * Gets the score for a player. It is not used as a setter because the score is only accessed when incremented.
     *
     * @param playerIsBlack the current player turn (<em>true</em> if black).
     * @return a string with the correct formatting for each player's score.
     */
    private String getScoreForPlayer(boolean playerIsBlack) {
        if (playerIsBlack)
            return centerWrapMessage(blackPlayerName + " (Black) - " + blackScore + " point(s)");
        else
            return centerWrapMessage(whitePlayerName + " (Black) - " + whiteScore + " point(s)");
    }

    /**
     * Increments the score for a player.
     *
     * @param playerIsBlack color of the player that won a point (<em>true</em> if black).
     */
    public void incrementScoreForPlayer(boolean playerIsBlack) {
        if (playerIsBlack) {
            blackScore++;
            blackPlayerScore.setText(getScoreForPlayer(true));
        } else {
            whiteScore++;
            whitePlayerScore.setText(getScoreForPlayer(false));
        }
    }

}