package com.exposition.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameDialog {

    public GameDialog() {
        final Font font = new Font("Roboto", Font.PLAIN, 30);
        final Color background = Color.LIGHT_GRAY;
        final Color foreground = Color.BLACK;

        final JPanel gamePNL = new JPanel();
        gamePNL.setPreferredSize(new Dimension(600, 600));
        gamePNL.setBackground(background);
        gamePNL.setLayout(null)
        
        final Dimension labelSize = new Dimension(150, 50);
        final Dimension paneSize = new Dimension(300, 50);
        final JLabel nameLBL = new JLabel("Name: ",JLabel.RIGHT);
        nameLBL.setLocation(10, 10);
        nameLBL.setSize(labelSize);
        gamePNL.add(nameLBL);
    }

}
