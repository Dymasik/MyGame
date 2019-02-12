package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class MainBoss extends GameObject {
    private Handler handler;
    private int timer = 200;
    private int timer2 = 600;
    private int timer3 = 200;
    private Random r;

    public  MainBoss(float x, float y, ID id, Handler handler){
        super(x, y, id);
        r = new Random();

        velX = 0;
        velY = 0;
        this.handler = handler;
    }

    public void update() {
        if(timer == 0) {
            handler.addObject(new Sword(-200, 360, ID.Sword, 0));
            timer--;
        }
        else if(timer > 0)
            timer--;

        if(timer < 0){
            if(timer2 == 0) {
                handler.addObject(new Sword(-200, 360, ID.Sword, 0));
                timer2--;
            }else if(timer2 > 0)
                timer2--;
        }

        if(timer2 < 0){
            if(timer3 == 0) {
                handler.addObject(new Sword(-200, 360, ID.Sword, 0));
                timer3--;
            }else if(timer3 > 0)
                timer3--;
        }

        if(timer3 < 0){
            int spawn = r.nextInt(20);
            if(spawn == 0){
                handler.addObject(new MainBossBullet(x + 64, y + 64, ID.BasicEnemy, handler));
            }
        }

    }

    public void render(Graphics g) {

        if(timer - 100 > 0){
            g = g.create();

            if(timer % 3 == 0){
                g.setColor(Color.BLACK);
                g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
            }else{
                g.setColor(Color.BLUE);
                g.fillRect(0,0, Game.WIDTH, Game.HEIGHT);
            }
            g.setColor(Color.ORANGE);
            Font fnt = new Font("arial", 1, 40);
            g.setFont(fnt);
            g.drawString("Are you ready?", 350, 340);
        }else {
            g.setColor(new Color(255, 148, 0));
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
