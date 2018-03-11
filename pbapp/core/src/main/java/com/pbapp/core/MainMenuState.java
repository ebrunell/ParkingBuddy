package com.pbapp.core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 * @author Mike
 */
public class MainMenuState extends State {
    private Sprite background;
    public MainMenuState(GuiStateManager gsm) {
        super(gsm);
        background = new Sprite(new Texture(Gdx.files.internal("TitleScreen.png")));
        background.setPosition(0,0);
        background.setSize(500,800);

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
           
           boolean withinSheldonX = (Gdx.input.getX() >= 70) && (Gdx.input.getX() <= 430);
           boolean withinSheldonY = (Gdx.input.getY() <= 380) && (Gdx.input.getY() >= 300);
           boolean withinShinemanX = (Gdx.input.getX() >= 70) && (Gdx.input.getX() <= 430);
           boolean withinShinemanY = (Gdx.input.getY() <= 520) && (Gdx.input.getY() >= 430);
           
            if (withinSheldonX && withinSheldonY) {
                // Sheldon button clicked, proceed to Sheldon Map
                this.dispose();
                gsm.pop();
                SheldonMapState sd = new SheldonMapState(gsm);
                gsm.push(sd);
            }
            
            if (withinShinemanX && withinShinemanY) {
                // Shineman button clicked, proceed to Shineman Map
                this.dispose();
                gsm.pop();
                ShinemanMapState sm = new ShinemanMapState(gsm);
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
        sb.draw(background, 0, 0, background.getWidth(), background.getHeight());

        sb.end();
    }
    public void dispose(){
        //remember to add all drawn objects to this method.
        //'background.dispose();
    }
    
}

