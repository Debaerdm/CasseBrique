package com.mathieu.game.model.object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static com.mathieu.game.config.Constance.DEFAULT_LIFE_BRICK;
import static com.mathieu.game.config.Constance.POINT_BRICK_SIMPLE;

public final class BrickSimple extends Brick {


    private BrickSimple(){
        this.life = DEFAULT_LIFE_BRICK;
        this.position = new Vector2();
        this.bounds = new Rectangle();
    }

    public BrickSimple(float x, float y, float width, float height) {
        this();
        this.position = new Vector2(x,y);
        this.bounds.setX(position.x);
        this.bounds.setY(position.y);
        this.bounds.width = width;
        this.bounds.height = height;
    }

    @Override
    public int effect() {
        return POINT_BRICK_SIMPLE;
    }
}
