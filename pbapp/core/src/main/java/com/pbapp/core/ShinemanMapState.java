package com.pbapp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.pbapp.core.PBApp;

/**
 *
 * @author emmabrunell
 */
public class ShinemanMapState extends State {
    
    private Texture background;
    private MapSprite map;
    
    public ShinemanMapState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("ShinemanMap.png");
        map = new MapSprite(0,PBApp.height,"ShinemanLotEditedMap.png",-200,-950,-190,-336);
    }

    @Override
    protected void handleInput() {
        
        if(Gdx.input.isTouched()){
            int deltaX = Gdx.input.getDeltaX();
            int deltaY = Gdx.input.getDeltaY();
            map.update(new Vector2(deltaX, deltaY));
        }
        
        if (Gdx.input.justTouched()) {
            System.out.println("X: " + Gdx.input.getX());
            System.out.println("y: " + Gdx.input.getY());
            
            boolean withinBackX = (Gdx.input.getX() >= 18) && (Gdx.input.getX() <= 65);
            boolean withinBackY = (Gdx.input.getY() >= 15) && (Gdx.input.getY() <= 68);
            boolean withinDataX = (Gdx.input.getX() >= 381) && (Gdx.input.getX() <= 474);
            boolean withinDataY = (Gdx.input.getY() >= 12) && (Gdx.input.getY() <= 65);
            
            if (withinBackX && withinBackY) {
                this.dispose();
                gsm.pop();
                MainMenuState m = new MainMenuState(gsm);
                gsm.push(m);
                
            }
            
            if (withinDataX && withinDataY) {
                this.dispose();
                gsm.pop();
                ShinemanDataState sm = new ShinemanDataState(gsm);
                gsm.push(sm);
                
            }
            
        }
    }

    @Override
    public void update(double dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(map.getTexture(), map.getXpos(), map.getYpos(),1650,1200);
        sb.draw(background, 0, 0, PBApp.width, PBApp.height);
        sb.end();
    }
    
    public void dispose() {
        //remember to add all drawn objects to this method.
        background.dispose();
        map.getTexture().dispose();
    }
    
}
