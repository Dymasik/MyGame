package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class SmartBoss extends GameObject {
    private Handler handler;
    private int timer = 75;
    private int timerForBullet = 30;
    private GameObject player;
    private Random r;

    public  SmartBoss(float x, float y, ID id, Handler handler){
        super(x, y, id);
        r = new Random();

        velX = 0;
        velY = 0;
        this.handler = handler;
        for(int i = 0; i < handler.objects.size(); i++){
            if(handler.objects.get(i).getId() == ID.Player){
                this.player = handler.objects.get(i);
                break;
            }
        }
    }

    public void update() {
/*
        if(player.getY() <= 128){
            float alpha = (x - player.getX()) / Math.abs(x - player.getX());
            velX = alpha * -15.0f;
        }
*/
        if(timer > 0)
            timer--;
        else {
            if (timerForBullet > 0) timerForBullet--;
            if (timerForBullet <= 0) {
                int spawn = r.nextInt(10);
                if (spawn == 0)
                    handler.addObject(new SmartEnemyBossBullet(x + 64, y + 64, ID.BasicEnemy, handler));
            }
        }



        //handler.addObject(new Trial((int)x, (int)y, ID.Trial, new Color(255,0,0),0.02f, handler));
    }

    public void render(Graphics g) {
        if(timer <= 0) {
            g.setColor(new Color(255, 0, 0));
            g.fillRect((int) x, (int) y, 128, 128);
            g.setColor(new Color(255, 255, 255));
            g.drawRect((int) x - 1, (int) y - 1, 129, 129);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 128, 128);
    }

    public void setImmortal(boolean immortal) {

    }
}
