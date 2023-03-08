//contains the collision factor enum for inputs etc
package com.mygdx.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Pool;


public class MovingPlayer extends Actor {
    public static enum State
    {
        Walking , Standing, Jumping, Dying,Dead
    }
    public static enum Direction
    {
        LEFT,RIGHT
    }
    protected Pool <Rectangle> rectPool = new Pool<Rectangle>()
    {
        protected Rectangle newObject()
        {
            return new Rectangle();
        }

    };
    protected float max_velocity;
    protected float jump_velocity = 40f;
    protected float dampimg = 0.87f;
    protected Vector2 postion , velocity;
    protected boolean dead;
    protected boolean moving;
    protected int health;
    protected World world;
    protected State state = State.Standing;
    protected Direction direction;
    protected boolean facesRight =true;

    protected boolean grounded = false;

    public MovingPlayer(World world, float x, float y, float max_velocity)
    {
        this.world = world;
        this.setPosition(x,y);
        this.max_velocity = max_velocity;
        velocity = new Vector2(0,0);
        dead= false;
        moving = false;

    }
    public boolean isDead()
    {
        return dead;
    }
    public void setDead(boolean dead)
    {
        this.dead =dead;
        world.removeActor(this);
    }
    protected Rectangle rectangle() {
        return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }
    public void move(Direction dir) {
        if(state != State.Dying && moving) {
            if(dir == Direction.LEFT) {
                velocity.x = -max_velocity;
                facesRight = false;
            }
            else {
                velocity.x = max_velocity;
                facesRight = true;
            }
            direction = dir;
            if (grounded) {
                state = MovingPlayer.State.Walking;
            }
        }
    }



}
