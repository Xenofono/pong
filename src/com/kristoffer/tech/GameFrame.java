package com.kristoffer.tech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;

public class GameFrame extends JFrame {

    public static int WIDTH = 1280;
    public static int HEIGHT = 860;


    public GameFrame() throws HeadlessException, IOException {
        this.setTitle("Pong game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        this.setContentPane(panel);
        panel.setOpaque(true);
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setVisible(true);
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                WIDTH = e.getComponent().getWidth();
                HEIGHT = e.getComponent().getHeight();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }




}
