package test.model.piece;

import chess.model.piece.Empress;
import org.junit.Test;

/**
 * <strong>EmpressTest</strong> class - tests the methods and verifies the expected behavior of an empress in a
 * chessboard, given its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.0
 */
public class EmpressTest {

    /**
     * Tests if the path to the Empress's image is correct. The test path is gathered directly from the image using
     * Ctrl+Shift+C.
     */
    @Test
    public void testImageGathering() {
        Empress testBlackEmpress = new Empress(true);
        Empress testWhiteEmpress = new Empress(false);
        assert testBlackEmpress.getPathToImage().equals("src/chess/view/img/black_empress.png");
        assert testWhiteEmpress.getPathToImage().equals("src/chess/view/img/white_empress.png");
    }

}