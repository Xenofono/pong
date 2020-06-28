package com.kristoffer.tech.moves;

import com.kristoffer.tech.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MoveDown extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        new Thread(() -> {
            if (e.getSource() instanceof JLabel) {
                JLabel source = (JLabel) e.getSource();

                if (source.getLocation().y < GameFrame.HEIGHT-source.getIcon().getIconHeight()) {
                    source.setLocation(new Point(source.getX(), source.getY()+10));

                }
            }
        }).start();

    }
}
