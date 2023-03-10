package object.player;

import static helper.Constants.PPM;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends GameEntity{

    private int jumpCounter;
    public Player(float width, float height, Body body) {
        super(width, height, body);
        this.speed= 10f;
        this.jumpCounter=0;
    }

    @Override
    public void update() {
        x=body.getPosition().x*PPM;  //x will be center of our body
        y=body.getPosition().y*PPM;

        checkUserInput();
    }

    @Override
    public void render(SpriteBatch batch) {

    }

    private  void checkUserInput(){
        velX=0;
        if (Gdx.input.isKeyPressed(Input.Keys.D))
            velX =1;
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            velX =-1;
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && jumpCounter<2){

            float force= body.getMass() * 18;
            body.setLinearVelocity(body.getLinearVelocity().x,0);
            body.applyLinearImpulse(new Vector2(0,force), body.getPosition(),true);  //force will be in y direction
            jumpCounter++;

        }





        //reset jumpCounter

        if (body.getLinearVelocity().y==0){
            jumpCounter = 0;
        }


        body.setLinearVelocity(velX*speed,body.getLinearVelocity().y< 25 ? body.getLinearVelocity().y :25);

    }
}
