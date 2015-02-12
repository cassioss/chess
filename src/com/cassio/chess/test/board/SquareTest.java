package com.cassio.chess.test.board;

import com.cassio.chess.exception.NoPieceException;
import com.cassio.chess.exception.SamePieceColorException;
import com.cassio.chess.library.board.Square;
import com.cassio.chess.library.piece.Piece;
import com.cassio.chess.library.piece.Rook;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

public class SquareTest {

    private static Piece whitePiece, blackPiece, secondWhite;
    private Square simpleTile;

    @BeforeClass
    public static void setupPieces() {
        whitePiece = new Rook(Color.white);
        blackPiece = new Rook(Color.black);
        secondWhite = new Rook(Color.white);
    }
    
    @Before
    public void setupSquare(){
        simpleTile = new Square();
    }

    @Test
    public void testWhitePieceAddition() {
        simpleTile.putPiece(whitePiece);
        assert simpleTile.getScore() == 1;
    }

    @Test
    public void testBlackPieceAddition() {
        simpleTile.putPiece(blackPiece);
        assert simpleTile.getScore() == -1;
    }
    
    @Test
    public void testMove(){
        simpleTile.putPiece(whitePiece);
        simpleTile.movePiece();
        assert simpleTile.getScore() == 0;
    }
    
    @Test(expected = NoPieceException.class)
    public void testMoveWithoutPieces(){
        simpleTile.movePiece();
    }
    
    @Test
    public void testCapturingAPiece() {
        simpleTile.putPiece(whitePiece);
        simpleTile.putPiece(blackPiece);
        assert simpleTile.getPiece() == blackPiece;
        assert simpleTile.getScore() == -1;
    }
    
    @Test(expected = SamePieceColorException.class)
    public void testCapturingOwnPiece() {
        simpleTile.putPiece(whitePiece);
        simpleTile.putPiece(secondWhite);
    }

}