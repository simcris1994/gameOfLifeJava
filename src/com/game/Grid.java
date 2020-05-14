package com.game;

import java.awt.*;

import javax.swing.*;

public class Grid extends JFrame {

    private JLabel[][] label;

    public Grid(int height, int width) {
        super("Is this real life?");

        JPanel panel = new JPanel(new GridLayout(height, width));
        label = new JLabel[height][width];
        Builder builder = new Builder(panel, label, height, width);

        builder.tumbler();

        add(panel, BorderLayout.CENTER);

        this.setSize(2030, 1050);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JLabel[][] getLabel() {
        return this.label;
    }
}
