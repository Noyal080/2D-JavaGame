package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends Game {

	//private World world;
//	public static final String VERSION = "0.03";
//	public static final int FPS =60;

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