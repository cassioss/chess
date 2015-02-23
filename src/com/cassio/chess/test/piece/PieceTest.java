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
        Piece testQueenOne = new Queen(true);
        testBoard.putPieceAt(testQueenOne, 0, 0);
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 1));
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 2));
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 3)); // Vertical moves allowed
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 4)); // in the case of a queen
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 5));
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 6));
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 7));
        Piece testQueenTwo = new Queen(true);
        testBoard.putPieceAt(testQueenTwo, 0, 3);
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 1));
        assert testQueenOne.canMoveTo(testBoard.getSquareAt(0, 2));
        assert !testQueenOne.canMoveTo(testBoard.getSquareAt(0, 3)); // With a new piece in the way,
        assert !testQueenOne.canMoveTo(testBoard.getSquareAt(0, 4)); // the moves above become invalid
        assert !testQueenOne.canMoveTo(testBoard.getSquareAt(0, 5));
        assert !testQueenOne.canMoveTo(testBoard.getSquareAt(0, 6));
        assert !testQueenOne.canMoveTo(testBoard.getSquareAt(0, 7));
    }

    /**
     * Tests the change of pieces after a move has been declared.
     */
    @Test
    public void testChangeOfPiecesAfterMove() {
        Piece testQueen = new Queen(true);
        testBoard.putPieceAt(testQueen, 0, 0);
        assert testQueen.canMoveTo(testBoard.getSquareAt(0, 3));
        testQueen.moveTo(0, 3);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(0, 3) == testQueen;
    }

    /**
     * Tests the change of move set after a move has been declared.
     */
    @Test
    public void testChangeOfMoveSetAfterMove() {
        Piece testQueen = new Queen(true);
        testBoard.putPieceAt(testQueen, 0, 0);
        assert testQueen.canMoveTo(testBoard.getSquareAt(0, 2));    // A possible move
        assert testQueen.canMoveTo(testBoard.getSquareAt(3, 0));    // An intended move
        testQueen.moveTo(3, 0);                                     // The actual move
        assert testQueen.canMoveTo(testBoard.getSquareAt(3, 5));    // A previously impossible move made possible
        assert !testQueen.canMoveTo(testBoard.getSquareAt(0, 2));   // A previously possible move now impossible
    }
}