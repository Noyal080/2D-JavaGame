package com.mygdx.game;
        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.ScreenAdapter;
        import com.badlogic.gdx.graphics.GL20;
        import com.badlogic.gdx.graphics.OrthographicCamera;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.TextureRegion;
        import com.badlogic.gdx.scenes.scene2d.InputEvent;
        import com.badlogic.gdx.scenes.scene2d.Stage;
        import com.badlogic.gdx.scenes.scene2d.ui.Button;
        import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
        import com.badlogic.gdx.scenes.scene2d.ui.Label;
        import com.badlogic.gdx.scenes.scene2d.ui.Table;
        import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
        import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
        import com.badlogic.gdx.utils.viewport.FitViewport;

public class TitleScreen extends ScreenAdapter {
    MyGdxGame game;

    //Display UI , button, label, actors etc.
    Stage stage;

    //Displaying everything properly on different resolutions

    //changed to fitviewport
    private FitViewport viewport;


    private Table mainTable;
    private OrthographicCamera orthographicCamera;
    private int screenHeight, screenWidth;



    Label label;

    public TitleScreen(MyGdxGame game) {
        this.game = game;

    }




    @Override
    public void show() {
        viewport= new FitViewport(1280,720);
        //viewport = new ScreenViewport();
        stage = new Stage(viewport);

        mainTable = new Table();
        mainTable.setFillParent(true);

        stage.addActor(mainTable);

        Texture myTexture = new Texture(Gdx.files.internal("asset/frontpg/enter.png"));
        TextureRegion myTextureRegion = new TextureRegion(myTexture);
        TextureRegionDrawable myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
        Button play = new ImageButton(myTexRegionDrawable); //Set the button up

        mainTable.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("asset/frontpg/spritesheetfrontscreen.gif"))));
        mainTable.row();
        mainTable.add(play).padTop(400);

        //camera
        this.orthographicCamera= new OrthographicCamera();
        this.screenWidth= Gdx.graphics.getWidth() ;
        this.screenHeight=Gdx.graphics.getHeight();
        this.orthographicCamera.setToOrtho(false,screenWidth,screenHeight);



        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("play clicked");
                game.setScreen(new GameScreen(orthographicCamera));
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
