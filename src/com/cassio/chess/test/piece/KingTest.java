package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.King;
import com.cassio.chess.library.piece.Queen;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class KingTest {

    private static ChessBoard testBoard;
    private static King blackKing;
    private static King whiteKing;
    private static Queen whiteQueen;
    private static Queen blackQueen;

    @BeforeClass
    public static void setupPieces() {
        testBoard = new ChessBoard();
        whiteKing = new King(Color.WHITE);
        blackKing = new King(Color.BLACK);
        whiteQueen = new Queen(Color.WHITE);
        blackQueen = new Queen(Color.BLACK);
    }


    @Test(expected = SamePlaceMoveException.class)
    public void testSamePlacesMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(0, 0);
    }

    @Test
    public void testHorizontalMove() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(1, 0);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(1, 0) == whiteKing;
    }

    @Test
    public void testVerticalMove() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(0, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(0, 1) == whiteKing;
    }
    
    @Test
    public void testDiagonalMove() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(1, 1);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(1, 1) == whiteKing;
    }
    
    @Test(expected = IllegalChessMoveException.class)
    public void testRookHorizontalMove() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(5, 0);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testRookVerticalMove() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(0, 5);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testBishopMove() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(5, 5);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testKnightMove() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteKing, 0, 0);
        whiteKing.moveTo(2, 1);
    }

}