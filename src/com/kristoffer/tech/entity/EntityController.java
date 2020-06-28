package com.kristoffer.tech.entity;

import com.kristoffer.tech.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EntityController {
private Entity entity;
private boolean isPLayerOne;

    public EntityController(Entity entity, boolean isPLayerOne) {
        this.entity = entity;
        this.isPLayerOne = isPLayerOne;

        KeyStroke up;
        KeyStroke upRelease;
        boolean playerMoving;

        if(isPLayerOne){

             up = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0 , false);
             upRelease = KeyStroke.getKeyStroke(KeyEvent.VK_W, 0 , true);


        }

        else{
            up = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0 , false);
            upRelease = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0 , true);
            System.out.println("HOHO");

        }

        entity.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(up,"moveUp");
        entity.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upRelease,"moveUpRelease");
        entity.getActionMap().put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPLayerOne){

                    Panel.p1MovingUp = true;
                }
                else{
                    Panel.p2MovingUp = true;
                }
            }
        });
        entity.getActionMap().put("moveUpRelease", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isPLayerOne){
                    Panel.p1MovingUp = false;

                }
                else{
                    Panel.p2MovingUp = false;

                }
            }
        });


    }
}
