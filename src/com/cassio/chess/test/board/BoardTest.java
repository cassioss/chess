package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.piece.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class BoardTest {

    private static Board testBoard;

    @BeforeClass
    public static void setBoard() {
        testBoard = new ChessBoard();
    }

    @Test
    public void testSquareColorAssignment() {
        Square tile = testBoard.getSquareAt(3, 4);
        assert tile.getSquareColor() == Color.white;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSquareOutOfBounds() {
        Square tile = testBoard.getSquareAt(8, 5);
    }
    
    @Test
    public void testCleanBoard(){
        testBoard.setupPieces();
        testBoard.cleanBoard();
        assert testBoard.hasNoPieces();
    }

    @Test
    public void testInitialPieceClassAssignment() {
        testBoard.setupPieces();
        assert testBoard.getPieceAt(0, 0).getClass() == Rook.class;
        assert testBoard.getPieceAt(0, 1).getClass() == Knight.class;
        assert testBoard.getPieceAt(0, 2).getClass() == Bishop.class;
        assert testBoard.getPieceAt(0, 3).getClass() == Queen.class;
        assert testBoard.getPieceAt(0, 4).getClass() == King.class;
        assert testBoard.getPieceAt(0, 5).getClass() == Bishop.class;
        assert testBoard.getPieceAt(0, 6).getClass() == Knight.class;
        assert testBoard.getPieceAt(0, 7).getClass() == Rook.class;

        assert testBoard.getPieceAt(7, 0).getClass() == Rook.class;
        assert testBoard.getPieceAt(7, 1).getClass() == Knight.class;
        assert testBoard.getPieceAt(7, 2).getClass() == Bishop.class;
        assert testBoard.getPieceAt(7, 3).getClass() == Queen.class;
        assert testBoard.getPieceAt(7, 4).getClass() == King.class;
        assert testBoard.getPieceAt(7, 5).getClass() == Bishop.class;
        assert testBoard.getPieceAt(7, 6).getClass() == Knight.class;
        assert testBoard.getPieceAt(7, 7).getClass() == Rook.class;

        for (int i = 0; i < 7; i++) {
            assert testBoard.getPieceAt(1, i).getClass() == Pawn.class;
            assert testBoard.getPieceAt(6, i).getClass() == Pawn.class;
        }
    }

    @Test
    public void testInitialPieceColorAssignment() {
        testBoard.setupPieces();
        for (int column = 0; column < 7; column++) {
            assert testBoard.getPieceAt(0, column).getColor() == Color.WHITE;
            assert testBoard.getPieceAt(1, column).getColor() == Color.WHITE;
            assert testBoard.getPieceAt(6, column).getColor() == Color.BLACK;
            assert testBoard.getPieceAt(7, column).getColor() == Color.BLACK;
        }
    }
}