package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.Chessboard;
import com.cassio.chess.library.piece.Queen;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class QueenTest {

    private static Chessboard testBoard;
    private static Queen blackQueen;
    private static Queen whiteQueen;
    private static Queen secondWhiteQueen;

    @BeforeClass
    public static void setupBoard() {
        testBoard = new Chessboard();
        blackQueen = new Queen(Color.BLACK);
        whiteQueen = new Queen(Color.WHITE);
        secondWhiteQueen = new Queen(Color.WHITE);
    }

    @Test(expected = SamePlaceMoveException.class)
    public void testSamePlacesMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        whiteQueen.moveTo(0, 0);
    }

    @Test
    public void testHorizontalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        whiteQueen.moveTo(5, 0);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(5, 0) == whiteQueen;
    }

    @Test
    public void testVerticalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        whiteQueen.moveTo(0, 5);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(0, 5) == whiteQueen;
    }

    @Test
    public void testDiagonalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        whiteQueen.moveTo(5, 5);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(5, 5) == whiteQueen;
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testKnightMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        whiteQueen.moveTo(2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        whiteQueen.moveTo(8, 8);
    }

    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        testBoard.putPieceAt(secondWhiteQueen, 7, 7);
        whiteQueen.moveTo(7, 7);
    }

    @Test
    public void testOpponentCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        testBoard.putPieceAt(blackQueen, 7, 7);
        whiteQueen.moveTo(7, 7);
        assert testBoard.getPieceAt(7, 7) == whiteQueen;
    }

    // A Queen cannot move if there is a piece in its way

    @Test(expected = IllegalChessMoveException.class)
    public void testHorizontalMoveWithPieceInTheWay(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        testBoard.putPieceAt(blackQueen, 4, 0);
        whiteQueen.moveTo(7,0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testVerticalMoveWithPieceInTheWay(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        testBoard.putPieceAt(blackQueen, 0, 4);
        whiteQueen.moveTo(0,7);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testDiagonalMoveWithPieceInTheWay() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteQueen, 0, 0);
        testBoard.putPieceAt(blackQueen, 4, 4);
        whiteQueen.moveTo(7, 7);
    }
}