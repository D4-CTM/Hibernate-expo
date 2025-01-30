package com.exposition.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.exposition.backend.Game;

public class GamePanel extends JPanel {
    private final Border DEFAULT_BORDER = BorderFactory.createLineBorder(Color.BLACK, 2);
    private final Font SYSTEM_FONT = new Font("Roboto", Font.PLAIN, 30);
    private final Color UNFOCUSED = Color.DARK_GRAY;
    private final Color FOCUSED = Color.BLACK;
    
    public GamePanel(Dimension size) {
        final int usableWidth = (int) (size.getWidth() - size.getHeight());
        setSize(usableWidth, size.height);
        setOpaque(false);
        setLayout(null);

        final JLabel idLBL = new JLabel("ID", JLabel.CENTER);
        idLBL.setSize((int) (usableWidth * 0.1), size.height);
        idLBL.setBorder(DEFAULT_BORDER);
        idLBL.setForeground(FOCUSED);
        idLBL.setFont(SYSTEM_FONT);
        idLBL.setLocation(0, 0);
        add(idLBL);

        final JLabel nameLBL = new JLabel("NAME", JLabel.CENTER);
        nameLBL.setSize((int) (usableWidth * 0.5), size.height);
        nameLBL.setBorder(DEFAULT_BORDER);
        nameLBL.setForeground(FOCUSED);
        nameLBL.setFont(SYSTEM_FONT);
        nameLBL.setLocation(idLBL.getX() + idLBL.getWidth(), 0);
        add(nameLBL);

        final JLabel priceLBL = new JLabel("PRICE", JLabel.CENTER);
        priceLBL.setSize((int) (usableWidth * 0.2), size.height);
        priceLBL.setBorder(DEFAULT_BORDER);
        priceLBL.setForeground(FOCUSED);
        priceLBL.setFont(SYSTEM_FONT);
        priceLBL.setLocation(nameLBL.getX() + nameLBL.getWidth(), 0);
        add(priceLBL);

        final JLabel ratingLBL = new JLabel("RATING", JLabel.CENTER);
        ratingLBL.setSize((int) (usableWidth * 0.2), size.height);
        ratingLBL.setBorder(DEFAULT_BORDER);
        ratingLBL.setForeground(FOCUSED);
        ratingLBL.setFont(SYSTEM_FONT);
        ratingLBL.setLocation(priceLBL.getX() + priceLBL.getWidth(), 0);
        add(ratingLBL);
    }

    public GamePanel(Game game, GameDialog dialog, Dimension size) {
        final int usableWidth = (int) (size.getWidth() - size.getHeight());
        setPreferredSize(size);
        setOpaque(false);
        setLayout(null);

        final JLabel idLBL = new JLabel(String.valueOf(game.getId()), JLabel.CENTER);
        idLBL.setSize((int) (usableWidth * 0.1), size.height);
        idLBL.setBorder(DEFAULT_BORDER);
        idLBL.setForeground(UNFOCUSED);
        idLBL.setFont(SYSTEM_FONT);
        idLBL.setLocation(0, 0);
        add(idLBL);

        final JLabel nameLBL = new JLabel(game.getName(), JLabel.CENTER);
        nameLBL.setSize((int) (usableWidth * 0.5), size.height);
        nameLBL.setBorder(DEFAULT_BORDER);
        nameLBL.setForeground(UNFOCUSED);
        nameLBL.setFont(SYSTEM_FONT);
        nameLBL.setLocation(idLBL.getX() + idLBL.getWidth(), 0);
        add(nameLBL);

        final JLabel priceLBL = new JLabel(String.valueOf(game.getPrice()), JLabel.CENTER);
        priceLBL.setSize((int) (usableWidth * 0.2), size.height);
        priceLBL.setBorder(DEFAULT_BORDER);
        priceLBL.setForeground(UNFOCUSED);
        priceLBL.setFont(SYSTEM_FONT);
        priceLBL.setLocation(nameLBL.getX() + nameLBL.getWidth(), 0);
        add(priceLBL);

        final JLabel ratingLBL = new JLabel(String.valueOf(game.getRating()), JLabel.CENTER);
        ratingLBL.setSize((int) (usableWidth * 0.2), size.height);
        ratingLBL.setBorder(DEFAULT_BORDER);
        ratingLBL.setForeground(UNFOCUSED);
        ratingLBL.setFont(SYSTEM_FONT);
        ratingLBL.setLocation(priceLBL.getX() + priceLBL.getWidth(), 0);
        add(ratingLBL);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dialog.update(game);
                nameLBL.setText(game.getName());
                priceLBL.setText(String.valueOf(game.getPrice()));
                ratingLBL.setText(String.valueOf(game.getRating()));
                revalidate();
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                for (final var component : getComponents()) {
                    component.setForeground(FOCUSED);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                for (final var component : getComponents()) {
                    component.setForeground(UNFOCUSED);
                }
            }
                        
        });
    }

}
