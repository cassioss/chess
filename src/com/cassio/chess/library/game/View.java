package com.cassio.chess.library.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class View implements ActionListener {

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //silently ignore
        }
        String path = "src/com/cassio/chess/img/whitePawn.png";
        File file = new File(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame window = new JFrame("\u265A Chess Game \u2654");
        window.setSize(800, 800);
        JPanel myPanel = initializePanel();
        initializeButton(myPanel);
        setUpMenu(window);
        window.setContentPane(myPanel);
        JLabel picLabel = new JLabel(new ImageIcon(image));
        window.getContentPane().add(picLabel);
        window.setLocation(200, 200);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeButton(JPanel myPanel) {
        JButton button = new JButton("Click me");
        button.addActionListener(this);
        myPanel.add(button, BorderLayout.SOUTH);
    }

    private JPanel initializePanel() {
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500, 500));
        myPanel.setLayout(new BorderLayout());
        return myPanel;
    }

    private void setUpMenu(JFrame window) {
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        file.add(open);
        menubar.add(file);
        window.setJMenuBar(menubar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "I was clicked by " + e.getActionCommand(),
                "Title here", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new View();
    }
}