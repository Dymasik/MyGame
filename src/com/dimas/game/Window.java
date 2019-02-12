package com.dimas.game;
import org.lwjgl.openal.AL;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class Window extends Canvas{
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        //frame.setFocusable(true);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                AL.destroy();
                System.exit(0);
            }
        });
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        game.setFocusable(true);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}
