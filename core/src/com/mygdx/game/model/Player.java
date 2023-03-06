//main character class
//remove immune later immune is when there is powerup for being a super character


package com.mygdx.game.model;
//extendede

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.animation.PlayerAnimation;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends MovingPlayer {
    protected PlayerAnimation gfx = new PlayerAnimation();
    protected Rectangle rect = new Rectangle();
    private boolean immune;

    private float jump_boost =40f,width,height;

    public Player(World world, float positionX,float positionY)
    {
        super(world,positionX,positionY,8f);
        immune = false;
        moving = true;
        health =3;


    }
    private void hitByMob()
    {
         if(health < 1 )
        {
            state = State.Dying;
            velocity.set(0,0);
        }
         else
         {

         }
    }
    protected void dieByFalling()
    {
        if(rect.getY() < -3f)
        {
            state = State.Dying;
            velocity.set(0,0);

        }
    }
    public void act(float delta)
    {
        super.act(delta);
        if(state != State.Dying)
        {
            if((Gdx.input.isKeyPressed(Keys.SPACE)) || Gdx.input.isKeyPressed(Keys.W))
                jump();
            if(Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A) )
                move(Direction.LEFT);
            if(Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D) )
                move(Direction.RIGHT);
        }

    }

    private void jump()
    {

    }

    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(300,300,15,20);
    }
}
