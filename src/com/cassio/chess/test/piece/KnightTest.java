package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.Chessboard;
import com.cassio.chess.library.piece.Knight;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class KnightTest {

    private static Chessboard testBoard;
    private static Knight blackKnight;
    private static Knight whiteKnight;
    private static Knight secondWhiteKnight;

    @BeforeClass
    public static void setupBoard() {
        testBoard = new Chessboard();
        blackKnight = new Knight(Color.BLACK);
        whiteKnight = new Knight(Color.WHITE);
        secondWhiteKnight = new Knight(Color.WHITE);
    }

    @Test(expected = SamePlaceMoveException.class)
    public void testSamePlacesMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        whiteKnight.moveTo(0, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testHorizontalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        whiteKnight.moveTo(5, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testVerticalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        whiteKnight.moveTo(0, 5);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testDiagonalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        whiteKnight.moveTo(5, 5);
    }

    @Test
    public void testKnightMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        whiteKnight.moveTo(2, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(2, 1) == whiteKnight;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 6, 6);
        whiteKnight.moveTo(8, 7);
    }

    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        testBoard.putPieceAt(secondWhiteKnight, 2, 1);
        whiteKnight.moveTo(2, 1);
    }

    @Test
    public void testOpponentCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        testBoard.putPieceAt(blackKnight, 2, 1);
        whiteKnight.moveTo(2, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(2, 1) == whiteKnight;
    }

    // A Knight is the only piece that jumps directly to its destination, regardless of Pieces in the way

    @Test
    public void testKnightMoveWithPiecesInTheWay() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKnight, 0, 0);
        testBoard.putPieceAt(blackKnight, 1, 1);
        testBoard.putPieceAt(secondWhiteKnight, 2, 0);
        whiteKnight.moveTo(2, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(2, 1) == whiteKnight;
    }
}