package com.kristoffer.tech;

import com.kristoffer.tech.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.function.BiConsumer;

/*
main loop for the game, it extends the swing timer, second argument in the super call is an ActionListener that is
run after each delay
 */
public class GameLoop extends Timer {

    //static variables so they can be accessed from the constructor
    private static final int PLAYER_SPEED = 8;
    private static  int BALL_SPEED = 7;
    private static final double PADDLE_SPIN = 8;
    private static double offset = 0   ;
    private static int player1Score = 0;
    private static int player2Score = 0;
    private static boolean hasScored;


    public GameLoop(int delay, Entity player1, Entity player2, Entity ball, JLabel score) {
        super(delay, (e) -> {

            if(score.getText().isEmpty() || hasScored){
                String scoreText = player1Score + " - " + player2Score;
                score.setText(scoreText);
                hasScored = false;
            }
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
                if (player1.getLocation().y+player1.getHeight() < GameFrame.HEIGHT){
                    changeY.accept(player1, false);
                }
            }
            if(player2.isMovingDown()){
                if (player2.getLocation().y < GameFrame.HEIGHT - player2.getHeight()){
                    changeY.accept(player2, false);

                }
            }

            //get current entity areas
            Area ballArea = new Area(ball.getBounds());
            Area player1Area = new Area(player1.getBounds());
            Area player2Area = new Area(player2.getBounds());

            //check if areas intersect, if yes then there is a collision
            if(ballArea.intersects(player1Area.getBounds2D())){
                offset = (double) (player1.getYCenter()-ball.getYCenter()) / player1.getHeight();
                System.out.println(offset);
                BALL_SPEED = -BALL_SPEED;
            }
            else if ( ballArea.intersects(player2Area.getBounds2D())){
                offset = (double) (player2.getYCenter()-ball.getYCenter()) / player2.getHeight();
                System.out.println(offset);
                BALL_SPEED = -BALL_SPEED;
            }
                int angle = (int) (PADDLE_SPIN* -offset);
                ball.setLocation(new Point(ball.getLocation().x-BALL_SPEED, ball.getLocation().y+angle));


            //if ball is outside right side, player1 score
            if( ball.getX() > GameFrame.WIDTH +100){
                ball.setLocation(GameFrame.WIDTH/2, GameFrame.HEIGHT/2);
                player1Score++;
                hasScored = true;
                offset = 0;
            }else if (ball.getX() < -100){
                ball.setLocation(GameFrame.WIDTH/2, GameFrame.HEIGHT/2);
                player2Score++;
                hasScored = true;
                offset = 0;
            }

            //if ball reaches roof or ceiling, reverse y direction but maintain x (bounce)
            if(ball.getY() <= 0 || ball.getY()+ball.getHeight() >= GameFrame.HEIGHT){
                offset = -offset;
            }
        });
    }


}
