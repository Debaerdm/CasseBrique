package com.mathieu.game.model.Object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class BrickSimple extends Brick {
    private static final int POINT_SIMPLE;

    static {
        POINT_SIMPLE = 100;
    }

    private BrickSimple(){
        this.position = new Vector2();
        this.bounds = new Rectangle();
    }

    public BrickSimple(int life, float x, float y) {
        this();
        this.life = life;
        this.position = new Vector2(x,y);
        this.bounds.width = WIDTH;
        this.bounds.height = HEIGHT;
        this.bounds.x = this.position.x;
        this.bounds.y = this.position.y;
    }

    @Override
    public int effect() {
        return POINT_SIMPLE;
    }
}
