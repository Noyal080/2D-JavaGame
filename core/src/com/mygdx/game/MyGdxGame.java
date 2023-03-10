package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.model.World;

import screen.TitleScreen;

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
	public void render(){
		super.render();
	}
}