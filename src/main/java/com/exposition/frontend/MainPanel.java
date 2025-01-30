package com.exposition.frontend;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;

import com.exposition.backend.Game;
import com.exposition.backend.SessionManager;

public class MainPanel extends JPanel{
    private final Color BACKGROUND = Color.LIGHT_GRAY; 

    public MainPanel(Dimension panelSize) throws Throwable {
        SessionManager<Game> sessionManager = new SessionManager<>(Game.class);
        GameDialog dialog = new GameDialog(sessionManager);
        setPreferredSize(panelSize);
        setBackground(BACKGROUND);
        setLayout(null);

        final Dimension headerSize = new Dimension(panelSize.width, (int) (panelSize.height * 0.075));
        Header header = new Header(headerSize, sessionManager, dialog);
        add(header);
    }

}
