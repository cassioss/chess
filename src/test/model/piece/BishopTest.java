package test.model.piece;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.piece.Bishop;
import org.junit.Before;
import org.junit.Test;

/**
 * <strong>BishopTest</strong> class - tests the methods and verifies the expected behavior of a bishop in a chessboard,
 * given its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class BishopTest {

    private Board testBoard;

    /**
     * Creates an empty, not-for-playing chessboard for testing purposes. It is non-static because a static instance of
     * the board would have pieces being placed without control.
     */
    @Before
    public void setUp() {
        testBoard = new ChessBoard();
    }

    /**
     * Tests if a bishop can move diagonally at any direction.
     */
    @Test
    public void testDiagonalMoves() {
        Bishop testBishop = new Bishop(true);
        testBoard.putPieceAt(testBishop, 3, 3);
        assert !testBishop.canMoveTo(testBoard.getSquareAt(3, 3));
        for (int dist = 1; dist < 4; dist++) {
            assert testBishop.canMoveTo(testBoard.getSquareAt(3 + dist, 3 + dist));
            assert testBishop.canMoveTo(testBoard.getSquareAt(3 + dist, 3 - dist));
            assert testBishop.canMoveTo(testBoard.getSquareAt(3 - dist, 3 + dist));
            assert testBishop.canMoveTo(testBoard.getSquareAt(3 - dist, 3 - dist));
        }
    }

    /**
     * Tests if a bishop cannot move forward when a same-player piece is in the way.
     */
    @Test
    public void testPlayerPieceBlock() {
        Bishop testBishopOne = new Bishop(true);
        Bishop testBishopTwo = new Bishop(true);
        testBoard.putPieceAt(testBishopTwo, 3, 3);
        testBoard.putPieceAt(testBishopOne, 0, 0);
        assert testBishopOne.canMoveTo(testBoard.getSquareAt(1, 1));
        assert testBishopOne.canMoveTo(testBoard.getSquareAt(2, 2));
        assert !testBishopOne.canMoveTo(testBoard.getSquareAt(3, 3));
        assert !testBishopOne.canMoveTo(testBoard.getSquareAt(4, 4));
    }

    /**
     * Tests if a bishop cannot move forward when an opponent piece is in the way.
     */
    @Test
    public void testOpponentPieceBlock() {
        Bishop testBlackBishop = new Bishop(true);
        Bishop testWhiteBishop = new Bishop(false);
        testBoard.putPieceAt(testWhiteBishop, 3, 3);
        testBoard.putPieceAt(testBlackBishop, 0, 0);
        assert testBlackBishop.canMoveTo(testBoard.getSquareAt(1, 1));
        assert testBlackBishop.canMoveTo(testBoard.getSquareAt(2, 2));
        assert testBlackBishop.canMoveTo(testBoard.getSquareAt(3, 3));
        assert !testBlackBishop.canMoveTo(testBoard.getSquareAt(4, 4));
    }


}