package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.parkingbuddy.PBApp;
import javafx.scene.text.Text;

/**
 * @author Mike
 */
public class MenuState extends State{
    
    Texture background;
    Text example;
    
    public MenuState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("TitleScreen.png");
    }
    
    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            /*
            System.out.println("Something");
            System.out.printf("X: %d\n",Gdx.input.getX());
            System.out.printf("Y: %d\n",Gdx.input.getY());
            */
            
            gsm.pop();
            ServerTestState s = new ServerTestState(gsm);
            gsm.push(s);
            
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

}
