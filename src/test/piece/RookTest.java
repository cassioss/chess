package test.piece;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.piece.Rook;
import org.junit.Before;
import org.junit.Test;

/**
 * <strong>RookTest</strong> class - tests the methods and verifies the expected behavior of a rook in a chessboard,
 * given its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class RookTest {

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
     * Tests if a rook can move upwards.
     */
    @Test
    public void testVerticalUpwardsMovement() {
        Rook testRook = new Rook(true);
        testBoard.putPieceAt(testRook, 0, 0);
        assert !testRook.canMoveTo(testBoard.getSquareAt(0, 0));
        for (int yPos = 1; yPos < 8; yPos++)
            assert testRook.canMoveTo(testBoard.getSquareAt(0, yPos));
    }

    /**
     * Tests if a rook can move downwards.
     */
    @Test
    public void testVerticalDownwardsMovement() {
        Rook testRook = new Rook(true);
        testBoard.putPieceAt(testRook, 0, 7);
        assert !testRook.canMoveTo(testBoard.getSquareAt(0, 7));
        for (int yPos = 6; yPos >= 0; yPos--)
            assert testRook.canMoveTo(testBoard.getSquareAt(0, yPos));
    }

    /**
     * Tests if a rook can move to the left.
     */
    @Test
    public void testHorizontalLeftMovement() {
        Rook testRook = new Rook(true);
        testBoard.putPieceAt(testRook, 7, 0);
        assert !testRook.canMoveTo(testBoard.getSquareAt(7, 0));
        for (int xPos = 6; xPos >= 0; xPos--)
            assert testRook.canMoveTo(testBoard.getSquareAt(xPos, 0));
    }

    /**
     * Tests if a rook can move to the right.
     */
    @Test
    public void testHorizontalRightMovement() {
        Rook testRook = new Rook(true);
        testBoard.putPieceAt(testRook, 0, 0);
        assert !testRook.canMoveTo(testBoard.getSquareAt(0, 0));
        for (int xPos = 1; xPos < 8; xPos++)
            assert testRook.canMoveTo(testBoard.getSquareAt(xPos, 0));
    }

    /**
     * Tests if a rook's move set is limited when another, same-player piece is added.
     */
    @Test
    public void testPlayerPieceBlock() {
        Rook testRookOne = new Rook(true);
        Rook testRookTwo = new Rook(true);
        testBoard.putPieceAt(testRookTwo, 3, 0);
        testBoard.putPieceAt(testRookOne, 0, 0);
        assert testRookOne.canMoveTo(testBoard.getSquareAt(1, 0));
        assert testRookOne.canMoveTo(testBoard.getSquareAt(2, 0));
        for (int posX = 3; posX < 8; posX++)
            assert !testRookOne.canMoveTo(testBoard.getSquareAt(posX, 0));
    }

    /**
     * Tests if a rook's move set is limited when another, opponent-player piece is added.
     */
    @Test
    public void testOpponentPieceBlock() {
        Rook testRookOne = new Rook(true);
        Rook testRookTwo = new Rook(false);
        testBoard.putPieceAt(testRookTwo, 3, 0);
        testBoard.putPieceAt(testRookOne, 0, 0);
        assert testRookOne.canMoveTo(testBoard.getSquareAt(1, 0));
        assert testRookOne.canMoveTo(testBoard.getSquareAt(2, 0));
        assert testRookOne.canMoveTo(testBoard.getSquareAt(3, 0));
        for (int posX = 4; posX < 8; posX++)
            assert !testRookOne.canMoveTo(testBoard.getSquareAt(posX, 0));
    }
}