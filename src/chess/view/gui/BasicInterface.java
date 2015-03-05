package chess.view.gui;

import chess.model.board.Board;
import chess.model.board.Square;

import javax.swing.*;

/**
 * <strong>BasicInterface</strong> class - class that handles how a board (including squares and pieces) is going to be
 * drawn. As this is board-dependent, this class is abstract.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public abstract class BasicInterface {

    protected Board modelBoard;
    protected JButton[][] squareButtonGrid;

    /**
     * Creates a chessboard GUI using a board as a model.
     *
     * @param modelBoard a chessboard used as a model for the displacement
     */
    public BasicInterface(Board modelBoard){
        this.modelBoard = modelBoard;
    }

    /**
     * Creates a grid of buttons corresponding to each one of the squares.
     */
    protected abstract void setSquareButtons();

    /**
     * Creates a JButton with all the properties of a square (including piece over it).
     */
    protected abstract JButton createSquareButton(Square referenceSquaRE);
}
