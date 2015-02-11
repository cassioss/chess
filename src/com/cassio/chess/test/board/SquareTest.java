package com.cassio.chess.test.board;

import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.piece.Piece;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class SquareTest {
    
    private static Piece whitePiece;
    private Square simpleTile;
    
    @BeforeClass
    public static void setupPieces(){
        whitePiece = new Piece(Color.white);
    }
    
    @Test
    public void testWhitePieceAddition(){
        simpleTile = new Square(0,0);
        
    }
}