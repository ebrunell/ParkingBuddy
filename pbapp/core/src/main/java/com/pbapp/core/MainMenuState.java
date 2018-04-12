package com.pbapp.core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


/**
 * @author Mike
 */
public class MainMenuState extends State {
    
    Button ShinemanButton;
    Button SheldonButton;
    
    private Texture background;
    public MainMenuState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("TitleScreen.png");
        ShinemanButton = new Button("ShinemanButton.png", new Vector2(135,520), new Vector2(230,50));
        SheldonButton = new Button("SheldonButton.png", new Vector2(135,380), new Vector2(230,50));
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            if(ShinemanButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())){
                gsm.setState(new ShinemanMapState(gsm));
            }
            if(SheldonButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())){
                gsm.setState(new SheldonMapState(gsm));
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
        sb.draw(ShinemanButton.getTexture(), ShinemanButton.getXpos(), ShinemanButton.getYpos());
        sb.draw(SheldonButton.getTexture(), SheldonButton.getXpos(), SheldonButton.getYpos());
        sb.end();
    }
    public void dispose(){
        //remember to add all drawn objects to this method.
        background.dispose();
        ShinemanButton.getTexture().dispose();
        SheldonButton.getTexture().dispose();
    }
    
}

