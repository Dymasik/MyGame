package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
    private Handler handler;
    private Random r;

    public  EnemyBossBullet(float x, float y, ID id, Handler handler){
        super(x, y, id);
        r = new Random();

        velX = (r.nextInt(5 - -5) + -5) * Game.GameSpeed;
        velY = 5 * Game.GameSpeed;
        this.handler = handler;
    }

    public void update() {
        x += velX;
        y += velY;

        if(y >= Game.HEIGHT)handler.removeObject(this);

        handler.addObject(new Trial((int)x, (int)y, ID.Trial, new Color(255,0,0),0.02f, handler));
    }

    public void render(Graphics g) {

        g.setColor(new Color(255, 0, 0));
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
