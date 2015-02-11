package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

public class BoardTest {

    private Board testBoard;
    
    @Before
    public void setBoard(){
        testBoard = new Board();
    }
    
    @Test
    public void testSquareColorAssignment()  {
        int x = 17, y = 14;
        Square tile = new Square(x,y);
        testBoard.setSquareColor(tile);
        assert tile.getSquareColor() == Color.white;
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void getSquareOutOfBounds(){
        int x = 8, y = 5;
        Square tile = testBoard.getSquare(x,y);
    }
}