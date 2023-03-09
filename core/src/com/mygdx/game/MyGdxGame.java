package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.model.World;
public class MyGdxGame extends Game {

	private World world;
	public static MyGdxGame INSTANCE;


	public MyGdxGame(){
		INSTANCE= this;
	}
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}



	//public void dispose() {}



//	public void render()
//	{
//		world.update();
//	}
}