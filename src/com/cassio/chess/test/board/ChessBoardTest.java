package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChessBoardTest {

    private static Board testBoard;

    @BeforeClass
    public static void setBoard() {
        testBoard = new ChessBoard();
    }

    @Test
    public void testLetterAssignment() {
        assert testBoard.getLetterCoordinate(0) == 'a';
        assert testBoard.getLetterCoordinate(1) == 'b';
        assert testBoard.getLetterCoordinate(2) == 'c';
        assert testBoard.getLetterCoordinate(3) == 'd';
        assert testBoard.getLetterCoordinate(4) == 'e';
        assert testBoard.getLetterCoordinate(5) == 'f';
        assert testBoard.getLetterCoordinate(6) == 'g';
        assert testBoard.getLetterCoordinate(7) == 'h';
    }
}