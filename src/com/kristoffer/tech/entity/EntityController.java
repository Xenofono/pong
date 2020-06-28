package com.kristoffer.tech.entity;

import com.kristoffer.tech.Panel;
import com.kristoffer.tech.moves.MoveDown;
import com.kristoffer.tech.moves.MoveDownRelease;
import com.kristoffer.tech.moves.MoveUp;
import com.kristoffer.tech.moves.MoveUpRelease;

import javax.swing.*;

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

    public EntityController(Entity ball){

    }
}
