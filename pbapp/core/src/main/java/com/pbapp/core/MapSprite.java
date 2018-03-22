package com.pbapp.core;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Mike
 */
public class MapSprite {
    private Vector2 position;
    private Texture map;
    Vector2 xConstraints;
    Vector2 yConstraints;
    
    public MapSprite(int x, int y, String fileName, int xHigh, int xLow, int yHigh, int yLow){
        position = new Vector2(x,y);
        map = new Texture(fileName);
        xConstraints = new Vector2(xHigh,xLow);
        yConstraints = new Vector2(yHigh,yLow);
    }
    
    public MapSprite(int x, int y){
        position = new Vector2(x,y);
        map = null;
    }
    
    public void update(Vector2 input){
        position.add(input);
        if(position.x > xConstraints.x) position.x = xConstraints.x;
        if(position.x < xConstraints.y) position.x = xConstraints.y;
        if((PBApp.height - position.y) > yConstraints.x) position.y = (PBApp.height - yConstraints.x);
        if((PBApp.height - position.y) < yConstraints.y) position.y = (PBApp.height - yConstraints.y);
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
