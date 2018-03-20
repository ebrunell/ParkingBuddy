package com.pbapp.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Mike
 */
public class MapSprite {
    private Vector2 position;
    private Texture map;
    
    public MapSprite(int x, int y, String fileName){
        position = new Vector2(x,y);
        map = new Texture(fileName);
    }
    
    public void update(Vector2 input){
        position.add(input);
    }
    
    public int getXpos(){
        return (int)position.x;
    }
    
    public int getYpos(){
        //NOTE: dont rely on pbapp.height
        int realPos = PBApp.height;
        realPos -= (int)position.y;
        
        return realPos;
    }

    public Texture getTexture() {
        return map;
    }
    
}
