package com.dimas.game;

import java.awt.*;

public class Trial extends GameObject {

    private Handler handler;
    private float life;
    private float alpha = 1;
    private Color color;

    public Trial(float x, float y, ID id, Color color, float life, Handler handler){
        super(x, y, id);

        this.color = color;
        this.life = life;
        this.handler = handler;
    }

    public void update() {
        if(alpha > life){
            alpha -= life - 0.001f;
        }
        else{
            handler.removeObject(this);
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setComposite(makeTransparent(alpha));
        g.setColor(color);
        g.fillRect((int)x, (int)y, 16, 16);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }

    public void setImmortal(boolean immortal) {

    }
}
