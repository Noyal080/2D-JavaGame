package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.model.World;
public class MyGdxGame extends Game {

	private World world;
	public static MyGdxGame INSTANCE;
	private int screenHeight, screenWidth;
	private OrthographicCamera orthographicCamera;


	public MyGdxGame(){
		INSTANCE= this;
	}
	@Override
	public void create() {
		this.screenWidth= Gdx.graphics.getWidth() ;
		this.screenHeight=Gdx.graphics.getHeight();
		this.orthographicCamera= new OrthographicCamera();
		this.orthographicCamera.setToOrtho(false,screenWidth,screenHeight);




		setScreen(new GameScreen(orthographicCamera));
	}



	//public void dispose() {}



//	public void render()
//	{
//		world.update();
//	}
}