package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GuiStateManager;
import com.mygdx.game.states.State;
import com.mygdx.pb.ParkingBuddy;

/**
 * @author Mike
 */
public class ThankYouState extends State{
    
    private Texture background;
    
    public ThankYouState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("Thanks.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) System.exit(1);
    }

    @Override
    public void update(double dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, ParkingBuddy.width, ParkingBuddy.height);
        sb.end();
    }
    
}
