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
        spaces[0] = new ParkingSpaceButton("1", new Vector2(260, 238), new Vector2(17,50), 23f);
        spaces[1] = new ParkingSpaceButton("2", new Vector2(280, 230), new Vector2(17,50), 23f);
        spaces[2] = new ParkingSpaceButton("3", new Vector2(298, 218), new Vector2(17,53), 20f);
        spaces[3] = new ParkingSpaceButton("4", new Vector2(317, 205), new Vector2(17,53), 18f);
        spaces[4] = new ParkingSpaceButton("5", new Vector2(340,195), new Vector2(17,53), 20f);
        spaces[5] = new ParkingSpaceButton("6", new Vector2(365,178), new Vector2(17,53), 20f);
        spaces[6] = new ParkingSpaceButton("7", new Vector2(395, 161), new Vector2(17,53), 23f);
        spaces[7] = new ParkingSpaceButton("8", new Vector2(424,144), new Vector2(17,53), 23f);
        spaces[8] = new ParkingSpaceButton("9", new Vector2(449,129), new Vector2(17,53), 23f);
        spaces[9] = new ParkingSpaceButton("10", new Vector2(478,112), new Vector2(17,53), 24f);
        spaces[10] = new ParkingSpaceButton("11", new Vector2(523,83), new Vector2(17,53), 23f);
        
        spaces[17] = new ParkingSpaceButton("18", new Vector2(280,390), new Vector2(17,43),90f);
        //spaces 19 to 23 are handled with the following for loop
        
        int x1 = 280;
        int y1 = 390;//+ 28
        float t1 = 0f;
        for(int i = 18; i < 23; i++){
            y1 = y1 + 28;
            x1 = x1 + 1;
            spaces[i] = new ParkingSpaceButton(Integer.toString(i + 1), new Vector2(x1,y1), new Vector2(17,43), 90f);
        }
        
        spaces[23] = new ParkingSpaceButton("24", new Vector2(286,609), new Vector2(17,53), 0f);
        x1 = 286;
        y1 = 609;
        //spaces 25 to 45 
        for (int i = 24; i < 45; i++){
            x1 = x1 + 22;
            y1 = y1 - 1;
            if(i % 2 == 0){
                x1 = x1 + 2;
            }
            if(i == 35 || i == 39){
                x1 = x1 + 2; 
            }
            spaces[i] = new ParkingSpaceButton(Integer.toString(i + 1), new Vector2(x1,y1), new Vector2(17,53), 0f);
        }
        
        spaces[45] = new ParkingSpaceButton("46", new Vector2(835,518), new Vector2(17,45), 90f);
        //spaces[46] = new ParkingSpaceButton("47", new Vector2(835,490), new Vector2(17,45), 90f);
        x1 = 835;
        y1 = 518;
        for (int i = 46; i < 62; i++){
            y1 = y1 - 28;
            if(i % 2 == 0){
                x1 = x1 - 2;
                
            }
            if(i % 3 == 0){
              y1 = y1 - 2;  
            }
            
            spaces[i] = new ParkingSpaceButton(Integer.toString(i + 1), new Vector2(x1,y1), new Vector2(17,45), 90f);
        }
        
        spaces[62] = new ParkingSpaceButton("63", new Vector2(380,320), new Vector2(17,43), 90f);
        x1 = 380;
        y1 = 320;
        //for spaces 65 to 71 odd
        for (int i = 64; i < 71; i = i + 2){
            y1 = y1 + 30;
            spaces[i] = new ParkingSpaceButton(Integer.toString(i + 1), new Vector2(x1,y1), new Vector2(17,43), 90f);
        }
        //spaces[64] = new ParkingSpaceButton("65", new Vector2(380,350), new Vector2(17,43), 90f);
        
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
        for(int i = 0; i < spaces.length; i++){
            if(spaces[i] != null){
                sr.rect(spaces[i].getXpos() + map.getXpos(), spaces[i].getYpos() + 
                map.getYpos(), spaces[i].getWidth(), spaces[i].getHeight(), 0, 0, spaces[i].getTilt());
            }
            
        }
        
        sr.end();
    }
    
    public void dispose() {
        //remember to add all drawn objects to this method.
        background.dispose();
        map.getTexture().dispose();
    }
    
}
