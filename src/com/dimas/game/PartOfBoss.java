package com.dimas.game;

import java.awt.*;

public class PartOfBoss extends GameObject {

    private int timer = 71;

    public PartOfBoss(float x, float y, ID id, float velX, float velY){
        super(x, y, id);

        this.velX = velX;
        this.velY = velY;
    }

    public void update() {
        if(timer >= 0){
            x += velX;
            y += velY;
            timer--;
        }
    }

    public void render(Graphics g) {
        g.setColor(new Color(255, 0, 0));
        g.fillRect((int) x, (int) y, 64, 64);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 64, 64);
    }

    public void setImmortal(boolean immortal) {

    }
}
