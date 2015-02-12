package com.cassio.chess.test.suite;

import com.cassio.chess.test.piece.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PieceTest.class, PawnTest.class, RookTest.class, KnightTest.class, BishopTest.class,
        QueenTest.class, KingTest.class})
public class TraditionalPiecesTests {

}