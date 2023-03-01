package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends Game {

	public static String APP_TITLE = "Journey Through Pages";
	public static double APP_VERSION = 0.1;
	public static int APP_WIDTH = 1280;
	public static int APP_HEIGHT = 720;
	public static int IDLE_FPS = 60;
	public static int FOREGROUND_FPS = 60;

	public static MyGdxGame INSTANCE;
	private int screenHeight, screenWidth;
	private OrthographicCamera orthographicCamera;
	ShapeRenderer shapeRenderer;

	@Override
	public void create() {
		shapeRenderer = new ShapeRenderer();
		setScreen(new MenuScreen(this));
	}


	@Override
	public void dispose() {
		//world.dispose();
		shapeRenderer.dispose();
	}
//	public void render()
//	{
//		world.update();
//	}
}