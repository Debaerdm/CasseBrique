package com.mathieu.game.model.object;

/**
 * Created by mathieu on 16/10/16.
 */
public class BrickDoubleEffect extends Brick {

    private Brick brick;

    public BrickDoubleEffect(Brick brick) {
        this.brick = brick;
    }

    @Override
    public int effect() {
        return brick.effect()*2;
    }
}
