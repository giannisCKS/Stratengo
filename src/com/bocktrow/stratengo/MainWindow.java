package com.bocktrow.stratengo;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public MainWindow() {
        super("Stratengo");
        setSize(new Dimension(900, 900));
        setResizable(false);
        setLayout(new GridLayout(8, 10));

        for (int i = 1; i <= 80; i++) {

            ImageIcon icon = createImageIcon("asset/bluePieces/elfB.png", "elfB");
            Image sized = icon.getImage().getScaledInstance(900 / 10, 900 / 8, Image.SCALE_SMOOTH);
            ImageIcon resized = new ImageIcon(sized);
            final JButton jButton = new JButton(resized);
            jButton.setBackground(Color.WHITE);
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN));
                }
            });


            if (i == 33 || i == 34 || i == 43 || i == 44 || i == 37 || i == 38 || i == 47 || i == 48) jButton.setEnabled(false);

            add(jButton);

        }
    }

    public static void main(String[] args) {
        new MainWindow().setVisible(true);
    }

    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}

