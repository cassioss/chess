package com.cassio.chess.test.suite;

import com.cassio.chess.test.board.BoardTest;
import com.cassio.chess.test.board.ChessboardTest;
import com.cassio.chess.test.board.SquareTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({SquareTest.class, BoardTest.class, ChessboardTest.class})
public class AllBoardTests {
}