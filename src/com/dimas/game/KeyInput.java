package com.dimas.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    private long lastSpacePressed = System.currentTimeMillis();

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempObj = handler.objects.get(i);

            if(tempObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    tempObj.setVelY(-5);
                }
                if (key == KeyEvent.VK_S) {
                    tempObj.setVelY(5);
                }
                if (key == KeyEvent.VK_A) {
                    tempObj.setVelX(-5);
                }
                if (key == KeyEvent.VK_D) {
                    tempObj.setVelX(5);
                }
                if(key == KeyEvent.VK_SPACE && System.currentTimeMillis() - lastSpacePressed >= 2000){
                    long timer = System.currentTimeMillis();
                    lastSpacePressed = timer;
                    tempObj.setVelX(tempObj.getVelX() * 4);
                    tempObj.setVelY(tempObj.getVelY() * 4);
                    tempObj.setImmortal(true);
                    while(System.currentTimeMillis() - timer < 300){}
                    tempObj.setVelX(tempObj.getVelX() / 4);
                    tempObj.setVelY(tempObj.getVelY() / 4);
                    tempObj.setImmortal(false);
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE){
            if(Game.isPaused)Game.isPaused = false;
            else
                Game.isPaused = true;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempObj = handler.objects.get(i);
            if(tempObj.getId() == ID.Player) {
                if (key == KeyEvent.VK_W && tempObj.getVelY() == -5) {
                    tempObj.setVelY(0);
                }
                if (key == KeyEvent.VK_S && tempObj.getVelY() == 5) {
                    tempObj.setVelY(0);
                }
                if (key == KeyEvent.VK_A && tempObj.getVelX() == -5) {
                    tempObj.setVelX(0);
                }
                if (key == KeyEvent.VK_D && tempObj.getVelX() == 5) {
                    tempObj.setVelX(0);
                }
            }
        }
    }
}
