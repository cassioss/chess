package test.model.piece;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.piece.King;
import chess.model.piece.Queen;
import chess.model.piece.Rook;
import org.junit.Before;
import org.junit.Test;

/**
 * <strong>KingTest</strong> class - tests the methods and verifies the expected behavior of a king in a chessboard,
 * given its MoveSet limitations. Check and checkmate situations are also being checked.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class KingTest {

    private Board testBoard;
    private King testBlackKing;
    private King testWhiteKing;

    /**
     * Creates an empty, not-for-playing chessboard for testing purposes, creating kings in both extremes of the
     * board. Setting them up like this helps verifying check/checkmate conditions.
     */
    @Before
    public void setUp() {
        testBoard = new ChessBoard();
        testBlackKing = new King(true);
        testWhiteKing = new King(false);
        testBoard.putPieceAt(testBlackKing, 7, 7);
        testBoard.putPieceAt(testWhiteKing, 0, 0);
    }

    /**
     * Tests if the path to the King's image is correct. The test path is gathered directly from the image using
     * Ctrl+Shift+C.
     */
    @Test
    public void testImageGathering() {
        assert testBlackKing.getPathToImage().equals("src/chess/view/img/black_king.png");
        assert testWhiteKing.getPathToImage().equals("src/chess/view/img/white_king.png");
    }

    /**
     * Tests a situation where both kings are out of threat on the board.
     */
    @Test
    public void testKingWithoutThreat() {
        Queen testBlackQueen = new Queen(true);
        Queen testWhiteQueen = new Queen(false);
        testBoard.putPieceAt(testBlackQueen, 3, 4);
        testBoard.putPieceAt(testWhiteQueen, 4, 2);
        assert !testBlackKing.isInCheck();
        assert !testWhiteKing.isInCheck();
    }

    /**
     * Tests a situation where one of the kings is in check on the board.
     */
    @Test
    public void testKingInCheck(){
        Queen testBlackQueen = new Queen(true);
        Queen testWhiteQueen = new Queen(false);
        testBoard.putPieceAt(testBlackQueen, 3, 4);
        testBoard.putPieceAt(testWhiteQueen, 0, 7);
        assert testBlackKing.isInCheck();
        assert !testWhiteKing.isInCheck();
    }

    /**
     * Tests a situation where one of the kings is in checkmate on the board.
     */
    @Test
    public void testKingInCheckMate(){
        Rook testBlackRook = new Rook(true);
        Rook testWhiteRook = new Rook(false);
        Queen testWhiteQueen = new Queen(false);
        testBoard.putPieceAt(testBlackRook, 3, 4);
        testBoard.putPieceAt(testWhiteRook, 0, 6);
        testBoard.putPieceAt(testWhiteQueen, 0, 7);
        assert !testWhiteKing.isInCheck();
        assert testBlackKing.isInCheck();
        assert testBlackKing.isInCheckMate();
    }
}