package com.djdarkside.workfun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.djdarkside.workfun.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Application.V_WIDTH;
		config.height = Application.V_HEIGHT;
		config.resizable = false;
		new LwjglApplication(new Application(), config);
	}
}
