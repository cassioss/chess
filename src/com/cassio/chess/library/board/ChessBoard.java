package com.cassio.chess.library.board;

/**
 * Created by Cassio on 12/02/2015.
 */
public class ChessBoard extends Board {
    
    public ChessBoard() {
        super();
    }

    private static final char[] LETTER_COORDINATES = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

    public char getLetterCoordinate(int posX) {
        return LETTER_COORDINATES[posX];
    }

}
