package com.pbapp.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pbapp.core.PBApp;

public class DesktopLauncher {

    /**
     * @param arg
     */
    public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                //----Code that makes the height, width, and title variables work-----------
                config.width = PBApp.width;
                config.height = PBApp.height;
                config.title = PBApp.title;
                //--------------------------------------------------------------------------
		new LwjglApplication(new PBApp(), config);
	}
}
        