package com.cassio.chess.test.piece;

import com.cassio.chess.library.board.Board;
import com.cassio.chess.library.board.ChessBoard;
import org.junit.Before;

/**
 * {@code KnightTest} class - tests the methods and verifies the expected behavior of a knight in a chessboard, given
 * its MoveSet limitations.
 *
 * @author Cassio dos Santos Sousa
 * @version 1.1
 * @since 1.0
 */
public class KnightTest {

    private Board testBoard;

    /**
     * Creates an empty, not-for-playing chessboard for testing purposes. It is non-static because a static instance of
     * the board would have pieces being placed without control.
     */
    @Before
    public void setUp() {
        testBoard = new ChessBoard();
    }

}