package com.dimas.game;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import java.util.HashMap;
import java.util.Map;

public class AudioPlayer {

    public static Map<String, Music> musicMap = new HashMap<String, Music>();

    public static void load(){
        try {
            musicMap.put("music", new Music("res/Nonstop.ogg"));
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public static Music getMusic(String key){
        return musicMap.get(key);
    }
}
