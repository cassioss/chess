package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class BoardTest {

    private static Board testBoard;

    @BeforeClass
    public static void setBoard(){
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
    public void testSquareOutOfBounds(){
        int x = 8, y = 5;
        Square tile = testBoard.getSquare(x, y);
    }
    
    @Test
    public void testLetterAssignment(){
        assert testBoard.getLetterCoordinate(0) == 'a';
        assert testBoard.getLetterCoordinate(1) == 'b';
        assert testBoard.getLetterCoordinate(3) == 'd';
        assert testBoard.getLetterCoordinate(5) == 'f';
        assert testBoard.getLetterCoordinate(7) == 'h';
    }
}