package com.dimas.game;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void update(){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObj = objects.get(i);

            tempObj.update();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObj = objects.get(i);

            tempObj.render(g);
        }
    }

    public void clear(){
        int i = 0;
        if(Game.deletePlayer){
            while(objects.size() > 0)
                removeObject(objects.get(i));
        }else {
            while (objects.size() > 1) {
                if (objects.get(i).getId() == ID.Player) {
                    i++;
                    continue;
                }
                removeObject(objects.get(i));
            }
        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }
}
