package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static int width = 1024;
	public static int height = 768;
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = width;
		config.height = height;
		config.x = -2;
		config.y = -2;
		LwjglApplication app = new LwjglApplication(new MyGdxGame(), config);
//		app.getApplicationListener().
	}
}
