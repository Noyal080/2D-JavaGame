package com.mygdx.game.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.MyGdxGame;


public class SplashScreen implements Screen {
    MyGdxGame game;
    public Texture splashtexture;
    public Image splashimage ;
    public Stage splashstage;
    private OrthographicCamera orthographicCamera;
    private float screenHeight, screenWidth;


    public SplashScreen(MyGdxGame game){
        this.game = game;

    }


//    public void create(){
//        this.screenWidth= Gdx.graphics.getWidth();
//        this.screenHeight=Gdx.graphics.getHeight();
//        this.orthographicCamera=new OrthographicCamera();
//        this.orthographicCamera.setToOrtho(false,screenWidth,screenHeight);
//
//
//    }
    @Override
    public void show() {

        this.orthographicCamera = new OrthographicCamera();
        this.screenWidth = Gdx.graphics.getWidth();
        this.screenHeight = Gdx.graphics.getHeight();
        this.orthographicCamera.setToOrtho(false, screenWidth, screenHeight);

        splashtexture = new Texture(Gdx.files.internal("asset/splashscreen.png"));
        splashtexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        splashimage = new Image(splashtexture);
        splashimage.setSize(1280,720);

        splashstage = new Stage(new FitViewport(screenWidth,screenHeight,new OrthographicCamera(screenWidth,screenHeight)));
        splashstage.addActor(splashimage);

        splashimage.addAction(Actions.sequence(Actions.alpha(0.0F), Actions.fadeIn(0.8F),Actions.delay(1F), Actions.fadeOut(0.75F)));

  Gdx.input.setInputProcessor(splashstage);


    }

    @Override
    public void render(float delta) {

       // handleInput();
        //Clearing Screen
        Gdx.gl.glClearColor(.1f,.1f,.15f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        splashstage.act();

        splashstage.draw();

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(orthographicCamera));
        }

        //Register button clicks, move actors around, animations etc.






    }



    @Override
    public void resize(int width, int height) {
        splashstage.getViewport().update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
    dispose();
    }

    @Override
    public void dispose() {

    }
}