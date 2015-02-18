package com.cassio.chess.test.suite;

import com.cassio.chess.test.piece.PawnTest;
import com.cassio.chess.test.piece.RookTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PawnTest.class, RookTest.class})
public class TraditionalPiecesTests {

}