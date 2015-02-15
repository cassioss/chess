package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

    private static Board testBoard;

    @BeforeClass
    public static void setBoard() {
        testBoard = new ChessBoard();
    }
    
    @Test
    public void testCleanBoard(){
        testBoard.setupPieces();
        assert !testBoard.hasNoPieces();
        testBoard.clearBoard();
        assert testBoard.hasNoPieces();
    }
}