package com.cassio.chess.test.piece;

import com.cassio.chess.exception.AlreadyHasPieceException;
import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Chessboard;
import com.cassio.chess.library.piece.Piece;
import com.cassio.chess.library.piece.Rook;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class PieceTest {

    private static Board testBoard;
    private static Piece whiteRook;
    private static Piece secondWhiteRook;
    private static Piece blackRook;

    @BeforeClass
    public static void setBoardAndPieces() {
        testBoard = new Chessboard();
        whiteRook = new Rook(Color.WHITE);
        secondWhiteRook = new Rook(Color.WHITE);
        blackRook = new Rook(Color.BLACK);
    }

    @Test
    public void testInitialPosition() {
        assert testBoard.hasNoPieces();
        testBoard.putPieceAt(whiteRook, 0, 7);
        assert testBoard.getPieceAt(0, 7) == whiteRook;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPutPieceOutOfBoard() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whiteRook, 0, 8);
    }

    // Tests to block putting new pieces without moves

    @Test(expected = AlreadyHasPieceException.class)
    public void testPutPieceOverPlayerPiece() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(secondWhiteRook, 0, 0);
    }

    @Test(expected = AlreadyHasPieceException.class)
    public void testPutPieceOverOpponentPiece() {
        testBoard.cleanBoard();
        testBoard.putPieceAt(whiteRook, 0, 0);
        testBoard.putPieceAt(blackRook, 0, 0);
    }

}