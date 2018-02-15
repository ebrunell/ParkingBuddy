package com.mygdx.game.states;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.*;
/**
 * @author Mike
 */
public class GuiStateManager {
    private Stack<State> guiStates;
    
    public GuiStateManager(){
        guiStates = new Stack<State>();
    }
    
    public void push(State s){
        guiStates.push(s);
    }
    public void pop(){
        guiStates.pop();
    }
    public void setState(State s){
        this.pop();
        this.push(s);
    }
    public void update(double dt){
        guiStates.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        guiStates.peek().render(sb);
    }
}
