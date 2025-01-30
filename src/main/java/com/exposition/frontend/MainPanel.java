package com.exposition.frontend;

import java.awt.Dimension;
import java.util.List;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.exposition.backend.Game;
import com.exposition.backend.SessionManager;

public class MainPanel extends JPanel{
    private final Color BACKGROUND = Color.LIGHT_GRAY; 
    private final GameDialog dialog;
    private final Dimension gamePNLSize;
    private int page = 0;

    public MainPanel(Dimension panelSize) throws Throwable {
        final int scrollBarWidth = 15;
        gamePNLSize = new Dimension(panelSize.width - scrollBarWidth, (int) (panelSize.height * 0.1));        

        SessionManager<Game> sessionManager = new SessionManager<>(Game.class);
        dialog = new GameDialog(this, sessionManager);
        setPreferredSize(panelSize);
        setBackground(BACKGROUND);
        setLayout(null);

        final Dimension headerSize = new Dimension(panelSize.width, (int) (panelSize.height * 0.075));
        Header header = new Header(headerSize, sessionManager, dialog);
        add(header);

        final int scrollPaneHeight = (int) (panelSize.height * (1 - (0.075 + 0.075 + 0.1)));

        final GamePanel platePanel = new GamePanel(gamePNLSize);
        platePanel.setLocation(0, headerSize.height);
        add(platePanel);

        gamePNL = new JPanel();
        gamePNL.setBackground(getBackground());
        gamePNL.setLayout(new BoxLayout(gamePNL, BoxLayout.Y_AXIS));

        final JScrollPane scrollPane = new JScrollPane(gamePNL);
        scrollPane.setPreferredSize(new Dimension(panelSize.width, scrollPaneHeight));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        final JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setPreferredSize(new Dimension(scrollBarWidth, scrollPaneHeight));
        scrollPane.setVerticalScrollBar(scrollBar);

        scrollPane.setLocation(0, platePanel.getY() + platePanel.getHeight());
        scrollPane.setSize(panelSize.width, scrollPaneHeight);
        add(scrollPane);
        
        showElements(sessionManager);
    }

    public void showElements(final SessionManager<Game> sessionManager) {
        List<Game> games = sessionManager.getElements(page);
        if (games == null) return ;

        gamePNL.removeAll();
        GamePanel gamePanel;
        for (Game game : games) {
            gamePanel = new GamePanel(game,dialog, gamePNLSize);
            gamePanel.setMaximumSize(gamePNLSize);
            gamePanel.setMinimumSize(gamePNLSize);
            gamePNL.add(gamePanel);
        }

        gamePNL.revalidate();
        gamePNL.repaint();
    }

    final JPanel gamePNL;
}
