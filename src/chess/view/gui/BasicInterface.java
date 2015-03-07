package chess.view.gui;

import javax.swing.*;
import java.awt.*;

public class BasicInterface extends JFrame {
    private JPanel panel;
    private JButton[][] buttons;
    private final int SIZE = 8;
    private GridLayout experimentLayout;

    public BasicInterface() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);

        experimentLayout = new GridLayout(SIZE, SIZE);

        panel = new JPanel();
        panel.setLayout(experimentLayout);

        buttons = new JButton[SIZE][SIZE];
        addButtons(panel);

        add(panel);
        setVisible(true);
    }

    public void addButtons(JPanel panel) {
        for (int k = 0; k < SIZE; k++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[k][j] = new JButton(k + 1 + ", " + (j + 1));
                panel.add(buttons[k][j]);
            }
        }
    }

    public static void main(String[] args) {
        new BasicInterface();
    }

}