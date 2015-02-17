package com.cassio.chess.test.board;

import com.cassio.chess.library.board.ChessBoard;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@code ChessBoardTest} class - tests the initial setup of a traditional chessboard.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class ChessBoardTest {

    private static ChessBoard testChessBoard;

    /**
     * Creates a static chessboard for testing purposes.
     */
    @BeforeClass
    public static void setBoard() {
        testChessBoard = new ChessBoard();
    }

    /**
     * Verifies the existence of a square on each position of the expected 8x8 matrix.
     */
    @Test
    public void testSquareCreation() {
        for (int posX = 0; posX <= 7; posX++) {
            for (int posY = 0; posY <= 7; posY++) {
                assert testChessBoard.hasSquareAt(posX, posY);
            }
        }
    }

/*
    @Test
    public void testLetterAssignment() {
        assert testBoard.getLetterCoordinate(0) == 'a';
        assert testBoard.getLetterCoordinate(1) == 'b';
        assert testBoard.getLetterCoordinate(2) == 'c';
        assert testBoard.getLetterCoordinate(3) == 'd';
        assert testBoard.getLetterCoordinate(4) == 'e';
        assert testBoard.getLetterCoordinate(5) == 'f';
        assert testBoard.getLetterCoordinate(6) == 'g';
        assert testBoard.getLetterCoordinate(7) == 'h';
    }


    @Test
    public void testInitialPieceClassAssignment() {
        testBoard.setupPieces();
        assert testBoard.getPieceAt(0, 0).getClass() == Rook.class;
        assert testBoard.getPieceAt(0, 1).getClass() == Knight.class;
        assert testBoard.getPieceAt(0, 2).getClass() == Bishop.class;
        assert testBoard.getPieceAt(0, 3).getClass() == Queen.class;
        assert testBoard.getPieceAt(0, 4).getClass() == King.class;
        assert testBoard.getPieceAt(0, 5).getClass() == Bishop.class;
        assert testBoard.getPieceAt(0, 6).getClass() == Knight.class;
        assert testBoard.getPieceAt(0, 7).getClass() == Rook.class;

        assert testBoard.getPieceAt(7, 0).getClass() == Rook.class;
        assert testBoard.getPieceAt(7, 1).getClass() == Knight.class;
        assert testBoard.getPieceAt(7, 2).getClass() == Bishop.class;
        assert testBoard.getPieceAt(7, 3).getClass() == Queen.class;
        assert testBoard.getPieceAt(7, 4).getClass() == King.class;
        assert testBoard.getPieceAt(7, 5).getClass() == Bishop.class;
        assert testBoard.getPieceAt(7, 6).getClass() == Knight.class;
        assert testBoard.getPieceAt(7, 7).getClass() == Rook.class;

        for (int i = 0; i < 7; i++) {
            assert testBoard.getPieceAt(1, i).getClass() == Pawn.class;
            assert testBoard.getPieceAt(6, i).getClass() == Pawn.class;
        }
    }

    @Test
    public void testInitialPieceColorAssignment() {
        testBoard.setupPieces();
        for (int column = 0; column < 7; column++) {
            assert testBoard.getPieceAt(0, column).getColor() == Color.WHITE;
            assert testBoard.getPieceAt(1, column).getColor() == Color.WHITE;
            assert testBoard.getPieceAt(6, column).getColor() == Color.BLACK;
            assert testBoard.getPieceAt(7, column).getColor() == Color.BLACK;
        }
    }*/
}