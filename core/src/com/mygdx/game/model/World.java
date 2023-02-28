//call game screen here this may contain the loading screen as well


package com.mygdx.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.mygdx.game.background.WorldRenderer;

public class World {
    private static final float Gravity = -150;
    public static final float scale = 1 / 16f;

    private WorldRenderer wr;
    private Pool<Rectangle> rectPool = new Pool<Rectangle>() {
        protected Rectangle newObject() {
            return new Rectangle();

        }
    };
    //    private Stage stage;
    //reset
    private static boolean reset_flag = false;
    private boolean playing_song = false;

    //    private Flag = flag;
    private static Array<Actor> objectToRemove = new Array<Actor>();

    public World() {
        reset();
    }
    public WorldRenderer getRenderer()
    {
        return wr;
    }

    private boolean level_ended = false;

    public void removeActor(Actor a) {

    }

    private void reset() {

    }

    public void update()
    {

    }
    public void dispose()
    {

    }

}
