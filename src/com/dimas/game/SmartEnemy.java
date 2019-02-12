package com.dimas.game;

import java.awt.*;

public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject player;

    public  SmartEnemy(float x, float y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;
        for(int i = 0; i < handler.objects.size(); i++){
            if(handler.objects.get(i).getId() == ID.Player){
                player = handler.objects.get(i);
                break;
            }
        }
    }

    public void update() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float)Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = (float) ((-3.5 / distance) * diffX);
        velY = (float) ((-3.5 / distance) * diffY);

        velY *= Game.GameSpeed;
        velX *= Game.GameSpeed;

        if(x <= 0 || x >= Game.WIDTH - 20)
            velX *= -1;
        if(y <= 0 || y >= Game.HEIGHT - 40)
            velY *= -1;

        handler.addObject(new Trial((int)x, (int)y, ID.Trial, new Color(0,255,253),0.02f, handler));
    }

    public void render(Graphics g) {

        g.setColor(new Color(0, 255, 253));
        g.fillRect((int)x, (int)y, 16, 16);
        g.setColor(new Color(255, 255,255));
        g.drawRect((int)(x - 1) , (int)(y - 1), 17, 17);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void setImmortal(boolean immortal) {

    }
}
