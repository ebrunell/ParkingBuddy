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
    private Button backButton;
    private Button dataButton;
    private MapSprite map;
    
    public ShinemanMapState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("ShinemanMap.png");
        backButton = new Button("BackButton.png", new Vector2(37,60), new Vector2(230,50));
        dataButton = new Button("DataButton.png", new Vector2(400, 60), new Vector2(230,50));
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
            
            if (backButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())) {
                this.dispose();
                gsm.pop();
                MainMenuState m = new MainMenuState(gsm);
                gsm.push(m);
                
            }
            
            if (dataButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())) {
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
        sb.draw(backButton.getTexture(), backButton.getXpos(), backButton.getYpos());
        sb.draw(dataButton.getTexture(), dataButton.getXpos(), dataButton.getYpos());
        sb.end();
    }
    
    public void dispose() {
        //remember to add all drawn objects to this method.
        background.dispose();
        map.getTexture().dispose();
    }
    
}
