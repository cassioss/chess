package com.cassio.chess.test.piece;

import com.cassio.chess.exception.IllegalChessMoveException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.exception.SamePlaceMoveException;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.Rook;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class RookTest {

    private static ChessBoard testBoard;
    private static Rook blackRook;
    private static Rook whiteRook;
    private static Rook secondWhiteRook;

    @BeforeClass
    public static void setupBoard() {
        testBoard = new ChessBoard();
        blackRook = new Rook(Color.BLACK);
        whiteRook = new Rook(Color.WHITE);
        secondWhiteRook = new Rook(Color.WHITE);
        assert testBoard.hasNoPieces();
    }

    @Test(expected = SamePlaceMoveException.class)
    public void testSamePlacesMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(0, 0);
    }

    @Test
    public void testHorizontalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(5, 0);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(5, 0) == whiteRook;
    }

    @Test
    public void testVerticalMovement() {
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(0, 5);
        assert testBoard.getPieceAt(0, 0) == null;
        assert testBoard.getPieceAt(0, 5) == whiteRook;
    }
    
    @Test(expected = IllegalChessMoveException.class)
    public void testDiagonalMovement(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(5,5);
    }

    @Test(expected = IllegalChessMoveException.class)
    public void testKnightMovement(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(2,1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMovementOutOfBoard(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        whiteRook.moveTo(0, 8);
    }
    
    @Test(expected = SamePieceColorException.class)
    public void testSameColorCapture(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(secondWhiteRook, 0, 7);
        whiteRook.moveTo(0,7);
    }

    @Test
    public void testOpponentCapture(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(blackRook, 0, 7);
        whiteRook.moveTo(0,7);
        assert testBoard.getPieceAt(0,7) == whiteRook;
    }
    
    // A Rook cannot move if there is a piece in its way

    @Test(expected = IllegalChessMoveException.class)
    public void testHorizontalMoveWithPieceInTheWay(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(blackRook, 4, 0);
        whiteRook.moveTo(7,0);
    }
    
    @Test(expected = IllegalChessMoveException.class)
    public void testVerticalMoveWithPieceInTheWay(){
        testBoard.clearBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(blackRook, 0, 4);
        whiteRook.moveTo(0,7);
    }
}