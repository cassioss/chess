package com.cassio.chess.test.board;

import com.cassio.chess.exception.board.InGameException;
import com.cassio.chess.exception.board.AlreadyHasPieceException;
import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.Pawn;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board testBoard;

    /**
     * Sets a chessboard for testing purposes - only the non-abstract methods are being tested.
     */
    @Before
    public void setUp() {
        testBoard = new ChessBoard();
    }

    /**
     * Tests the exception for setting a piece on the same place as another piece.
     *
     * @throws AlreadyHasPieceException for trying to set a piece on the same place as another piece.
     */
    @Test(expected = AlreadyHasPieceException.class)
    public void testPuttingPieceException() {
        testBoard.putPieceAt(new Pawn(false), 0, 0);
        testBoard.putPieceAt(new Pawn(true), 0, 0);
    }

    /**
     * Tests the exception for trying to set a piece in a square when a game is already being played. First case: the
     * square has no pieces (does not trigger an AlreadyHasPieceException).
     *
     * @throws InGameException for trying to add a new piece when a game has already begun.
     */
    @Test(expected = InGameException.class)
    public void testInGameExceptionFirstCase() {
        testBoard.setupPieces();                    // Sets the game flag
        testBoard.putPieceAt(new Pawn(true), 2, 2); // A square with no pieces
    }

    /**
     * Tests the exception for trying to set a piece in a square when a game is already being played. Second case: the
     * square already has a piece (should trigger an AlreadyHasPieceException).
     *
     * @throws InGameException for trying to add a new piece when a game has already begun.
     */
    @Test(expected = InGameException.class)
    public void testInGameExceptionSecondCase() {
        testBoard.setupPieces();                    // Sets the game flag
        testBoard.putPieceAt(new Pawn(true), 0, 0); // A square that already has a piece
    }


}