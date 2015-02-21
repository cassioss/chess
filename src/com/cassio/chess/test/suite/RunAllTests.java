package com.cassio.chess.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * <strong>RunAllTests</strong> class - triggers all the test suites in the package.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AllBoardTests.class, TraditionalPiecesTests.class})
public class RunAllTests {

}