package com.mygdx.game;

import static com.mygdx.game.MyGdxGame.APP_HEIGHT;
import static com.mygdx.game.MyGdxGame.APP_TITLE;
import static com.mygdx.game.MyGdxGame.APP_WIDTH;
import static com.mygdx.game.MyGdxGame.FOREGROUND_FPS;
import static com.mygdx.game.MyGdxGame.IDLE_FPS;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

import java.awt.FlowLayout;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle(APP_TITLE);
		config.setForegroundFPS(FOREGROUND_FPS);
		config.setIdleFPS(IDLE_FPS);
		config.useVsync(true);
		config.setWindowedMode(APP_WIDTH,APP_HEIGHT);

		new Lwjgl3Application(new MyGdxGame(), config);
	}
}
