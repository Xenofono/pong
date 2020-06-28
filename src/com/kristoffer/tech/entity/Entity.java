package com.kristoffer.tech.entity;

import javax.swing.*;

public class Entity extends JLabel {

    private boolean movingUp, movingDown;

    public Entity(Icon image) {
        super(image);
    }

    public boolean isMovingUp() {
        return movingUp;
    }

    public void setMovingUp(boolean movingUp) {
        this.movingUp = movingUp;
    }

    public boolean isMovingDown() {
        return movingDown;
    }

    public void setMovingDown(boolean movingDown) {
        this.movingDown = movingDown;
    }

}
