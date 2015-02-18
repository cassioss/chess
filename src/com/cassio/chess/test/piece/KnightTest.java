package com.cassio.chess.test.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.Knight;
import org.junit.Before;
import org.junit.Test;

/**
 * {@code KnightTest} class - tests the methods and verifies the expected behavior of a knight in a chessboard, given
 * its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class KnightTest {

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
     * Tests the L-shape moves of a knight.
     */
    @Test
    public void testKnightMovement() {
        Knight testKnight = new Knight(true);
        testBoard.putPieceAt(testKnight, 3, 3);
        assert !testKnight.canMoveTo(testBoard.getSquareAt(3, 3));
        for (int range = 1; range < 3; range++) {
            assert testKnight.canMoveTo(testBoard.getSquareAt(range, 3 - range));
            assert testKnight.canMoveTo(testBoard.getSquareAt(range, 3 - range));
            assert testKnight.canMoveTo(testBoard.getSquareAt(-range, range - 3));
            assert testKnight.canMoveTo(testBoard.getSquareAt(-range, range - 3));
        }
    }

    /**
     * Tests the L-shape move of a knight with a piece on its "way".
     */
    @Test
    public void testKnightMovementAboveOtherPieces() {
        Knight testBlackKnight = new Knight(true);
        Knight testWhiteKnightOne = new Knight(false);
        Knight testWhiteKnightTwo = new Knight(false);
        Knight testWhiteKnightThree = new Knight(false);
        testBoard.putPieceAt(testWhiteKnightOne, 3, 4);
        testBoard.putPieceAt(testWhiteKnightTwo, 4, 4);
        testBoard.putPieceAt(testWhiteKnightThree, 3, 5);
        testBoard.putPieceAt(testBlackKnight, 3, 3);
        assert testBlackKnight.canMoveTo(testBoard.getSquareAt(4, 5));
    }

}