package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class RandomEnemy extends GameObject{
    private Handler handler;
    private Random r = new Random();

    public  RandomEnemy(float x, float y, ID id, Handler handler){
        super(x, y, id);

        velX = (r.nextInt(6 - -6)) * Game.GameSpeed;
        velY = (r.nextInt(6 - -6)) * Game.GameSpeed;
        if(velX >= 0)
            velX += 6 * Game.GameSpeed;
        else
            velX -= 6 * Game.GameSpeed;
        if(velY >= 0)
            velY += 6 * Game.GameSpeed;
        else
            velY -= 6 * Game.GameSpeed;
        this.handler = handler;
    }

    public void update() {
        x += velX;
        y += velY;

        if(x <= 0 || x >= Game.WIDTH - 20)
            velX *= -1;
        if(y <= 0 || y >= Game.HEIGHT - 40)
            velY *= -1;

        handler.addObject(new Trial((int)x, (int)y, ID.Trial, new Color(210,100,255),0.02f, handler));
    }

    public void render(Graphics g) {

        g.setColor(new Color(210, 100, 255));
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
