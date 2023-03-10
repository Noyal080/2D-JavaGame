package camera;


public class OrthographicCamera extends com.badlogic.gdx.graphics.OrthographicCamera {
    public OrthographicCamera(float width, float height) {

        super((float) width, (float) height);
        this.position.x = (float) (width / 2);
        this.position.y = (float) (height / 2);
    }

    }
