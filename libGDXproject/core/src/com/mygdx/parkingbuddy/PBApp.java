package com.mygdx.parkingbuddy;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GuiStateManager;
import com.mygdx.game.states.MainMenuState;

public class PBApp extends ApplicationAdapter {
	
        //Variables to set screen size
        public static final int width = 400;
        public static final int height = 800;
        //String that sets the title
        public static final String title = "ParkingBuddy";
        //all three of these may be referenced in the in the respective launcher
        
    private GuiStateManager gsm;
	private SpriteBatch batch;
	private
        
	@Override
	public void create () {
		batch = new SpriteBatch();
        //Gui state manager is a stack of states.
        gsm = new GuiStateManager();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MainMenuState(gsm));
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam  = new OrthographicCamera(30, 30 * (h / w));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
}
