package com.cassio.chess.test.piece;

import com.cassio.chess.library.board.Board;
import org.junit.BeforeClass;
import org.junit.Test;

public class RookTest {

    private static Board testBoard;
    
    @BeforeClass
    public static void setupBoard(){
        testBoard = new Board();
    }
    
    @Test
    public void testGetColor() {

    }
}