package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.library.board.Chessboard;
import com.cassio.chess.library.piece.Rook;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class RookTest {

    private static Chessboard testBoard;
    private static Rook blackRook;
    private static Rook whiteRook;
    private static Rook secondWhiteRook;

    @BeforeClass
    public static void setupBoard() {
        testBoard = new Chessboard();
        blackRook = new Rook(Color.BLACK);
        whiteRook = new Rook(Color.WHITE);
        secondWhiteRook = new Rook(Color.WHITE);
    }

    @Test
    public void testHorizontalMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(0, 5);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(0, 5) == whiteRook;
    }

    @Test
    public void testVerticalMovement() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(5, 0);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(5, 0) == whiteRook;
    }
    
    @Test(expected = IllegalChessMoveException.class)
    public void testDiagonalMovement(){
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(5,5);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testKnightMovement(){
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(2,1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard(){
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(0, 8);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testPawnCapture(){
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(blackRook, 1, 1);
        whiteRook.moveTo(1,1);
    }
    
    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture(){
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(secondWhiteRook, 0, 7);
        whiteRook.moveTo(0,7);
    }

    @Test
    public void testOpponentCapture(){
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(blackRook, 0, 7);
        whiteRook.moveTo(0,7);
        assert testBoard.getPieceAt(0,7) == whiteRook;
    }
}