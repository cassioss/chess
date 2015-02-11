package com.cassio.chess.test.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.piece.Piece;
import com.cassio.chess.library.piece.Rook;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class PieceTest {

    private static Board testBoard;
    private static Piece whiteRook;

    @BeforeClass
    public static void setBoardAndPieces() {
        testBoard = new Board();
        whiteRook = new Rook(Color.WHITE);
    }

    @Test
    public void testInitialPosition() {
        testBoard.putPieceAt(whiteRook, 0, 7);
        assert testBoard.getPieceAt(0, 7) == whiteRook;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void putPieceOutOfBoard() {
        testBoard.putPieceAt(whiteRook, 0, 8);
    }

}