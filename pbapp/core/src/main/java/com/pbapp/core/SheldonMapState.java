package com.pbapp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author emmabrunell
 */
public class SheldonMapState extends State {

    private Texture background;
    private Button backButton;
    private Button dataButton;
    private MapSprite map;
    private ParkingSpaceButton[] spaces;
    private ShapeRenderer sr;

    public SheldonMapState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("SheldonMap.png");
        backButton = new Button("BackButton.png", new Vector2(37, 60), new Vector2(230, 50));
        dataButton = new Button("DataButton.png", new Vector2(400, 60), new Vector2(230, 50));
        map = new MapSprite(0, PBApp.height, "SheldonLotEditedMap.png", 0, -700, 0, 0);
        spaces = new ParkingSpaceButton[67];
        sr = new ShapeRenderer();

        //generating first 22 parking space buttons (top row)
        spaces[0] = new ParkingSpaceButton("1", new Vector2(45, 270), new Vector2(45, 120));
        spaces[1] = new ParkingSpaceButton("2", new Vector2(100, 270), new Vector2(40, 120));
        int x1 = 155;
        int j1 = 3;
        for (int i = 2; i < 9; i++) {
            spaces[i] = new ParkingSpaceButton(Integer.toString(j1), new Vector2(x1, 270), new Vector2(40, 130));
            j1++;
            x1 = x1 + 50;
        }
        int x2 = 505;
        int j2 = 10;
        for (int i = 9; i < 16; i++) {
            spaces[i] = new ParkingSpaceButton(Integer.toString(j2), new Vector2(x2, 270), new Vector2(40, 136));
            j2++;
            x2 = x2 + 51;
        }
        int x3 = 913;
        int j3 = 17;
        for (int i = 16; i < 23; i++) {
            spaces[i] = new ParkingSpaceButton(Integer.toString(j3), new Vector2(x3, 270), new Vector2(38, 140));
            j3++;
            x3 = x3 + 50;
        }

        //generating second row of parking spaces #23-45
        int x4 = 52;
        int j4 = 24;
        int y1 = 580;
        for (int i = 23; i < 45; i++) {
            spaces[i] = new ParkingSpaceButton(Integer.toString(j4), new Vector2(x4, y1), new Vector2(40, 136));
            if (i > 38 && i < 46) {
                j4++;
                y1--;
                x4 = x4 + 49;
            } else {
                j4++;
                y1--;
                x4 = x4 + 51;
            }
        }
        
        //generating third row of parking spaces #46-66
        //spaces[45] = new ParkingSpaceButton("46",new Vector2(52,730), new Vector2(40,136));
        int x5 = 52;
        int j5 = 46;
        int y2 = 730;
        for (int i = 45; i < 67; i++) {
            System.out.println(j5);
            spaces[i] = new ParkingSpaceButton(Integer.toString(j5), new Vector2(x5, y2), new Vector2(40,136));
            j5++;
            y2--;
            x5 = x5 + 51;
            
        }
        
    }

    @Override
    protected void handleInput() {

        if (Gdx.input.isTouched()) {
            int deltaX = Gdx.input.getDeltaX();
            int deltaY = Gdx.input.getDeltaY();
            map.update(new Vector2(deltaX, deltaY));
        }

        if (Gdx.input.justTouched()) {

            if (backButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())) {
                //System.out.println("back");
                this.dispose();
                gsm.pop();
                MainMenuState m = new MainMenuState(gsm);
                gsm.push(m);

            } else if (dataButton.wasTouched(Gdx.input.getX(), Gdx.input.getY())) {
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
        sb.draw(backButton.getTexture(), backButton.getXpos(), backButton.getYpos());
        sb.draw(dataButton.getTexture(), dataButton.getXpos(), dataButton.getYpos());
        sb.draw(map.getTexture(), map.getXpos(), map.getYpos(), 1200, 717);
        sb.end();
        sr.begin(ShapeRenderer.ShapeType.Filled);

        //generating parking spaces
        for (int i = 0; i < spaces.length; i++) {
            if (spaces[i] != null) {
                sr.rect(spaces[i].getXpos() + map.getXpos(), spaces[i].getYpos()
                        + map.getYpos(), spaces[i].getWidth(), spaces[i].getHeight(), 0, 0, 0f);
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
