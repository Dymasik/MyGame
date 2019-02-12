package com.dimas.game;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Sword extends GameObject {

    public Sword(float x, float y, ID id, float angle){
        super(x, y, id);

        this.angle = angle;
    }

    public void update() {
        angle += 0.01f * Game.GameSpeed;
    }

    public void render(Graphics g) {


        Graphics2D g2d = (Graphics2D) g;

        Path2D.Double path = new Path2D.Double();
        path.append(new Rectangle((int)x, (int)y, Game.WIDTH + 400, 16), false);
        AffineTransform t = new AffineTransform();
        t.setToRotation(angle, Game.WIDTH / 2, Game.HEIGHT / 2);
        path.transform(t);
        g2d.setColor(new Color(128, 83, 5));
        g2d.fill(path);

    }

    public Rectangle getBounds() {
        return null;
    }

    public void setImmortal(boolean immortal) {

    }


}
