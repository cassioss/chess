package com.cassio.chess.game;

import com.cassio.chess.library.board.ChessBoard;
import com.cassio.chess.library.board.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View implements ActionListener {

    public View(ChessBoard referenceBoard) {
        JPanel customPanel = drawSquareBoard(referenceBoard);
        JFrame frame = new JFrame("\u265A Chess Game \u2654");
        drawSquareBoard(referenceBoard);
        frame.setContentPane(customPanel);
        frame.setSize(800, 800);
        frame.setLocation(50, 50);
        frame.setVisible(true);
    }

    private JPanel drawSquareBoard(ChessBoard referenceBoard) {
        JPanel squarePanel = new JPanel();
        for (int xPos = 0; xPos < 8; xPos++) {
            for (int yPos = 0; yPos < 8; yPos++) {
                RectDraw squareImage = new RectDraw(100 * xPos, 100 * yPos, referenceBoard.getSquareAt(xPos, yPos));
                squarePanel.add(squareImage);
            }
        }
        return squarePanel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e action event of any kind.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private static class RectDraw extends JPanel implements ActionListener {

        private int posX, posY;
        private Square referenceSquare;

        protected RectDraw(int posX, int posY, Square referenceSquare) {
            this.posX = posX;
            this.posY = posY;
            this.referenceSquare = referenceSquare;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(posX, posY, 100, 100);
            g.setColor(referenceSquare.getSquareColor());
            g.fillRect(posX, posY, 100, 100);
        }

        /**
         * Invoked when an action occurs.
         *
         * @param e action event of any kind.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static void main(String[] args) {
        new View(new ChessBoard());
    }
}