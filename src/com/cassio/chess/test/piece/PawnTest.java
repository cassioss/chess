package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.PieceColorMoveException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.Chessboard;
import com.cassio.chess.library.piece.Pawn;
import com.cassio.chess.library.piece.Piece;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class PawnTest {

    private static Chessboard testBoard;
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


    @Test(expected = SamePlaceMoveException.class)
    public void testSamePlacesMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 0);
    }

    // Black Pawns can move up only by one Square

    @Test
    public void testWhitePawnUpwardsMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(0, 1) == whitePawn;
    }

    @Test(expected = PieceColorMoveException.class)
    public void testWhitePawnDownwardsMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 1);
        whitePawn.moveTo(0, 0);
    }
    
    // Black Pawns can move down only by one Square

    @Test
    public void testBlackPawnDownwardsMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(blackPawn, 0, 1);
        blackPawn.moveTo(0, 0);
        assert testBoard.getPieceAt(0, 1) == null;
        assert testBoard.getPieceAt(0, 0) == blackPawn;
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testBlackPawnUpwardsMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(blackPawn, 0, 6);
        blackPawn.moveTo(0, 7);
    }

    // Blocks horizontal moves
    
    @Test(expected = IllegalChessMoveException.class)
    public void testHorizontalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(1, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testDiagonalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(1, 1);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testRookHorizontalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(0, 5);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testRookVerticalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(5, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testKnightMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        whitePawn.moveTo(2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 7);
        whitePawn.moveTo(0, 8);
    }

    @Test
    public void testWhitePawnCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(blackPawn, 1, 1);
        whitePawn.moveTo(1, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(1, 1) == whitePawn;
    }


    @Test
    public void testBlackPawnCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(blackPawn, 1, 1);
        blackPawn.moveTo(0, 0);
        assert testBoard.getPieceAt(1, 1) == null;
        assert testBoard.getPieceAt(0, 0) == blackPawn;
    }

    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whitePawn, 0, 0);
        testBoard.putPieceAt(secondWhitePawn, 1, 1);
        whitePawn.moveTo(1, 1);
    }

}