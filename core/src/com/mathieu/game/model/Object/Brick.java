package com.mathieu.game.model.Object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mathieu on 16/10/16.
 */
public abstract class Brick {

    static final float HEIGHT;
    static final float WIDTH;

    static {
        WIDTH = 2f;
        HEIGHT = 0.25f;
    }

    Vector2 position;
    Rectangle bounds;
    int life;

    public Rectangle getBounds() {
        return bounds;
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getLife() {
        return life;
    }

    public abstract int effect();
}
