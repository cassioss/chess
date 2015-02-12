package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Chessboard;
import com.cassio.chess.library.piece.Pawn;
import com.cassio.chess.library.piece.Piece;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class PawnTest {

    private static Board testBoard;
    private static Piece blackPawn;
    private static Piece whitePawn;
    private static Piece secondWhitePawn;

    @BeforeClass
    public static void setupPieces() {
        testBoard = new Chessboard();
        whitePawn = new Pawn(Color.WHITE);
        blackPawn = new Pawn(Color.BLACK);
        secondWhitePawn = new Pawn(Color.WHITE);
    }


    /**
     * Test movement to the same place
     */

    @Test(expected = SamePlaceMoveException.class)
    public void testSamePlacesMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 0);
    }

    /**
     * Initial tests: white pawns only move upwards, while black pawns only move downwards.
     */

    @Test
    public void testWhitePawnUpwardsMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(0, 1) == whitePawn;
    }

    @Test
    public void testBlackPawnDownwardsMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(blackPawn, 0, 1);
        blackPawn.moveTo(0, 0);
        assert testBoard.getPieceAt(0, 1) == null;
        assert testBoard.getPieceAt(0, 0) == blackPawn;
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testWhitePawnDownwardsMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 1);
        whitePawn.moveTo(0, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testBlackPawnUpwardsMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(blackPawn, 0, 6);
        blackPawn.moveTo(0, 7);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testHorizontalMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(1, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testDiagonalMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(1, 1);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testRookHorizontalMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 5);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testRookVerticalMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(5, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testKnightMovement() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 7);
        whitePawn.moveTo(0, 8);
    }

    @Test
    public void testWhitePawnCapture() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(blackPawn, 1, 1);
        whitePawn.moveTo(1, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(1, 1) == whitePawn;
    }


    @Test
    public void testBlackPawnCapture() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(blackPawn, 1, 1);
        blackPawn.moveTo(0, 0);
        assert testBoard.getPieceAt(1, 1) == null;
        assert testBoard.getPieceAt(0, 0) == blackPawn;
    }

    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(secondWhitePawn, 1, 1);
        whitePawn.moveTo(1, 1);
    }

}