package com.kristoffer.tech.moves;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MoveUp extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof  JLabel){
            JLabel source = (JLabel) e.getSource();

                if (source.getLocation().y > 0){
                source.setLocation(new Point(source.getX(), source.getY()-10));

                }

        }
    }
}
