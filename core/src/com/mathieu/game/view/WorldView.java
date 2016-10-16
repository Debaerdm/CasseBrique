package com.mathieu.game.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mathieu.game.model.Object.Paddle;
import com.mathieu.game.model.World;

public class WorldView {

    public static final float CAMERA_WIDTH = 25f;
    public static final float CAMERA_HEIGHT = 10f;

    private World world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private int width;
    private int height;
    private float ppuX;
    private float ppuY;

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
        this.ppuX = (float) this.width / CAMERA_WIDTH;
        this.ppuY = (float) this.height / CAMERA_HEIGHT;
    }

    public WorldView(World world){
        this.world = world;
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
        this.camera.update();
        this.shapeRenderer = new ShapeRenderer();
        this.spriteBatch = new SpriteBatch();
    }

    public void render(){
        this.drawPaddle();
    }

    private void drawBricks() {

    }

    private void drawPaddle() {
        this.shapeRenderer.setProjectionMatrix(camera.combined);
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        Paddle paddle = this.world.getLevel().getPaddle();
        this.shapeRenderer.setColor(Color.RED);
        this.shapeRenderer.rect(paddle.getPosition().x, paddle.getPosition().y, paddle.getBounds().width, paddle.getBounds().height);
        this.shapeRenderer.end();
    }
}
