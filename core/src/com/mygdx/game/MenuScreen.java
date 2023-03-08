package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MenuScreen extends ScreenAdapter {
    MyGdxGame game;

    //Display UI , button, label, actors etc.
    Stage stage;

    //Displaying everything properly on different resolutions
    private Viewport viewport;

    Skin skin;

    private Table mainTable;

    Label label;

    public MenuScreen(MyGdxGame game) {
        this.game = game;
        skin = new Skin(Gdx.files.internal("ui-skin.json"));

    }

    @Override
    public void show() {
        viewport = new ScreenViewport();
        stage = new Stage(viewport);

        mainTable = new Table();
        mainTable.setFillParent(true);

        stage.addActor(mainTable);

        TextButton play = new TextButton("Play",skin);
        mainTable.add(play).width(120).padBottom(10);
        mainTable.row();
        mainTable.add(new TextButton("Options",skin)).fillX().padBottom(10);
        mainTable.row();
        mainTable.add(new TextButton("Credits",skin)).fillX().padBottom(10);
        mainTable.row();
        mainTable.add(new TextButton("Exit",skin)).fillX().padBottom(10);


        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Game started");
                game.setScreen(new GameScreen(game));
            }
        });
        //Gdx listen to stage
        Gdx.input.setInputProcessor(stage);

        //it recognizes items but to give different functionalities so we have to add listener


    }

//    private TextButton addButton(String name){
//        //we can add skin but we wiill skip that
//        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
//        TextButton button = new TextButton(name, textButtonStyle );
//        mainTable.add(button);
//        return button;
//}


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
