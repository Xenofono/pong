package com.kristoffer.tech;

import com.kristoffer.tech.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameLoop extends Timer {

    private Entity player1, player2;


    public GameLoop(int delay, Entity player1, Entity player2) {
        super(delay, (e) -> {
            if(player1.isMovingUp()){
                if (player1.getLocation().y > 0){
                    player1.setLocation(new Point(player1.getLocation().x, player1.getLocation().y-10));
                }
            }
            if(player2.isMovingUp()){
                if (player2.getLocation().y > 0){
                    player2.setLocation(new Point(player2.getLocation().x, player2.getLocation().y-10));

                }
            }
        });
        this.player1 = player1;
        this.player2 = player2;
    }
}
