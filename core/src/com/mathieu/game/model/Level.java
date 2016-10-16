package com.mathieu.game.model;

import com.mathieu.game.model.Object.Brick;
import com.mathieu.game.model.Object.BrickSimple;
import com.mathieu.game.model.Object.Paddle;
import com.mathieu.game.view.WorldView;

public class Level {

    private Brick[][] bricks;
    private Paddle paddle;

    public Paddle getPaddle() {
        return paddle;
    }

    public Brick[][] getBricks() {
        return bricks;
    }

    public Brick getBrick(int x, int y){
        return bricks[x][y];
    }

    Level() {
        this.createLevel();
    }

    private void createLevel() {
        paddle = new Paddle(WorldView.CAMERA_WIDTH/2 - Paddle.PADDLE_WIDTH/2, 0.25f);
        bricks = new Brick[(int)WorldView.CAMERA_WIDTH][(int)WorldView.CAMERA_HEIGHT];

        int height = (int)WorldView.CAMERA_HEIGHT - 1;
        int width = (int) WorldView.CAMERA_WIDTH - 1;
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
    }

    @Override
    public String toString() {
        String res = "|";
        for (int j = 0; j < WorldView.CAMERA_HEIGHT-1; j++) {
            for (int i = 0; i < WorldView.CAMERA_WIDTH-1; i++) {
                if (bricks[i][j] != null) {
                    res += "o|";
                } else {
                    res += "x|";
                }
            }

            res += "\n|";
        }

        return res;
    }

}
