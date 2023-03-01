package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen extends ScreenAdapter {
    MyGdxGame game;

    //Display UI , button, label, actors etc.
    Stage stage;

    //Displaying everything properly on different resolutions
    private Viewport viewport;


    private Table mainTable;

    Label label;

    public MenuScreen(MyGdxGame game) {
        this.game = game;

    }

    @Override
    public void show() {
        viewport = new ScreenViewport();
        stage = new Stage(viewport);

        mainTable = new Table();
        mainTable.setFillParent(true);

        stage.addActor(mainTable);

        Texture myTexture = new Texture(Gdx.files.internal("demo/forscreen/spritesheetfrontscreen.png"));
        TextureRegion myTextureRegion = new TextureRegion(myTexture);
        TextureRegionDrawable myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        Button play = new ImageButton(myTexRegionDrawable); //Set the button up

        mainTable.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("demo/forscreen/spritesheetfrontscreen.gif"))));
        mainTable.row();
        mainTable.add(play).padTop(400);



        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("play clicked");
                game.setScreen(new GameScreen(game));
            }
        });
        //Gdx listen to stage
        Gdx.input.setInputProcessor(stage);

        //it recognizes items but to give different functionalities so we have to add listener


    }


    @Override
    public void render(float delta) {
        //Clearing Screen
        Gdx.gl.glClearColor(.1f,.1f,.15f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Register button clicks, move actors around, animations etc.
        stage.act();

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }


}
