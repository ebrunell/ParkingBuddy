package com.pbapp.core;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pbapp.core.GuiStateManager;
import com.pbapp.core.MainMenuState;

public class PBApp extends ApplicationAdapter {

    //Variables to set screen size
    public static final int width = 500;
    public static final int height = 800;
    //String that sets the title
    public static final String title = "ParkingBuddy";
    //all three of these may be referenced in the in the respective launcher

    private GuiStateManager gsm;
    private SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        //Gui state manager is a stack of states.
        gsm = new GuiStateManager();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MainMenuState(gsm));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
    }
}
