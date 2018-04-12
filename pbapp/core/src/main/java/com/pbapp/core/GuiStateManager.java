package com.pbapp.core;
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
    
     public State peek(){
        if(!guiStates.empty()) return guiStates.peek();
        else return null;
    }
     
    public State pop(){
        if(!guiStates.empty()) return guiStates.pop();
        else return null;
    }
    
    public void setState(State s){
        if(!guiStates.empty()) this.pop();
        this.push(s);
    }
    
    public void update(double dt){
        guiStates.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        guiStates.peek().render(sb);
    }
}
