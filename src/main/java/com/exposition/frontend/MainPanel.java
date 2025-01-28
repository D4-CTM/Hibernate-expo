package com.exposition.frontend;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
    private final Color BACKGROUND = Color.LIGHT_GRAY; 

    public MainPanel(Dimension panelSize) {
        setPreferredSize(panelSize);
        setBackground(BACKGROUND);
        setLayout(null);

        final Dimension headerSize = new Dimension(panelSize.width, (int) (panelSize.height * 0.075));
        Header header = new Header(headerSize);
        add(header);
    }

}
