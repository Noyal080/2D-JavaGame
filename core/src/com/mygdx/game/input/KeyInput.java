package com.mygdx.game.input;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class KeyInput extends InputListener {
    public boolean keyDown(InputEvent event , int keycode)
    {
        return super.keyDown(event,keycode);

    }
    public boolean keyUp(InputEvent event, int keycode)
    {
        return super.keyUp(event, keycode);
    }
}
