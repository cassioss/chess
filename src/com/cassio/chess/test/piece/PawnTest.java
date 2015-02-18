package com.cassio.chess.test.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.piece.Pawn;
import org.junit.Before;
import org.junit.Test;

public class PawnTest {

    private Board testBoard;
    private Pawn testWhitePawn;
    private Pawn testBlackPawn;

    /**
     * Creates an empty, not-for-playing chessboard for testing purposes. It is non-static because a static instance of
     * the board would have pieces being placed without control.
     */
    @Before
    public void setUp() {
        testBoard = new ChessBoard();
    }

    /**
     * Tests the one-square move possibility of a white pawn.
     */
    @Test
    public void testWhitePawnMovement() {
        testWhitePawn = new Pawn(false);
        testBoard.putPieceAt(testWhitePawn, 2, 2);
        assert testWhitePawn.getPossibleMoves().contains(testBoard.getSquareAt(2, 3));
    }


}