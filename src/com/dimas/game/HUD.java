package com.dimas.game;

import java.awt.*;

public class HUD {
    static float HEALTH = 100;
    private float greenValue = 255;
    private int level = 1;
    private int score = 0;
    private Handler handler;
    private Player player;

    public HUD(Handler handler){
        this.handler = handler;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    void update(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = HEALTH * 2;

        score++;
    }

    void render(Graphics g){
        if(player == null){
            return;
        }
        if (player.getX() + 32> Game.WIDTH / 2 - 200 && player.getX() < Game.WIDTH / 2 + 200 && player.getY() + 32 > Game.HEIGHT - 75) {
            g.setColor(Color.GRAY);
            g.fillRect(Game.WIDTH / 2 - 200, 35, 400, 25);
            g.setColor(new Color(75, (int) greenValue, 0));
            g.fillRect(Game.WIDTH / 2 - 200, 35, (int) HEALTH * 4, 25);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(Game.WIDTH / 2 - 200, Game.HEIGHT - 75, 400, 25);
            g.setColor(new Color(75, (int) greenValue, 0));
            g.fillRect(Game.WIDTH / 2 - 200, Game.HEIGHT - 75, (int) HEALTH * 4, 25);
        }


        g.drawString("Obj: " + handler.objects.size(), 15, 55);
        g.drawString("Score: " + score, 15, 15);
        g.drawString("Level: " + level, 15, 35);
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
