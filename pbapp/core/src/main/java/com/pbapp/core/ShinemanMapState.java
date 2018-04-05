package com.pbapp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.pbapp.core.PBApp;

/**
 *
 * @author emmabrunell
 */
public class ShinemanMapState extends State {
    private ShapeRenderer sr;
    private Texture background;
    private Button backButton;
    private Button dataButton;
    private MapSprite map;
    private ParkingSpaceButton[] spaces;
    
    
    public ShinemanMapState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("ShinemanMap.png");
        backButton = new Button("BackButton.png", new Vector2(37,60), new Vector2(230,50));
        dataButton = new Button("DataButton.png", new Vector2(400, 60), new Vector2(230,50));
        map = new MapSprite(0,PBApp.height,"ShinemanLotEditedMap.png",-200,-950,-190,-336);
        spaces = new ParkingSpaceButton[200];
        spaces[0] = new ParkingSpaceButton("1", new Vector2(260, 238), new Vector2(17,50));
        spaces[1] = new ParkingSpaceButton("2", new Vector2(280, 230), new Vector2(17,50));
        spaces[2] = new ParkingSpaceButton("3", new Vector2(298, 218), new Vector2(17,53));
        spaces[3] = new ParkingSpaceButton("4", new Vector2(317, 205), new Vector2(17,53));
        sr = new ShapeRenderer();
    }

    @Override
    protected void handleInput() {
        
        if(Gdx.input.isTouched()){
            int deltaX = Gdx.input.getDeltaX();
            int deltaY = Gdx.input.getDeltaY();
            map.update(new Vector2(deltaX, deltaY));
        }
        
        if (Gdx.input.justTouched()) {
            
            System.out.println("X: " + Gdx.input.getX() + " Y: " + Gdx.input.getY());
            
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
        sr.begin(ShapeRenderer.ShapeType.Filled);
        
        // 0,0 because we already specify the origin when creating the spaces[i]
        // last parameter specifies the rotation of shape if necessary
        sr.rect(spaces[0].getXpos() + map.getXpos(), spaces[0].getYpos() + 
                map.getYpos(), spaces[0].getWidth(), spaces[0].getHeight(), 0, 0, 23f);
        sr.rect(spaces[1].getXpos() + map.getXpos(), spaces[1].getYpos() + 
                map.getYpos(), spaces[1].getWidth(), spaces[1].getHeight(), 0, 0, 23f);
        sr.rect(spaces[2].getXpos() + map.getXpos(), spaces[2].getYpos() + 
                map.getYpos(), spaces[2].getWidth(), spaces[2].getHeight(), 0, 0, 20f);
        sr.rect(spaces[3].getXpos() + map.getXpos(), spaces[3].getYpos() + 
                map.getYpos(), spaces[3].getWidth(), spaces[3].getHeight(), 0, 0, 18f);
        sr.end();
    }
    
    public void dispose() {
        //remember to add all drawn objects to this method.
        background.dispose();
        map.getTexture().dispose();
    }
    
}
