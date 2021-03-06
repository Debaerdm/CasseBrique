package com.mathieu.game.model.object;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mathieu.game.config.Enums;

import static com.mathieu.game.config.Constance.PADDLE_HEIGHT;
import static com.mathieu.game.config.Constance.PADDLE_WIDTH;

public class Paddle {

    private Vector2 acceleration;
    private Vector2 velocity;
    private Vector2 position;
    private Rectangle bounds;
    private Enums.State state;
    private float stateTime = 0;

    private Paddle(){
        this.acceleration = new Vector2();
        this.velocity = new Vector2();
        this.position = new Vector2();
        this.bounds = new Rectangle();
        this.state = Enums.State.IDLE;
    }

    public Paddle(float x, float y) {
        this();
        this.position = new Vector2(x,y);
        this.bounds.width = PADDLE_WIDTH;
        this.bounds.height = PADDLE_HEIGHT;
        this.bounds.x = this.position.x;
        this.bounds.y = this.position.y;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setState(Enums.State state) {
        this.state = state;
    }

    public void update(float delta) {
        this.stateTime += delta;
        this.position.mulAdd(velocity.cpy(), delta);
    }
}
