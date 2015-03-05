package test.model.piece;

import chess.model.board.Board;
import chess.model.board.ChessBoard;
import chess.model.piece.King;
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

    @Before
    public void setUp() {
        testBoard = new ChessBoard();
    }

    /**
     * Tests if the path to the King's image is correct. The test path is gathered directly from the image using
     * Ctrl+Shift+C.
     */
    @Test
    public void testImageGathering() {
        King testBlackKing = new King(true);
        King testWhiteKing = new King(false);
        assert testBlackKing.getPathToImage().equals("src/chess/view/img/black_king.png");
        assert testWhiteKing.getPathToImage().equals("src/chess/view/img/white_king.png");
    }


    @Test
    public void testPieceWithoutThreat() {
        King testBlackKing = new King(true);
        King testWhiteKing = new King(true);
    }
}