package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Chessboard;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

    private static Board testBoard;

    @BeforeClass
    public static void setBoard() {
        testBoard = new Chessboard();
    }
    
    @Test
    public void testCleanBoard(){
        testBoard.setupPieces();
        testBoard.cleanBoard();
        assert testBoard.hasNoPieces();
    }
}