package com.mygdx.game.states;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
/**
 * @author Mike
 */
public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouseIn;
    protected GuiStateManager gsm;
    
    protected State(GuiStateManager gsm){
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouseIn = new Vector3();
    }
    protected abstract void handleInput();
    public abstract void update(double dt);
    public abstract void render(SpriteBatch sb);
}
