package com.mygdx.game.background;

import com.mygdx.game.model.World;

public class WorldRenderer {
    private World world;
//    private Texture bg_image;
    private static final int VIRTUAL_WIDTH = 1280;
    private static final int VIRTUAL_HEIGHT = 720;
    private static final float ASPECT_RATIO = (float)VIRTUAL_WIDTH/(float)VIRTUAL_HEIGHT;

    public WorldRenderer(World world)
    {
        this.world = world;
    }

    public void render()
    {

    }
    public void dispose()
    {

    }

}
