package com.pbapp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pbapp.core.PBApp;

/**
 *
 * @author emmabrunell
 */
public class SheldonMapState extends State {
    
    private Texture background;
    
    public SheldonMapState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("SheldonMap.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            
            boolean withinBackX = (Gdx.input.getX() >= 18) && (Gdx.input.getX() <= 65);
            boolean withinBackY = (Gdx.input.getY() >= 15) && (Gdx.input.getY() <= 68);
            boolean withinDataX = (Gdx.input.getX() >= 381) && (Gdx.input.getX() <= 474);
            boolean withinDataY = (Gdx.input.getY() >= 12) && (Gdx.input.getY() <= 65);
            
            if (withinBackX && withinBackY) {
                //System.out.println("back");
                this.dispose();
                gsm.pop();
                MainMenuState m = new MainMenuState(gsm);
                gsm.push(m);
                
            }
            
            if (withinDataX && withinDataY) {
                //System.out.println("Data");
                this.dispose();
                gsm.pop();
                SheldonDataState sd = new SheldonDataState(gsm);
                gsm.push(sd);
                
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
        sb.draw(background, 0, 0, PBApp.width, PBApp.height);
        sb.end();
    }
    
    public void dispose() {
        //remember to add all drawn objects to this method.
        background.dispose();
    }
    
}
