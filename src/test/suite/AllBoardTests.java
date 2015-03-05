package test.suite;

import test.model.board.BoardTest;
import test.model.board.ChessBoardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * <strong>AllBoardTests</strong> class - triggers the tests of all the classes related to the (chess)board's logic.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({BoardTest.class, ChessBoardTest.class})
public class AllBoardTests {
}