package com.kristoffer.tech;

import com.kristoffer.tech.entity.Entity;
import com.kristoffer.tech.entity.EntityController;
import com.kristoffer.tech.moves.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private Timer timer;


    public Panel() throws IOException {
        this.setBackground(new Color(25, 255, 255));
        this.setLayout(null);
        BufferedImage image1 = ImageIO.read(new File("resources\\player1.png"));
        BufferedImage image2 = ImageIO.read(new File("resources\\player2.png"));
        BufferedImage image3 = ImageIO.read(new File("resources\\ball.png"));

        Entity player1 = new Entity(new ImageIcon(image1));
        Entity player2 = new Entity(new ImageIcon(image2));
        Entity ball = new Entity(new ImageIcon(image3));
        int y = GameFrame.HEIGHT / 2 - image1.getHeight()/2;
        player1.setLocation(40, y);
        player2.setLocation(GameFrame.WIDTH - 40 - image1.getWidth(), y);
        player1.setSize(image1.getWidth(), image1.getHeight());
        player2.setSize(image2.getWidth(), image2.getHeight());
        ball.setLocation(GameFrame.WIDTH/2, GameFrame.HEIGHT/2);
        ball.setSize(image3.getWidth(), image3.getHeight());
        this.add(player1);
        this.add(player2);
        this.add(ball);

        JLabel score = new JLabel();
        score.setSize(200, 200);
        score.setLocation(GameFrame.WIDTH/2-score.getWidth()/2, 100);
        score.setFont(score.getFont().deriveFont(64f));
        this.add(score);


        new EntityController(player1, KeyEvent.VK_W, KeyEvent.VK_S);
        new EntityController(player2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);




        timer = new GameLoop(17, player1, player2, ball, score);
        timer.start();
    }




}
