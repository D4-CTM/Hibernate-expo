package com.exposition.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.exposition.backend.Game;
import com.exposition.backend.SessionManager;

public class GameDialog {
    private final Font font = new Font("Roboto", Font.PLAIN, 30);
    private final Color background = Color.LIGHT_GRAY;
    private final Color foreground = Color.BLACK;
    private final JDialog dialog;
    private Game game = null;

    public GameDialog(MainPanel mainPanel, SessionManager<Game> sessionManager) {
        final JPanel gamePNL = new JPanel();
        gamePNL.setPreferredSize(new Dimension(470, 310));
        gamePNL.setBackground(background);
        gamePNL.setLayout(null);
        
        final Dimension labelSize = new Dimension(150, 50);
        final JLabel nameLBL = new JLabel("Name: ",JLabel.RIGHT);
        nameLBL.setForeground(foreground);
        nameLBL.setLocation(10, 10);
        nameLBL.setSize(labelSize);
        nameLBL.setFont(font);
        gamePNL.add(nameLBL);
        
        final JLabel priceLBL = new JLabel("Price: ",JLabel.RIGHT);
        priceLBL.setForeground(foreground);
        priceLBL.setLocation(10, nameLBL.getY() + nameLBL.getHeight() + 10);
        priceLBL.setSize(labelSize);
        priceLBL.setFont(font);
        gamePNL.add(priceLBL);

        final JLabel ratingLBL = new JLabel("Rating: ",JLabel.RIGHT);
        ratingLBL.setForeground(foreground);
        ratingLBL.setLocation(10, priceLBL.getY() + priceLBL.getHeight() + 10);
        ratingLBL.setSize(labelSize);
        ratingLBL.setFont(font);
        gamePNL.add(ratingLBL);

        final JLabel publisherLBL = new JLabel("Publisher: ",JLabel.RIGHT);
        publisherLBL.setForeground(foreground);
        publisherLBL.setLocation(10, ratingLBL.getY() + ratingLBL.getHeight() + 10);
        publisherLBL.setSize(labelSize);
        publisherLBL.setFont(font);
        gamePNL.add(publisherLBL);

        final Dimension txtFieldSize = new Dimension(300, 50);
        nameFLD = new JTextField();
        nameFLD.setLocation(nameLBL.getX() + nameLBL.getWidth(), nameLBL.getY());
        nameFLD.setForeground(foreground);
        nameFLD.setSize(txtFieldSize);
        nameFLD.setFont(font);
        gamePNL.add(nameFLD);

        priceSPNR = new JSpinner(new SpinnerNumberModel(1200.00, 100.00, 2500.00, 100.00));
        priceSPNR.setLocation(priceLBL.getX() + priceLBL.getWidth(), priceLBL.getY());
        priceSPNR.setForeground(foreground);
        priceSPNR.setSize(txtFieldSize);
        priceSPNR.setFont(font);
        gamePNL.add(priceSPNR);

        ratingSPNR = new JSpinner(new SpinnerNumberModel(0, 0, 5, 0.5));
        ratingSPNR.setLocation(ratingLBL.getX() + ratingLBL.getWidth(), ratingLBL.getY());
        ratingSPNR.setForeground(foreground);
        ratingSPNR.setSize(txtFieldSize);
        ratingSPNR.setFont(font);
        gamePNL.add(ratingSPNR);

        publisherFLD = new JTextField();
        publisherFLD.setLocation(publisherLBL.getX() + publisherLBL.getWidth(), publisherLBL.getY());
        publisherFLD.setForeground(foreground);
        publisherFLD.setSize(txtFieldSize);
        publisherFLD.setFont(font);
        gamePNL.add(publisherFLD);

        final Dimension buttonSize = new Dimension(200, 50);
        final JButton cancelBTN = new JButton("regresar");
        cancelBTN.setLocation(10, gamePNL.getPreferredSize().height - buttonSize.height - 10);
        cancelBTN.setForeground(foreground);
        cancelBTN.setSize(buttonSize);
        cancelBTN.setFont(font);
        gamePNL.add(cancelBTN);

        final JButton acceptBTN = new JButton("acceptar");
        acceptBTN.setLocation(gamePNL.getPreferredSize().width - buttonSize.width - 10, gamePNL.getPreferredSize().height - buttonSize.height - 10);
        acceptBTN.setForeground(foreground);
        acceptBTN.setSize(buttonSize);
        acceptBTN.setFont(font);
        gamePNL.add(acceptBTN);

        dialog = new JDialog((JFrame) null, true);
        dialog.add(gamePNL);
        dialog.pack();
        dialog.setLocationRelativeTo(null);

        cancelBTN.addActionListener(event -> {
            dialog.dispose();
        });

        acceptBTN.addActionListener(event -> {
            if (nameFLD.getText().isEmpty()) return ;
            boolean executed = false;

            if (game == null) {
                game = new Game();
                game.setName(nameFLD.getText());
                //We are getting the price value from the spinner, it returns an Object value, so we make it into a string, which then can be
                //use on the constructor of a BigDecimal.
                game.setPrice(new BigDecimal(Double.parseDouble(priceSPNR.getValue().toString()))); 
                game.setPublisher(publisherFLD.getText());
                game.setRating((int) Double.parseDouble(ratingSPNR.getValue().toString())); //Same logic as for the price.

                executed = sessionManager.insertEntity(game);
            } else {
                game.setName(nameFLD.getText());
                game.setPrice(new BigDecimal(priceSPNR.getValue().toString())); 
                game.setPublisher(publisherFLD.getText());
                game.setRating((int) Double.parseDouble(ratingSPNR.getValue().toString())); //Same logic as for the price.

                executed = sessionManager.saveEntity(game);
            }

            if (executed) {
                mainPanel.showElements(sessionManager);
                
                dialog.dispose();
            } else JOptionPane.showMessageDialog(null, "An error happened during execution.", "Query update: hibernate", JOptionPane.ERROR_MESSAGE);
            
        });
    }

    public void update(Game game) {
        if (game == null) {
            JOptionPane.showMessageDialog(null, "There was not any instance of the game at stock", "Query error: hibernate", JOptionPane.ERROR_MESSAGE);
            return;
        }

        nameFLD.setText(game.getName());
        priceSPNR.setValue(game.getPrice());
        ratingSPNR.setValue(game.getRating());
        publisherFLD.setText(game.getPublisher());
        this.game = game;

        dialog.setVisible(true);
    }

    public void insert() {
        game = null;
        nameFLD.setText("");
        priceSPNR.setValue(1200);
        ratingSPNR.setValue(0);
        publisherFLD.setText("");
        dialog.setVisible(true);
    }

    private final JTextField nameFLD;
    private final JSpinner priceSPNR;
    private final JSpinner ratingSPNR;
    private final JTextField publisherFLD;
}
