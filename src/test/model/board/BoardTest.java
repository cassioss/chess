package test.model.board;

import exception.AlreadyHasPieceException;
import exception.InGameException;
import exception.PieceInPlaceException;
import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.piece.Pawn;
import org.junit.Before;
import org.junit.Test;

/**
 * <strong>BoardTest</strong> class - tests the non-abstract methods of the Board class.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class BoardTest {

    private Board testBoard;

    /**
     * Sets a chessboard for testing purposes - only the non-abstract methods and exceptions are being tested.
     */
    @Before
    public void setUp() {
        testBoard = new ChessBoard();
    }

    /**
     * Tests the exception for setting a piece on the same place as another piece.
     *
     * @throws exception.PieceInPlaceException for trying to set a piece on the same place as
     *                                                                another piece.
     */
    @Test(expected = PieceInPlaceException.class)
    public void testPuttingPieceException() {
        testBoard.putPieceAt(new Pawn(false), 0, 0);
        testBoard.putPieceAt(new Pawn(true), 0, 0);
    }

    /**
     * Tests the exception for trying to set a piece in a square when a view is already being played. First case: the
     * square has no pieces (does not trigger an AlreadyHasPieceException).
     *
     * @throws exception.InGameException for trying to add a new piece when a view has already
     *                                                          begun.
     */
    @Test(expected = InGameException.class)
    public void testInGameExceptionFirstCase() {
        testBoard.setupPieces();                    // Sets the view flag
        testBoard.putPieceAt(new Pawn(true), 2, 2); // A square with no pieces
    }

    /**
     * Tests the exception for trying to set a piece in a square when a view is already being played. Second case: the
     * square already has a piece (should trigger an AlreadyHasPieceException).
     *
     * @throws exception.InGameException for trying to add a new piece when a view has already
     *                                                          begun.
     */
    @Test(expected = InGameException.class)
    public void testInGameExceptionSecondCase() {
        testBoard.setupPieces();                    // Sets the view flag
        testBoard.putPieceAt(new Pawn(true), 0, 0); // A square that already has a piece
    }

    /**
     * Tests the exception for trying to set the same piece twice in the board.
     *
     * @throws exception.AlreadyHasPieceException for trying to add the same piece on the board
     *                                                                   twice.
     */
    @Test(expected = AlreadyHasPieceException.class)
    public void testIfAlreadyHasPiece() {
        Pawn testPawn = new Pawn(true);
        testBoard.putPieceAt(testPawn, 0, 0);
        testBoard.putPieceAt(testPawn, 0, 1);
    }


}