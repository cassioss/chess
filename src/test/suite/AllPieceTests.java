package test.suite;

import test.model.piece.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * <strong>AllPieceTests</strong> class - triggers the tests of all pieces created so far for a chessboard.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({PieceTest.class, PawnTest.class, RookTest.class, BishopTest.class, KnightTest.class, QueenTest
        .class, EmpressTest.class, PrincessTest.class, KingTest.class})
public class AllPieceTests {

}