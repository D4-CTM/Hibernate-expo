package com.exposition.frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class GameDialog {
    private final Font font = new Font("Roboto", Font.PLAIN, 30);
    private final Color background = Color.LIGHT_GRAY;
    private final Color foreground = Color.BLACK;
    private final JDialog dialog;

    public GameDialog() {
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

        final JLabel publisherLBL = new JLabel("Rating: ",JLabel.RIGHT);
        publisherLBL.setForeground(foreground);
        publisherLBL.setLocation(10, ratingLBL.getY() + ratingLBL.getHeight() + 10);
        publisherLBL.setSize(labelSize);
        publisherLBL.setFont(font);
        gamePNL.add(publisherLBL);

        final Dimension txtFieldSize = new Dimension(300, 50);
        final JTextField nameFLD = new JTextField();
        nameFLD.setLocation(nameLBL.getX() + nameLBL.getWidth(), nameLBL.getY());
        nameFLD.setForeground(foreground);
        nameFLD.setSize(txtFieldSize);
        nameFLD.setFont(font);
        gamePNL.add(nameFLD);

        final JSpinner priceSPNR = new JSpinner(new SpinnerNumberModel(1200.00, 100.00, 2500.00, 100.00));
        priceSPNR.setLocation(priceLBL.getX() + priceLBL.getWidth(), priceLBL.getY());
        priceSPNR.setForeground(foreground);
        priceSPNR.setSize(txtFieldSize);
        priceSPNR.setFont(font);
        gamePNL.add(priceSPNR);

        final JTextField ratingFLD = new JTextField();
        ratingFLD.setLocation(ratingLBL.getX() + ratingLBL.getWidth(), ratingLBL.getY());
        ratingFLD.setForeground(foreground);
        ratingFLD.setSize(txtFieldSize);
        ratingFLD.setFont(font);
        gamePNL.add(ratingFLD);

        final JTextField publisherFLD = new JTextField();
        publisherFLD.setLocation(publisherLBL.getX() + publisherLBL.getWidth(), publisherLBL.getY());
        publisherFLD.setForeground(foreground);
        publisherFLD.setSize(txtFieldSize);
        publisherFLD.setFont(font);
        gamePNL.add(publisherFLD);

        final JButton cancelBTN = new JButton("regresar");
        cancelBTN.setLocation(10, gamePNL.getHeight() - labelSize.height - 10);
        cancelBTN.setForeground(foreground);
        cancelBTN.setSize(labelSize);
        cancelBTN.setFont(font);
        gamePNL.add(cancelBTN);

        final JButton acceptBTN = new JButton("regresar");
        acceptBTN.setLocation(gamePNL.getWidth() - labelSize.width - 10, gamePNL.getHeight() - labelSize.height - 10);
        acceptBTN.setForeground(foreground);
        acceptBTN.setSize(labelSize);
        acceptBTN.setFont(font);
        gamePNL.add(acceptBTN);

        dialog = new JDialog((JFrame) null, true);
        dialog.add(gamePNL);
        dialog.pack();

        cancelBTN.addActionListener(event -> {
            dialog.dispose();
        });

        acceptBTN.addActionListener(event -> {

            dialog.dispose();
        });
    }

}
