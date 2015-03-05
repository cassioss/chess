package test.board;

import chess.model.board.ChessBoard;
import chess.model.piece.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * <strong>ChessBoardTest</strong> class - tests the specific implementations of a traditional chessboard.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class ChessBoardTest {

    private ChessBoard testChessBoard;

    /**
     * Creates a chessboard for every test - using a static chessboard could be confusing, as tests with different
     * modifications could affect each other.
     */
    @Before
    public void setUp() {
        testChessBoard = new ChessBoard();
    }

    /**
     * Verifies the existence of a square on each position of the expected 8x8 matrix.
     */
    @Test
    public void testSquareCreation() {
        for (int posX = 0; posX < 8; posX++) {
            for (int posY = 0; posY < 8; posY++)
                assert testChessBoard.hasSquareAt(posX, posY);
        }
    }

    /**
     * Tests square painting for every square on the board. As there is an alternating pattern, it is necessary to use a
     * for loop that verifies four squares per iteration.
     */
    @Test
    public void testSquarePainting() {
        for (int posX = 0; posX < 8; posX += 2) {
            for (int posY = 0; posY < 8; posY += 2) {
                assert testChessBoard.getSquareAt(posX, posY).getSquareColor() == Color.LIGHT_GRAY;
                assert testChessBoard.getSquareAt(posX, posY + 1).getSquareColor() == Color.WHITE;
                assert testChessBoard.getSquareAt(posX + 1, posY).getSquareColor() == Color.WHITE;
                assert testChessBoard.getSquareAt(posX + 1, posY + 1).getSquareColor() == Color.LIGHT_GRAY;
            }
        }
    }

    /**
     * Tests class assignment for the pieces. The expected setup for the traditional chessboard, for each player, is a
     * row of pawns defending a row of specific pieces: Rook - Knight - Bishop - Queen - King - Bishop - Knight - Rook.
     */
    @Test
    public void testInitialPieceClassAssignment() {
        testChessBoard.setupPieces();

        // White pieces

        assert testChessBoard.getPieceAt(0, 0).getClass() == Rook.class;
        assert testChessBoard.getPieceAt(0, 1).getClass() == Knight.class;
        assert testChessBoard.getPieceAt(0, 2).getClass() == Bishop.class;
        assert testChessBoard.getPieceAt(0, 3).getClass() == Queen.class;
        assert testChessBoard.getPieceAt(0, 4).getClass() == King.class;
        assert testChessBoard.getPieceAt(0, 5).getClass() == Bishop.class;
        assert testChessBoard.getPieceAt(0, 6).getClass() == Knight.class;
        assert testChessBoard.getPieceAt(0, 7).getClass() == Rook.class;

        // Black pieces

        assert testChessBoard.getPieceAt(7, 0).getClass() == Rook.class;
        assert testChessBoard.getPieceAt(7, 1).getClass() == Knight.class;
        assert testChessBoard.getPieceAt(7, 2).getClass() == Bishop.class;
        assert testChessBoard.getPieceAt(7, 3).getClass() == Queen.class;
        assert testChessBoard.getPieceAt(7, 4).getClass() == King.class;
        assert testChessBoard.getPieceAt(7, 5).getClass() == Bishop.class;
        assert testChessBoard.getPieceAt(7, 6).getClass() == Knight.class;
        assert testChessBoard.getPieceAt(7, 7).getClass() == Rook.class;

        for (int i = 0; i < 7; i++) {
            assert testChessBoard.getPieceAt(1, i).getClass() == Pawn.class;
            assert testChessBoard.getPieceAt(6, i).getClass() == Pawn.class;
        }
    }

    /**
     * Tests color assignment of the pieces.
     */
    @Test
    public void testInitialPieceColorAssignment() {
        testChessBoard.setupPieces();
        for (int column = 0; column < 7; column++) {

            // White pieces

            assert !testChessBoard.getPieceAt(0, column).isBlack();
            assert !testChessBoard.getPieceAt(1, column).isBlack();

            // Black pieces

            assert testChessBoard.getPieceAt(6, column).isBlack();
            assert testChessBoard.getPieceAt(7, column).isBlack();
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