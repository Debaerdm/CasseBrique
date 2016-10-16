package com.mathieu.game.model.Object;

public class BrickSimple extends Brick {
    public static final int POINT_SIMPLE = 100;

    public BrickSimple(int life) {
        this.life = life;
    }

    @Override
    public int effect() {
        return POINT_SIMPLE;
    }
}
