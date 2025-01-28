package com.exposition.frontend;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
    
        private final Dimension getUsableSpaceDimension() {
        setVisible(true);
        pack();
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        Insets frameInsets = getInsets();

        setVisible(false);
        return new Dimension(
            screenDimension.width - insets.left - insets.right - frameInsets.left - frameInsets.right,
            screenDimension.height - insets.top - insets.bottom - frameInsets.top - frameInsets.bottom
        );
    }

    public MainFrame(String FrameName) {
        SwingUtilities.invokeLater(() -> {
            final Dimension frameSize = getUsableSpaceDimension();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            add(new MainPanel(frameSize));
            
            pack();
            setVisible(true);
            setResizable(false);
        });
    }

}
