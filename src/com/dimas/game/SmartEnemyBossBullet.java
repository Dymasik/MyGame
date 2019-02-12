package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class SmartEnemyBossBullet extends GameObject {
    private Handler handler;
    private GameObject player;
    private int live = 5;


    public  SmartEnemyBossBullet(float x, float y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;
        for(int i = 0; i < handler.objects.size(); i++){
            if(handler.objects.get(i).getId() == ID.Player){
                this.player = handler.objects.get(i);
                break;
            }
        }

        initializeVel();
    }

    private void initializeVel(){
        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float)Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = (float) ((-7.0 / distance) * diffX) * Game.GameSpeed;
        velY = (float) ((-7.0 / distance) * diffY) * Game.GameSpeed;
        if(player.getVelX() > 0)
            velX += 3.0f * Game.GameSpeed;
        else if(player.getVelX() < 0)
            velX -= 3.0f * Game.GameSpeed;
        if(player.getVelY() > 0)
            velY += 3.0f * Game.GameSpeed;
        else if(player.getVelY() < 0)
            velY -= 3.0f * Game.GameSpeed;
    }

    public void update() {
        x += velX;
        y += velY;


        if(y >= Game.HEIGHT || y < 0 || x >= Game.WIDTH || x < 0)handler.removeObject(this);

        //handler.addObject(new Trial((int)x, (int)y, ID.Trial, new Color(255,0,0),0.02f, handler));
    }

    public void render(Graphics g) {

        g.setColor(new Color(107, 255, 243));
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
