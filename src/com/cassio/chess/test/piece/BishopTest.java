package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.Bishop;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class BishopTest {

    private static ChessBoard testBoard;
    private static Bishop blackBishop;
    private static Bishop whiteBishop;
    private static Bishop secondWhiteBishop;

    @BeforeClass
    public static void setupBoard() {
        testBoard = new ChessBoard();
        blackBishop = new Bishop(Color.BLACK);
        whiteBishop = new Bishop(Color.WHITE);
        secondWhiteBishop = new Bishop(Color.WHITE);
    }

    @Test(expected = SamePlaceMoveException.class)
    public void testSamePlacesMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        whiteBishop.moveTo(0, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testHorizontalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        whiteBishop.moveTo(5, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testVerticalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        whiteBishop.moveTo(0, 5);
    }

    @Test
    public void testDiagonalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        whiteBishop.moveTo(5, 5);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(5, 5) == whiteBishop;
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testKnightMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        whiteBishop.moveTo(2, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        whiteBishop.moveTo(8, 8);
    }

    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        testBoard.putPieceAt(secondWhiteBishop, 7, 7);
        whiteBishop.moveTo(7, 7);
    }

    @Test
    public void testOpponentCapture() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        testBoard.putPieceAt(blackBishop, 7, 7);
        whiteBishop.moveTo(7, 7);
        assert testBoard.getPieceAt(7, 7) == whiteBishop;
    }

    // A Bishop cannot move if there is a piece in its way

    @Test(expected = IllegalChessMoveException.class)
    public void testDiagonalMoveWithPieceInTheWay() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteBishop, 0, 0);
        testBoard.putPieceAt(blackBishop, 4, 4);
        whiteBishop.moveTo(7, 7);
    }
}