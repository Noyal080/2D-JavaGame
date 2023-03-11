package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.model.World;

import com.mygdx.game.screen.TitleScreen;

public class MyGdxGame extends Game {

	private World world;
	public static MyGdxGame INSTANCE;


	public MyGdxGame(){
		INSTANCE= this;
	}
	@Override
	public void create() {

		setScreen(new TitleScreen(this));
	}

	@Override
	public void dispose(){
		super.dispose();
	}
 	@Override
	public void render(){
		super.render();
	}

	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}

	@Override
	public void pause(){
		super.pause();
	}

	@Override
	public void resume(){
		super.resume();
	}
}