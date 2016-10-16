package com.mathieu.game.model.Object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mathieu on 16/10/16.
 */
public abstract class Brick {

    protected int point;
    protected Vector2 position;
    protected Rectangle bounds;
    protected int life;

    public int getPoint() {
        return point;
    }

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
