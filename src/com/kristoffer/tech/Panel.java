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

    private JLabel p1, p2;
    public static   boolean p1MovingUp = false, p2MovingUp = false, p2MovingDown = false, p1MovingDown = false;
    private Timer timer;

    public Panel() throws IOException {
        this.setBackground(new Color(25, 255, 255));
        this.setLayout(null);
        BufferedImage image1 = ImageIO.read(new File("resources\\player1.png"));
        BufferedImage image2 = ImageIO.read(new File("resources\\player2.png"));
        p1 = new JLabel(new ImageIcon(image1));
        p2 = new JLabel(new ImageIcon(image2));

        Entity player1Test = new Entity(new ImageIcon(image1));
        Entity player2Test = new Entity(new ImageIcon(image2));
        int y = GameFrame.HEIGHT / 2 - image1.getHeight();
        p1.setLocation(40, y);
        p2.setLocation(GameFrame.WIDTH - 40 - image1.getWidth(), y);
        p1.setSize(image1.getWidth(), image1.getHeight());
        p2.setSize(image2.getWidth(), image2.getHeight());
        this.add(p1);
        this.add(p2);

        MoveUp moveUp = new MoveUp();
        MoveDown moveDown = new MoveDown();

        new EntityController(p1, true);
        new EntityController(p2, false);

        p1.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"),"moveDown");

        p2.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "moveDown");

        p1.getActionMap().put("moveDown", moveDown);
        p2.getActionMap().put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p2MovingUp = true;
            }
        });
        p2.getActionMap().put("moveUpRelease", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p2MovingUp = false;
            }
        });
        p2.getActionMap().put("moveDown",moveDown);

        timer = new Timer(16, (e) -> {
            if(p1MovingUp){
                if (p1.getLocation().y > 0){

                p1.setLocation(new Point(p1.getX(), p1.getY()-10));
                }
            }
            if(p2MovingUp){
                if (p2.getLocation().y > 0){
                p2.setLocation(new Point(p2.getX(), p2.getY()-10));

                }
            }

        });
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


    }

}
