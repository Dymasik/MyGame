package com.dimas.game;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;

    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Player player;

    public enum STATE{
        Menu,
        Help,
        GameOver,
        Game;
    }

    Random r;
    public static STATE gameState = STATE.Menu;
    public static boolean isPaused = false;
    public static boolean deletePlayer = false;
    public static float GameSpeed = 1.0f;

    Menu menu;

    public Game(){
        handler = new Handler();
        hud = new HUD(handler);
        menu = new Menu(this, handler, hud);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);
        this.addMouseMotionListener(menu);

        AudioPlayer.load();
        AudioPlayer.getMusic("music").loop();

        new Window(WIDTH, HEIGHT, "DimasGame", this);

        spawner = new Spawn(handler, hud);

        r = new Random();


        for(int i = 0; i < 20; i++){
            handler.addObject(new MenuObject(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuObject, handler));
        }

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        long timeForFps = System.currentTimeMillis();
        int frames = 0;

        while(running){
            if (System.currentTimeMillis() - timeForFps >= 16) {
                timeForFps += 16;
                long now = System.nanoTime();

                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1) {
                    update();
                    delta--;
                }
                if (running)
                    render();
                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    //System.out.println("FPS: " + frames);
                    frames = 0;
                }
            }
        }
        stop();
    }


    public void update(){

        if(gameState == STATE.Game) {
            if(!isPaused) {
                handler.update();
                hud.update();
                spawner.update();

                if (HUD.HEALTH <= 0) {
                    deletePlayer = true;
                    handler.clear();
                    deletePlayer = false;
                    gameState = STATE.GameOver;
                    HUD.HEALTH = 100;
                    for (int i = 0; i < 20; i++) {
                        handler.addObject(new MenuObject(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuObject, handler));
                    }
                }
            }
        }else if(gameState == STATE.Menu || gameState == STATE.GameOver || gameState == STATE.Help){
            handler.update();
            menu.update();
        }
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        if(gameState == STATE.Game) {
            hud.render(g);
        }
        else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.GameOver){
            menu.render(g);
        }

        g.dispose();
        bs.show();

    }

    public static float clamp(float val, float min, float max){
        if(val > max)
            return max;
        if(val < min)
            return min;
        return val;
    }

    public static void main(String[] args){
        new Game();
    }
}
