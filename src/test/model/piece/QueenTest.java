package test.model.piece;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.piece.Queen;
import org.junit.Before;
import org.junit.Test;

/**
 * <strong>QueenTest</strong> class - tests the methods and verifies the expected behavior of a queen in a chessboard,
 * given its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class QueenTest {

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
     * Tests if the path to the Queen's image is correct. The test path is gathered directly from the image using
     * Ctrl+Shift+C.
     */
    @Test
    public void testImageGathering() {
        Queen testBlackQueen = new Queen(true);
        Queen testWhiteQueen = new Queen(false);
        assert testBlackQueen.getPathToImage().equals("src/chess/view/img/black_queen.png");
        assert testWhiteQueen.getPathToImage().equals("src/chess/view/img/white_queen.png");
    }

    /**
     * Tests if a queen can move diagonally at any direction.
     */
    @Test
    public void testDiagonalMoves() {
        Queen testQueen = new Queen(true);
        testBoard.putPieceAt(testQueen, 3, 3);
        assert !testQueen.canMoveTo(testBoard.getSquareAt(3, 3));
        for (int dist = 1; dist < 4; dist++) {
            assert testQueen.canMoveTo(testBoard.getSquareAt(3 + dist, 3 + dist));
            assert testQueen.canMoveTo(testBoard.getSquareAt(3 + dist, 3 - dist));
            assert testQueen.canMoveTo(testBoard.getSquareAt(3 - dist, 3 + dist));
            assert testQueen.canMoveTo(testBoard.getSquareAt(3 - dist, 3 - dist));
        }
    }

    /**
     * Tests if a queen can move upwards.
     */
    @Test
    public void testVerticalUpwardsMovement() {
        Queen testQueen = new Queen(true);
        testBoard.putPieceAt(testQueen, 0, 0);
        assert !testQueen.canMoveTo(testBoard.getSquareAt(0, 0));
        for (int yPos = 1; yPos < 8; yPos++)
            assert testQueen.canMoveTo(testBoard.getSquareAt(0, yPos));
    }

    /**
     * Tests if a queen can move downwards.
     */
    @Test
    public void testVerticalDownwardsMovement() {
        Queen testQueen = new Queen(true);
        testBoard.putPieceAt(testQueen, 0, 7);
        assert !testQueen.canMoveTo(testBoard.getSquareAt(0, 7));
        for (int yPos = 6; yPos >= 0; yPos--)
            assert testQueen.canMoveTo(testBoard.getSquareAt(0, yPos));
    }

    /**
     * Tests if a queen can move to the left.
     */
    @Test
    public void testHorizontalLeftMovement() {
        Queen testQueen = new Queen(true);
        testBoard.putPieceAt(testQueen, 7, 0);
        assert !testQueen.canMoveTo(testBoard.getSquareAt(7, 0));
        for (int xPos = 6; xPos >= 0; xPos--)
            assert testQueen.canMoveTo(testBoard.getSquareAt(xPos, 0));
    }

    /**
     * Tests if a queen can move to the right.
     */
    @Test
    public void testHorizontalRightMovement() {
        Queen testQueen = new Queen(true);
        testBoard.putPieceAt(testQueen, 0, 0);
        assert !testQueen.canMoveTo(testBoard.getSquareAt(0, 0));
        for (int xPos = 1; xPos < 8; xPos++)
            assert testQueen.canMoveTo(testBoard.getSquareAt(xPos, 0));
    }
}