package com.cassio.chess.test.suite;

import com.cassio.chess.test.piece.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PawnTest.class, RookTest.class, BishopTest.class, KnightTest.class, QueenTest.class})
public class TraditionalPiecesTests {

}