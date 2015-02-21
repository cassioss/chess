package com.cassio.chess.test.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.Pawn;
import org.junit.Before;
import org.junit.Test;

/**
 * <strong>PawnTest</strong> class - tests the methods and verifies the expected behavior of a pawn in a chessboard,
 * given its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class PawnTest {

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
     * Tests the one-square move possibility of a white pawn.
     */
    @Test
    public void testWhitePawnMovement() {
        Pawn testWhitePawn = new Pawn(false);
        testBoard.putPieceAt(testWhitePawn, 2, 2);
        assert testWhitePawn.canMoveTo(testBoard.getSquareAt(2, 3));
        assert !testWhitePawn.canMoveTo(testBoard.getSquareAt(2, 2));
        assert !testWhitePawn.canMoveTo(testBoard.getSquareAt(3, 3));
        assert !testWhitePawn.canMoveTo(testBoard.getSquareAt(1, 3));
    }

    /**
     * Tests the one-square move possibility of a black pawn.
     */
    @Test
    public void testBlackPawnMovement() {
        Pawn testBlackPawn = new Pawn(true);
        testBoard.putPieceAt(testBlackPawn, 2, 2);
        assert testBlackPawn.canMoveTo(testBoard.getSquareAt(2, 1));
        assert !testBlackPawn.canMoveTo(testBoard.getSquareAt(2, 2));
        assert !testBlackPawn.canMoveTo(testBoard.getSquareAt(3, 1));
        assert !testBlackPawn.canMoveTo(testBoard.getSquareAt(1, 1));
    }

    /**
     * Tests the one-square diagonal capture possibility of a white pawn.
     */
    @Test
    public void testWhitePawnCapture() {
        Pawn testBlackPawnOne = new Pawn(true);
        Pawn testBlackPawnTwo = new Pawn(true);
        Pawn testWhitePawn = new Pawn(false);
        testBoard.putPieceAt(testBlackPawnOne, 2, 2);
        testBoard.putPieceAt(testBlackPawnTwo, 4, 2);
        testBoard.putPieceAt(testWhitePawn, 3, 1);
        assert testWhitePawn.canMoveTo(testBoard.getSquareAt(2, 2));
        assert testWhitePawn.canMoveTo(testBoard.getSquareAt(4, 2));
        assert testWhitePawn.canMoveTo(testBoard.getSquareAt(3, 2));
    }

    /**
     * Tests the one-square diagonal capture possibility of a black pawn.
     */
    @Test
    public void testBlackPawnCapture() {
        Pawn testWhitePawnOne = new Pawn(false);
        Pawn testWhitePawnTwo = new Pawn(false);
        Pawn testBlackPawn = new Pawn(true);
        testBoard.putPieceAt(testWhitePawnOne, 2, 2);
        testBoard.putPieceAt(testWhitePawnTwo, 4, 2);
        testBoard.putPieceAt(testBlackPawn, 3, 3);
        assert testBlackPawn.canMoveTo(testBoard.getSquareAt(2, 2));
        assert testBlackPawn.canMoveTo(testBoard.getSquareAt(4, 2));
        assert testBlackPawn.canMoveTo(testBoard.getSquareAt(3, 2));
    }

    /**
     * Tests if a white pawn is unable to move if a piece is in front if it, regardless of the color. First case:
     * another white piece is blocking its way.
     */
    @Test
    public void testWhitePawnBlockedByWhite() {
        Pawn testWhitePawnOne = new Pawn(false);
        Pawn testWhitePawnTwo = new Pawn(false);
        testBoard.putPieceAt(testWhitePawnOne, 2, 3);
        testBoard.putPieceAt(testWhitePawnTwo, 2, 2);
        assert !testWhitePawnTwo.canMoveTo(testBoard.getSquareAt(2, 3));
    }

    /**
     * Tests if a white pawn is unable to move if a piece is in front if it, regardless of the color. Second case: a
     * black piece is blocking its way.
     */
    @Test
    public void testWhitePawnBlockedByBlack() {
        Pawn testWhitePawn = new Pawn(false);
        Pawn testBlackPawn = new Pawn(true);
        testBoard.putPieceAt(testBlackPawn, 2, 3);
        testBoard.putPieceAt(testWhitePawn, 2, 2);
        assert !testWhitePawn.canMoveTo(testBoard.getSquareAt(2, 3));
    }


}