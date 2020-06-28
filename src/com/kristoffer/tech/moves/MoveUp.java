package com.kristoffer.tech.moves;

import com.kristoffer.tech.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MoveUp extends AbstractAction {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof Entity){
            Entity source = (Entity) e.getSource();
            source.setMovingUp(true);

        }
    }
}
