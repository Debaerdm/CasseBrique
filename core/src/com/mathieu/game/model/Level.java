package com.mathieu.game.model;

import com.badlogic.gdx.Gdx;
import com.mathieu.game.model.object.Brick;
import com.mathieu.game.model.object.Paddle;

import java.util.ArrayList;
import java.util.List;

import static com.mathieu.game.config.Constance.CAMERA_WIDTH;
import static com.mathieu.game.config.Constance.PADDLE_WIDTH;

public class Level {

    private Paddle paddle;
    private List<Brick> brickArray = new ArrayList<Brick>();

    public Paddle getPaddle() {
        return paddle;
    }

    public List<Brick> getBricks() {
        return brickArray;
    }

    public Brick getBrick(int index){
        return brickArray.get(index);
    }

    Level() {
        this.createLevel();
    }

    private void createLevel() {
        this.paddle = new Paddle(CAMERA_WIDTH/2 - PADDLE_WIDTH/2, 0.25f);

       float brickWidth = Gdx.graphics.getWidth() / 10;


        //float numberOfBricks = WorldView.CAMERA_WIDTH/Brick.WIDTH;
        /*float widthView = WorldView.CAMERA_WIDTH;
        float brickHeight = 0.5f;
        float heightView = WorldView.CAMERA_HEIGHT-brickHeight;

        System.out.println(brickWidth);

        Brick brick;

        float j = heightView;

        while (j > heightView/2) {
            float i = 0;
            while (i < widthView) {
                brick = new BrickSimple(i,j, brickWidth,brickHeight);
                brickArray.add(brick);
                i += brickWidth;
            }
            j -= brickHeight;
        }*/

        /*
        bricks = new Brick[width][height];
        int pas = 0;

        for (int j = height; j >= height/2 ; j--){
            for (int i = width; i >= 0; i--) {
                bricks[i][j] = new BrickSimple(100, j, i);
            }

            for (int o = 1; o < pas; o++) {
                bricks[o - 1][j] = null;
                bricks[width - o][j] = null;
            }

            pas++;

        }

        System.out.println(this.toString());*/
    }

}
