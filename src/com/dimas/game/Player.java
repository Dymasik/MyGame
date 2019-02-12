package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject{
    private Handler handler;
    private boolean immortal = false;

    public Player(float x, float y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;
    }

    public void update(){
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 38);
        y = Game.clamp(y, 0, Game.HEIGHT - 61);

        if(!immortal)
            colision();
    }

    private void colision(){
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempObj = handler.objects.get(i);

            if(tempObj.getId() == ID.BasicEnemy || tempObj.getId() == ID.FastEnemy || tempObj.getId() == ID.SmartEnemy){
                if(getBounds().intersects(tempObj.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
            if(tempObj.getId() == ID.EnemyBoss){
                if(getBounds().intersects(tempObj.getBounds())){
                    HUD.HEALTH -= 100;
                }
            }
            if(tempObj.getId() == ID.Sword){
                if(checkIntersect(tempObj))
                    HUD.HEALTH -= 5;
            }
        }
    }

    private boolean checkIntersect(GameObject sword){
        float ang = (float)(2 * Math.PI) - sword.getAngle();
        int len = (int)(Game.WIDTH / 1.5f);
        float x1 = Game.WIDTH / 2 + len * (float)Math.cos(ang);
        float x2 = Game.WIDTH / 2 + len * (float)Math.cos(ang) + 16 * (float)Math.sin(ang);
        float y1 = Game.HEIGHT / 2 - len * (float)Math.sin(ang);
        float y2 = Game.HEIGHT / 2 - len * (float)Math.sin(ang) + 16 * (float)Math.cos(ang);
        float x0 = Game.WIDTH / 2;
        float y0 = Game.HEIGHT / 2;

        //System.out.println("x1 y1 :: " + x1 + " " + y1);
        //System.out.println("x2 y2 :: " + x2 + " " + y2);

        if(((y1 - y0) * x + (x0 - x1) * y + y0 * (x1 - x0) + x0 * (y0 - y1)) * ((y1 - y0) * (x + 32) + (x0 - x1) * (y + 32) + y0 * (x1 - x0) + x0 * (y0 - y1)) < 0){
            x0 += (float)16 * Math.sin(ang);
            y0 += (float)16 * Math.cos(ang);
            if(((y2 - y0) * x + (x0 - x2) * y + y0 * (x2 - x0) + x0 * (y0 - y2)) * ((y2 - y0) * (x + 32) + (x0 - x2) * (y + 32) + y0 * (x2 - x0) + x0 * (y0 - y2)) < 0)
                return true;
        }
        return false;
    }

    public void render(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect((int)x, (int)y, 32, 32);
    }

    public void setImmortal(boolean immortal){
        this.immortal = immortal;
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32,32);
    }
}
