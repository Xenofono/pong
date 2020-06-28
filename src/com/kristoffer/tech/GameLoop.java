package com.kristoffer.tech;

import com.kristoffer.tech.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiConsumer;

public class GameLoop extends Timer {

    private static final int PLAYER_SPEED = 10;



    public GameLoop(int delay, Entity player1, Entity player2, Entity ball) {
        super(delay, (e) -> {

            BiConsumer<Entity, Boolean> changeY = (player, up) -> {
                int direction = up ? -PLAYER_SPEED : PLAYER_SPEED;
                player.setLocation(new Point(player.getLocation().x, player.getLocation().y+direction));
            };

            if(player1.isMovingUp()){
                if (player1.getLocation().y > 0){
                    changeY.accept(player1, true);
                }
            }
            if(player2.isMovingUp()){
                if (player2.getLocation().y > 0){
                    changeY.accept(player2, true);

                }
            }
            if(player1.isMovingDown()){
                if (player1.getLocation().y < GameFrame.HEIGHT - player1.getHeight()){
                    changeY.accept(player1, false);
                }
            }
            if(player2.isMovingDown()){
                if (player2.getLocation().y < GameFrame.HEIGHT - player2.getHeight()){
                    changeY.accept(player2, false);

                }
            }

            ball.setLocation(new Point(ball.getLocation().x-10, ball.getLocation().y));
        });
    }

}
