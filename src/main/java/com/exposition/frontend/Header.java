package com.exposition.frontend;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Header extends JPanel{
    private final String SEARCH_BAR_DEFAULT_TEXT = "ID/Name of the game"; 
    private final Font SYSTEM_FONT = new Font("Roboto", Font.PLAIN, 30);
    private final Color FOCUSED_SEARCH_BAR = Color.BLACK;
    private final Color UNFOCUSED_SEARCH_BAR = Color.DARK_GRAY;


    public Header(Dimension headerSize) {
        setSize(headerSize);
        setOpaque(false);
        setLayout(null);

        final int headerHeight = headerSize.height;
        final JButton searchBTN = new JButton();
        searchBTN.setSize(headerHeight, headerHeight);
        add(searchBTN);

        final JTextField searchFLD = new JTextField(SEARCH_BAR_DEFAULT_TEXT);
        searchFLD.setSize((int) (headerSize.width * 0.4), headerHeight);
        searchFLD.setForeground(UNFOCUSED_SEARCH_BAR);
        searchFLD.setBackground(getBackground());
        searchFLD.setLocation(headerHeight + 15, 0);
        searchFLD.setFont(SYSTEM_FONT);
        searchFLD.setOpaque(false);
        searchFLD.setBorder(null);
        add(searchFLD);
        
        final JSeparator searchLine = new JSeparator(JSeparator.HORIZONTAL);
        searchLine.setLocation(searchFLD.getX(), (int) (headerHeight * 0.80));
        searchLine.setSize(searchFLD.getWidth(), 10);
        searchLine.setBackground(UNFOCUSED_SEARCH_BAR);
        add(searchLine);

        final JButton ingredientBTN = new JButton("Add game");
        ingredientBTN.setSize((int) (headerSize.width * 0.25), headerHeight);
        ingredientBTN.setLocation(headerSize.width - ingredientBTN.getWidth(), 0);       
        ingredientBTN.setFont(SYSTEM_FONT);
        add(ingredientBTN);

        searchBTN.addActionListener(event -> {
            String product = searchFLD.getText();
            if (product.equals(SEARCH_BAR_DEFAULT_TEXT) || product.isBlank()) return;

            if (isNumericOnly(product)) {

            } else {

            }
        });

        searchFLD.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchFLD.getText().equals(SEARCH_BAR_DEFAULT_TEXT)) {
                    searchFLD.setText("");
                    searchFLD.setForeground(FOCUSED_SEARCH_BAR);
                    searchLine.setForeground(FOCUSED_SEARCH_BAR);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchFLD.getText().isBlank()) {
                    searchFLD.setText(SEARCH_BAR_DEFAULT_TEXT);
                    searchFLD.setForeground(UNFOCUSED_SEARCH_BAR);
                    searchLine.setForeground(UNFOCUSED_SEARCH_BAR);
                }
            }
            
        });

        ingredientBTN.addActionListener(event -> {

        });

    }

    //checks if the string contains only numbers.
    private boolean isNumericOnly(String text) {
        for (final char character : text.toCharArray()) {
            if (!Character.isDigit(character)) return false;
        }

        return true;
    }    

}
