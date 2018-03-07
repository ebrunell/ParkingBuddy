package com.mygdx.game.states;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.parkingbuddy.PBApp;

/**
 * @author Mike
 */
public class MainMenuState extends State {
    private Texture background;
    public MainMenuState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("TitleScreen.png");
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
        sb.draw(background, 0, 0, PBApp.width, PBApp.height);
        sb.end();
    }
    public void dispose(){
        //remember to add all drawn objects to this method.
        background.dispose();
    }
    
}

