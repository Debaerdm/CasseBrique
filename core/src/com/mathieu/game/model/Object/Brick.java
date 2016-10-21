package com.mathieu.game.model.object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Brick {

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

    @Override
    public String toString() {
        return "Position : ("+position.x+","+position.y+"), Taille : ("+bounds.width+","+bounds.height+").";
    }
}
