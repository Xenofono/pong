package tech.kristoffer.pong.moves;

import tech.kristoffer.pong.entity.Entity;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveDownRelease extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Entity) {
            Entity source = (Entity) e.getSource();
            source.setMovingDown(false);
        }
    }
}
