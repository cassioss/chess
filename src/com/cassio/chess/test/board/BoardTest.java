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
        Square tile = testBoard.getSquareAt(3, 4);
        assert tile.getSquareColor() == Color.white;
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSquareOutOfBounds(){
        Square tile = testBoard.getSquareAt(8, 5);
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