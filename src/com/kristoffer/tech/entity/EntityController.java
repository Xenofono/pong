package com.kristoffer.tech.entity;

import com.kristoffer.tech.Panel;
import com.kristoffer.tech.moves.MoveDown;
import com.kristoffer.tech.moves.MoveDownRelease;
import com.kristoffer.tech.moves.MoveUp;
import com.kristoffer.tech.moves.MoveUpRelease;

import javax.swing.*;

/*
controller for the paddles, since swing cant track multiple KeyStrokes simultaneously this class uses 4 different
AbstractActions, 2 of the record button presses and flip a boolean to true, the others record button releases and
flip them back to false.

while the booleans are true the game loop will move entities
 */
public class EntityController {

    public EntityController(Entity entity, int up, int down) {

        KeyStroke upKey = KeyStroke.getKeyStroke(up, 0, false);
        KeyStroke upKeyRelease = KeyStroke.getKeyStroke(up, 0, true);
        KeyStroke downKey = KeyStroke.getKeyStroke(down, 0, false);
        KeyStroke downKeyRelease = KeyStroke.getKeyStroke(down, 0, true);

        AbstractAction moveUp = new MoveUp();
        AbstractAction moveUpRelease = new MoveUpRelease();
        AbstractAction moveDown = new MoveDown();
        AbstractAction moveDownRelease = new MoveDownRelease();


        entity.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upKey,"moveUp");
        entity.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upKeyRelease,"moveUpRelease");
        entity.getActionMap().put("moveUp", moveUp);
        entity.getActionMap().put("moveUpRelease", moveUpRelease);

        entity.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downKey,"moveDown");
        entity.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downKeyRelease,"moveDownRelease");
        entity.getActionMap().put("moveDown", moveDown);
        entity.getActionMap().put("moveDownRelease", moveDownRelease);

    }

}
