//main character class

package com.mygdx.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.animation.PlayerAnimation;

public class Player extends MovingPlayer {
    protected PlayerAnimation pfx = new PlayerAnimation();
    protected Rectangle rect = new Rectangle();
    private boolean immune;
    private float jump_boost =40f,width,height;

    public Player(World world, float positionX,float positionY)
    {
        super(world,positionX,positionY,8f);
        immune = false;

    }
    private void hitByMob()
    {
        if(!immune)
        {


        }
    }
    protected void dieByFalling()
    {
        if(rect.getY() < -3f)
        {
            state = State.Dying;
        }
    }
}
