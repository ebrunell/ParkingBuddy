package com.mygdx.game.states;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.pb.ParkingBuddy;

/**
 * @author Mike
 */
public class MainMenuState extends State {
    private Texture background;
    public MainMenuState(GuiStateManager gsm) {
        super(gsm);
        background = new Texture("D:\\Cygwin\\home\\Mike\\emacsProjects\\CSC380\\csc380parkingBuddy\\project\\core\\assets\\background.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            //TODO: Make button objects with methods in them to check if theyre clicked
            boolean withinX = ((Gdx.input.getX() > (ParkingBuddy.width/2)+55)) && ((Gdx.input.getX() < (ParkingBuddy.width/2)+175));
            boolean withinY = (Gdx.input.getY() > (ParkingBuddy.height/2)-60) && ((Gdx.input.getY() < (ParkingBuddy.height/2)+100));
            if(withinX && withinY){
                //System.out.println("Title clicked.");
                this.dispose();
                gsm.pop();
                ThankYouState s = new ThankYouState(gsm);
                gsm.push(s);
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
        sb.draw(background, 0, 0, ParkingBuddy.width, ParkingBuddy.height);
        sb.end();
    }
    public void dispose(){
        //remember to add all drawn objects to this method.
        background.dispose();
    }
    
}
