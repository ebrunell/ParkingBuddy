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
    public static final int width = 400;//Gdx.app.getGraphics().getWidth();
    public static final int height = 800 ;//Gdx.app.getGraphics().getHeight();
        //String that sets the title
    public static final String title = "ParkingBuddy";

        //all three of these may be referenced in the in the respective launcher
        
    private GuiStateManager gsm;
	private SpriteBatch batch;
	private OrthographicCamera cam;
        
	@Override
	public void create () {

        //Gui state manager is a stack of states.



        float w = Gdx.app.getGraphics().getWidth();
        float h = Gdx.app.getGraphics().getHeight();
        cam  = new OrthographicCamera(30, 30 * (h / w));
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.update();
        batch = new SpriteBatch();
        gsm = new GuiStateManager();
        gsm.push(new MainMenuState(gsm));
        Gdx.gl.glClearColor(1, 0, 0, 1);
	}

	@Override
	public void render () {
	    cam.update();
	    batch.setProjectionMatrix(cam.combined);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
}
