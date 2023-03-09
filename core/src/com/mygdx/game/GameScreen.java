package com.mygdx.game;

import static helper.Constants.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import javax.swing.text.Position;

import helper.TileMapHelper;
//import object.player.Player;


public class GameScreen extends ScreenAdapter {
    MyGdxGame game;


    private OrthographicCamera camera;
    private SpriteBatch batch;
    private World world;
    private Box2DDebugRenderer box2DDebugRenderer;

    public GameScreen(MyGdxGame game) {this.game = game;    }

    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer ;
    private TileMapHelper tileMapHelper;

    //game object
//    private Player player;
    public GameScreen(OrthographicCamera camera){
        this.camera = camera;
        this.batch =new SpriteBatch();
        this.world= new World(new Vector2(0,-25f),false);
        this.box2DDebugRenderer = new Box2DDebugRenderer();
        this.tileMapHelper= new TileMapHelper(this);


        this.orthogonalTiledMapRenderer= tileMapHelper.setupMap();

    }



    private void update(){
        world.step(1/60f,6,2);
        cameraUpdate();
        batch.setProjectionMatrix(camera.combined);
        orthogonalTiledMapRenderer.setView(camera); //pass camera
//        player.update();
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
    }

    private void cameraUpdate(){
        Vector3 position = camera.position;
        //position.x= Math.round(player.getBody().getPosition().x * PPM * 10)/ 10f;  //get player position and get it x and y and dividing give smooth camera movement i d k why not working
        //position.y= Math.round(player.getBody().getPosition().y * PPM * 10)/ 10f;
        camera.position.set(position);
        //camera.position.set(new Vector3(0,0,0));

        camera.update();
    }
    @Override
    public void render(float delta) {
       this.update();

       Gdx.gl.glClearColor(0,0,0,1);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        orthogonalTiledMapRenderer.render();  //done to put static obj before other


       batch.begin();
       // render objects

        batch.end();
        box2DDebugRenderer.render(world,camera.combined.scl(PPM));
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    public World getWorld() {
        return world;
    }

    //for player

//    public void setPlayer(Player player){

//        this.player= player;
    }
//    }
