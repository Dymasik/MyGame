package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class MenuObject extends GameObject {
    private Handler handler;
    private Random r = new Random();
    private Color color;

    public  MenuObject(float x, float y, ID id, Handler handler){
        super(x, y, id);

        velX = r.nextInt(5 - -5) + -5;
        velY = r.nextInt(5 - -5) + -5;
        this.handler = handler;
        color = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }

    public void update() {
        x += velX;
        y += velY;

        if(x <= 0 || x >= Game.WIDTH - 20)
            velX *= -1;
        if(y <= 0 || y >= Game.HEIGHT - 40)
            velY *= -1;

        handler.addObject(new Trial((int)x, (int)y, ID.Trial, color,0.02f, handler));
    }

    public void render(Graphics g) {

        g.setColor(color);
        g.fillRect((int)x, (int)y, 16, 16);
        g.setColor(new Color(255, 255,255));
        g.drawRect((int)x - 1 , (int)y - 1, 17, 17);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void setImmortal(boolean immortal) {

    }
}
