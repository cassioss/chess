package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.Square;
import org.junit.Before;
import org.junit.Test;

public class SquareTest {
    
    private Board squareBoard;
    
    @Before
    
    @Test
    public void zeroPositionToX(){
        int xPos = 1;
        int yPos = 9;
        Square tile = new Square(xPos, yPos);
    }
    
    @Test(expected = NullPointerException.class)
    public void nullStringAssignment(){
        int xPos = 0;
        int yPos = 0;
        
    }
}