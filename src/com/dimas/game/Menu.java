package com.dimas.game;

import org.lwjgl.openal.AL;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    private boolean isDirect[];

    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        isDirect = new boolean[]{false, false, false};
    }

    public void update(){

    }

    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu) {

            Font fnt = new Font("arial", 1, 50);

            g.setColor(Color.white);
            g.setFont(fnt);
            g.drawString("NAME", 450, 100);

            Font fntForText = new Font("arial", 1, 30);

            g.setFont(fntForText);

            if(!isDirect[0]) {
                //g.setColor(Color.BLUE);
                //g.drawRect(850, 400, 200, 40);
                //g.setColor(Color.white);
                g.drawString("Play", 875, 430);
            }else{
                g.setColor(Color.GRAY);
                g.fillRect(0, 400, 1080, 40);
                g.setColor(Color.white);
                g.drawString("Play", 875, 430);
            }

            if(!isDirect[1]) {
                //g.drawRect(850, 465, 200, 40);
                g.drawString("Help", 875, 495);
            }else{
                g.setColor(Color.GRAY);
                g.fillRect(0, 465, 1080, 40);
                g.setColor(Color.white);
                g.drawString("Help", 875, 495);
            }

            if(!isDirect[2]) {
                //g.drawRect(850, 530, 200, 40);
                g.drawString("Exit", 875, 560);
            }else{
                g.setColor(Color.GRAY);
                g.fillRect(0, 530, 1080, 40);
                g.setColor(Color.white);
                g.drawString("Exit", 875, 560);
            }
        }else if(game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);

            g.setColor(Color.white);
            g.setFont(fnt);
            g.drawString("HELP", 450, 100);

            g.setFont(new Font("arial", 1, 40));
            g.drawString("Use WASD and SPACE to win!", 250, 350);

            g.drawRect(325, 550, 400, 50);
            g.drawString("Back", 470, 590);
        }else if(game.gameState == Game.STATE.GameOver){
            Font fnt = new Font("arial", 1, 50);

            g.setColor(Color.white);
            g.setFont(fnt);
            g.drawString("Game Over", 380, 100);

            g.setFont(new Font("arial", 1, 40));
            g.drawString("You lost with a score: " + hud.getScore(), 300, 350);

            g.drawRect(325, 550, 400, 50);
            g.drawString("Try again", 430, 590);
        }

    }

    public void mouseMoved(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //System.out.println(mx + " " + my);

        if(game.gameState == Game.STATE.Menu){


            if (mouseOver(mx, my, 850, 400, 200, 40)) {
                isDirect[0] = true;
            }else if(mouseOver(mx, my, 850, 465, 200, 40)){
                isDirect[1] = true;
            }else if(mouseOver(mx, my, 850, 530, 200, 40)){
                isDirect[2] = true;
            }else{
                isDirect[0] = false;
                isDirect[1] = false;
                isDirect[2] = false;
            }
        }
    }


    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == Game.STATE.Menu) {

            //Play
            if (mouseOver(mx, my, 850, 400, 200, 40)) {
                game.gameState = Game.STATE.Game;
                handler.clear();
                Player player = new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler);
                handler.addObject(player);
                hud.setPlayer(player);
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
            }

            //Help
            if (mouseOver(mx, my, 850, 465, 200, 40)) {
                game.gameState = Game.STATE.Help;
            }

            //Exit
            if (mouseOver(mx, my, 850, 530, 200, 40)) {
                AL.destroy();
                System.exit(1);
            }
        }else if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 325, 550, 400, 50))
                game.gameState = Game.STATE.Menu;
        }else if(game.gameState == Game.STATE.GameOver){
            if(mouseOver(mx, my, 325, 550, 400, 50)) {
                game.gameState = Game.STATE.Menu;
                hud.setLevel(1);
                hud.setScore(0);

            }
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height)
                return true;
        }
        return false;
    }
}
