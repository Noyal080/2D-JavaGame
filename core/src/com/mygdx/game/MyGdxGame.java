package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.mygdx.game.model.World;
public class MyGdxGame extends Game {

	private World world;
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