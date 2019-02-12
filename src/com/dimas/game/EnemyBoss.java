package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class EnemyBoss extends GameObject {
    private Handler handler;
    private int timer = 20;
    private int timerForBullet = 10;
    private GameObject player;
    private Random r;

    public  EnemyBoss(float x, float y, ID id, Handler handler){
        super(x, y, id);
        r = new Random();

        velX = 0;
        velY = 5 * Game.GameSpeed;
        this.handler = handler;
        for(int i = 0; i < handler.objects.size(); i++){
            if(handler.objects.get(i).getId() == ID.Player){
                this.player = handler.objects.get(i);
                break;
            }
        }
    }

    public void update() {
        x += velX;
        y += velY;

        if(timer >= 0)
            timer--;
        else{
            velY = 0;
            //handler.addObject(new BasicEnemy((int)(x + 50), (int)(y + 50), ID.BasicEnemy, handler));
        }

        if(player.getY() <= 128){
            float alpha = (x - player.getX()) / Math.abs(x - player.getX());
            velX = alpha * -15.0f;
        }

        if(timer <= 0)timerForBullet--;
        if(timerForBullet <= 0){
            if(velX == 0)
                velX = 2 * Game.GameSpeed;
            if(velX > 0)velX += 0.005f;
            if(velX < 0)velX -= 0.005f;
            velX = Game.clamp(velX, -10, 10);
            int spawn = r.nextInt(10);
            if(spawn == 0)handler.addObject(new EnemyBossBullet(x + 50, y + 50, ID.BasicEnemy, handler));
        }

        if(x <= 0 || x >= Game.WIDTH - 100)
            velX *= -1;


        //handler.addObject(new Trial((int)x, (int)y, ID.Trial, new Color(255,0,0),0.02f, handler));
    }

    public void render(Graphics g) {

        g.setColor(new Color(255, 0, 0));
        g.fillRect((int)x, (int)y, 128, 128);
        g.setColor(new Color(255, 255,255));
        g.drawRect((int)x - 1 , (int)y - 1, 129, 129);
    }

    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 128, 128);
    }

    public void setImmortal(boolean immortal) {

    }
}
