package com.cassio.chess.test.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.Piece;
import com.cassio.chess.library.piece.Queen;
import org.junit.Before;
import org.junit.Test;

/**
 * <strong>PieceTest</strong> class - tests the non-abstract methods of the Piece class.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class PieceTest {

    private Board testBoard;

    /**
     * Creates an empty, not-for-playing chessboard for testing purposes. It is non-static because a static instance of
     * the board would have pieces being placed without control.
     */
    @Before
    public void setUp() {
        testBoard = new ChessBoard();
    }

    /**
     * Tests if the piece's move sets are being updated anytime a new piece is put on a board.
     */
    @Test
    public void testUpdateMoveSet() {
        Piece testPieceOne = new Queen(true);
        testBoard.putPieceAt(testPieceOne, 0, 0);
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 1));
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 2));
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 3)); // Vertical moves allowed
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 4)); // in the case of a queen
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 5));
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 6));
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 7));
        Piece testPieceTwo = new Queen(true);
        testBoard.putPieceAt(testPieceTwo, 0, 3);
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 1));
        assert testPieceOne.canMoveTo(testBoard.getSquareAt(0, 2));
        assert !testPieceOne.canMoveTo(testBoard.getSquareAt(0, 3)); // With a new piece in the way,
        assert !testPieceOne.canMoveTo(testBoard.getSquareAt(0, 4)); // the moves above become invalid
        assert !testPieceOne.canMoveTo(testBoard.getSquareAt(0, 5));
        assert !testPieceOne.canMoveTo(testBoard.getSquareAt(0, 6));
        assert !testPieceOne.canMoveTo(testBoard.getSquareAt(0, 7));
    }
}