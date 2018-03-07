package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.parkingbuddy.PBApp;

/**
 *
 * @author emmabrunell
 */
public class SheldonDataState extends State {
    
    private Texture background;
    
    public SheldonDataState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("SheldonData.png");
    }

    @Override
    public void handleInput() {
        //TODO: find x and y for back button and data button
        if (Gdx.input.justTouched()) {
            
            boolean withinBackX = (Gdx.input.getX() >= 18) && (Gdx.input.getX() <= 58);
            boolean withinBackY = (Gdx.input.getY() >= 18) && (Gdx.input.getY() <= 66);
            
            if (withinBackX && withinBackY) {
                this.dispose();
                gsm.pop();
                SheldonMapState sd = new SheldonMapState(gsm);
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
