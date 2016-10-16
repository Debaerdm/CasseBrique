package com.mathieu.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.mathieu.game.config.Enums;
import com.mathieu.game.model.Object.Paddle;

import java.util.HashMap;

public class PaddleController {

    private static final float DAMP = 0.90f;
    private static final float MAX_VEL = 6f;
    private static final float ACCELERATION = 30f;
    private Paddle paddle;
    private static HashMap<Enums.Keys, Boolean> keys = new HashMap<Enums.Keys, Boolean>();

    static {
        keys.put(Enums.Keys.LEFT, false);
        keys.put(Enums.Keys.RIGHT, false);
    }

    public PaddleController(Paddle paddle){
        this.paddle = paddle;
    }

    public void leftPressed() {
        keys.get(keys.put(Enums.Keys.LEFT, true));
    }

    public void rightPressed() {
        keys.get(keys.put(Enums.Keys.RIGHT, true));
    }

    public void leftRelease() {
        keys.get(keys.put(Enums.Keys.LEFT, false));
    }

    public void rightRelease() {
        keys.get(keys.put(Enums.Keys.RIGHT, false));
    }

    public void update(float delta) {
        this.processInput();

        this.paddle.setAcceleration(new Vector2(this.paddle.getAcceleration().x * delta, this.paddle.getAcceleration().y * delta));
        this.paddle.getVelocity().add(this.paddle.getAcceleration().x, this.paddle.getAcceleration().y);
        if(this.paddle.getAcceleration().x == 0) {
            this.paddle.getVelocity().x *= DAMP;
        }

        if (this.paddle.getVelocity().x > MAX_VEL) {
            this.paddle.getVelocity().x = MAX_VEL;
        }

        if(this.paddle.getVelocity().x < -MAX_VEL) {
            this.paddle.getVelocity().x = - MAX_VEL;
        }

        this.paddle.update(delta);
    }

    public boolean processInput() {
        if (keys.get(Enums.Keys.LEFT)) {
            this.paddle.setState(Enums.State.MOVE);
            this.paddle.getAcceleration().x = -ACCELERATION;
        } else if (keys.get(Enums.Keys.RIGHT)) {
            this.paddle.setState(Enums.State.MOVE);
            this.paddle.getAcceleration().x = ACCELERATION;
        } else {
            this.paddle.setState(Enums.State.IDLE);
            this.paddle.getAcceleration().x = 0;
        }

        return false;
    }
}
