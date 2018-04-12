package com.pbapp.html;

import com.pbapp.core.PBApp;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class PBAppHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new PBApp();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
