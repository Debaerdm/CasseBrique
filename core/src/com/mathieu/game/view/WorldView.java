package com.mathieu.game.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mathieu.game.model.object.Brick;
import com.mathieu.game.model.object.Paddle;
import com.mathieu.game.model.World;

import static com.mathieu.game.config.Constance.CAMERA_HEIGHT;
import static com.mathieu.game.config.Constance.CAMERA_WIDTH;

public class WorldView {

    private World world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    //private SpriteBatch spriteBatch;
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
        //this.spriteBatch = new SpriteBatch();
    }

    public void render(){
        this.shapeRenderer.setProjectionMatrix(camera.combined);
        //this.drawBricks(Color.BLACK, ShapeRenderer.ShapeType.Line);
        //this.drawBricks(Color.CORAL, ShapeRenderer.ShapeType.Filled);
        this.drawPaddle(Color.BLACK, ShapeRenderer.ShapeType.Line);
        this.drawPaddle(Color.SCARLET, ShapeRenderer.ShapeType.Filled);
    }

    private void drawBricks(Color color, ShapeRenderer.ShapeType shapeType) {
        this.shapeRenderer.begin(shapeType);
        for (Brick brick : world.getLevel().getBricks()) {
           /* Rectangle rectangle = brick.getBounds();
            float x1 = brick.getPosition().x + rectangle.getX();
            float y1 = brick.getPosition().y + rectangle.getY();
            System.out.println(x1+" "+y1);*/
            shapeRenderer.setColor(color);
            //shapeRenderer.rect(x1,y1,rectangle.width,rectangle.height);
            shapeRenderer.rect(brick.getPosition().x,
                    brick.getPosition().y,
                    brick.getBounds().width,
                    brick.getBounds().height);
        }
        this.shapeRenderer.end();
    }

    private void drawPaddle(Color color, ShapeRenderer.ShapeType shapeType) {
        Paddle paddle = this.world.getLevel().getPaddle();
        this.shapeRenderer.setColor(color);
        this.shapeRenderer.begin(shapeType);
        this.shapeRenderer.rect(paddle.getPosition().x, paddle.getPosition().y, paddle.getBounds().width, paddle.getBounds().height);
        this.shapeRenderer.end();
    }
}
