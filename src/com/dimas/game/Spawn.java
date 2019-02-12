package com.dimas.game;

import java.awt.*;
import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    Random r = new Random();

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void update(){
        scoreKeep++;

        if(scoreKeep >= 250){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if(hud.getLevel() % 33 == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() % 40 == 3){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() % 40 <= 6){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }else if(hud.getLevel() % 40 == 7){
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            }else if(hud.getLevel() % 40 == 10){
                handler.clear();
                handler.addObject(new EnemyBoss((int)(Game.WIDTH / 2 - 50), (int)-100, ID.EnemyBoss, handler));
            }else if(hud.getLevel() % 40 == 14){
                handler.clear();
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() % 40 == 15){
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }else if(hud.getLevel() % 40 == 16){
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            }else if(hud.getLevel() % 40 == 18){
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }else if(hud.getLevel() % 40 == 20){
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() % 40 == 21){
                handler.clear();
                handler.addObject(new PartOfBoss(-64, -64, ID.EnemyBoss, 7.5f, 5.0f));
                handler.addObject(new PartOfBoss(Game.WIDTH, -64, ID.EnemyBoss, -7.5f, 5.0f));
                handler.addObject(new PartOfBoss(-64, Game.HEIGHT, ID.EnemyBoss, 7.5f, -5.0f));
                handler.addObject(new PartOfBoss(Game.WIDTH, Game.HEIGHT, ID.EnemyBoss, -7.5f, -5.0f));
                //handler.clear();
                handler.addObject(new SmartBoss(Game.WIDTH / 2 - 64, Game.HEIGHT / 2 - 64, ID.EnemyBoss, handler));
            }else if(hud.getLevel() % 40 == 25){
                handler.clear();
                handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler));
            }else if(hud.getLevel() % 40 == 26){
                handler.addObject(new BlinkEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new RandomEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() % 40 == 27){
                handler.addObject(new BlinkEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new BlinkEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }else if(hud.getLevel() % 40 == 29){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }else if(hud.getLevel() % 40 == 30){
                handler.addObject(new BlinkEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
            }else if(hud.getLevel() % 40 == 33) {
                handler.clear();
                handler.addObject(new MainBoss(Game.WIDTH / 2 - 64, Game.HEIGHT / 2 - 64, ID.EnemyBoss, handler));
            }else if(hud.getLevel() % 40 == 0){
                handler.clear();
                Game.GameSpeed *= 1.4f;
            }
        }
    }

    public void render(Graphics g){

    }
}
