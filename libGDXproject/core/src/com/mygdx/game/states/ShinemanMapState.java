package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.parkingbuddy.PBApp;

/**
 *
 * @author emmabrunell
 */
public class ShinemanMapState extends State {
    
    private Texture background;
    
    public ShinemanMapState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("ShinemanMap.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            
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
        sb.draw(background, 0, 0, PBApp.width, PBApp.height);
        sb.end();
    }
    
    public void dispose() {
        //remember to add all drawn objects to this method.
        background.dispose();
    }
    
}
