package com.mygdx.pb.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.pb.ParkingBuddy;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                //----Code that makes the height, width, and title variables work-----------
                config.width = ParkingBuddy.width;
                config.height = ParkingBuddy.height;
                config.title = ParkingBuddy.title;
                //--------------------------------------------------------------------------
		new LwjglApplication(new ParkingBuddy(), config);
	}
}
