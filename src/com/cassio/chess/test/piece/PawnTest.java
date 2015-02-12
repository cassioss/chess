package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMovementException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMovementException;
import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
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
    public static void setupBoard() {
        testBoard = new ChessBoard();
        whitePawn = new Pawn(Color.WHITE);
        blackPawn = new Pawn(Color.BLACK);
        secondWhitePawn = new Pawn(Color.WHITE);
    }

    /**
     * Test movement to the same place 
     */
    
    @Test(expected = SamePlaceMovementException.class)
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
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(1, 0);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(1, 0) == whitePawn;
    }

    @Test
    public void testBlackPawnDownwardsMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(blackPawn, 1, 0);
        whitePawn.moveTo(0, 0);
        assert testBoard.getPieceAt(1, 0) == null;
        assert testBoard.getPieceAt(0, 0) == blackPawn;
    }

    @Test(expected = IllegalChessMovementException.class)
    public void testWhitePawnDownwardsMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 1, 0);
        whitePawn.moveTo(0, 0);
    }

    @Test(expected = IllegalChessMovementException.class)
    public void testBlackPawnUpwardsMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(blackPawn, 7, 0);
        blackPawn.moveTo(0, 1);
    }

    @Test(expected = IllegalChessMovementException.class)
    public void testHorizontalMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 1);
    }

    @Test(expected = IllegalChessMovementException.class)
    public void testDiagonalMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(1, 1);
    }

    @Test(expected = IllegalChessMovementException.class)
    public void testRookHorizontalMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 5);
    }

    @Test(expected = IllegalChessMovementException.class)
    public void testRookVerticalMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(5, 0);
    }

    @Test(expected = IllegalChessMovementException.class)
    public void testKnightMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 7);
        whitePawn.moveTo(0, 8);
    }

    @Test
    public void testWhitePawnCapture() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(blackPawn, 1, 1);
        whitePawn.moveTo(1, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(1, 1) == whitePawn;
    }


    @Test
    public void testBlackPawnCapture() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(blackPawn, 1, 1);
        blackPawn.moveTo(0, 0);
        assert testBoard.getPieceAt(1, 1) == null;
        assert testBoard.getPieceAt(0, 0) == blackPawn;
    }

    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(secondWhitePawn, 1, 1);
        whitePawn.moveTo(1, 1);
    }

}