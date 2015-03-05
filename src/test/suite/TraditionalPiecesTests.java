package test.suite;

import test.piece.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * <strong>TraditionalPiecesTests</strong> class - triggers the tests of all the traditional pieces on a chessboard.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({PieceTest.class, PawnTest.class, RookTest.class, BishopTest.class, KnightTest.class, QueenTest
        .class})
public class TraditionalPiecesTests {

}