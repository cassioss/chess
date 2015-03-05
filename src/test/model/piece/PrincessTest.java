package test.model.piece;

import chess.model.piece.Princess;
import org.junit.Test;

/**
 * <strong>PrincessTest</strong> class - tests the methods and verifies the expected behavior of a princess in a
 * chessboard, given its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class PrincessTest {

    /**
     * Tests if the path to the Princess's image is correct. The test path is gathered directly from the image using
     * Ctrl+Shift+C.
     */
    @Test
    public void testImageGathering() {
        Princess testBlackPrincess = new Princess(true);
        Princess testWhitePrincess = new Princess(false);
        assert testBlackPrincess.getPathToImage().equals("src/chess/view/img/black_princess.png");
        assert testWhitePrincess.getPathToImage().equals("src/chess/view/img/white_princess.png");
    }

}