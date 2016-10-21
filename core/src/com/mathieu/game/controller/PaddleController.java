package com.mathieu.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.mathieu.game.config.Enums;
import com.mathieu.game.model.object.Paddle;

import java.util.HashMap;

import static com.mathieu.game.config.Constance.ACCELERATION;
import static com.mathieu.game.config.Constance.DAMP;
import static com.mathieu.game.config.Constance.MAX_VEL;
import static com.mathieu.game.config.Constance.CAMERA_WIDTH;
import static com.mathieu.game.config.Constance.PADDLE_WIDTH;

public class PaddleController {


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

        if (this.paddle.getPosition().x < 0) {
            this.paddle.getPosition().x = 0;
        }

        if (this.paddle.getPosition().x > CAMERA_WIDTH - PADDLE_WIDTH) {
            this.paddle.getPosition().x = CAMERA_WIDTH - PADDLE_WIDTH;
        }
    }

    private boolean processInput() {
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
