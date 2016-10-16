package com.mathieu.game.model;

import com.mathieu.game.model.Object.Brick;
import com.mathieu.game.model.Object.BrickSimple;
import com.mathieu.game.model.Object.Paddle;
import com.mathieu.game.view.WorldView;

public class Level {

    public Brick[][] bricks;
    public Paddle paddle;

    public Paddle getPaddle() {
        return paddle;
    }

    public Brick[][] getBricks() {
        return bricks;
    }

    public Brick getBrick(int x, int y){
        return bricks[x][y];
    }

    public Level() {
        this.createLevel();
    }

    public void createLevel() {
        paddle = new Paddle(WorldView.CAMERA_WIDTH/2 - Paddle.PADDLE_WIDTH/2, 0.25f);
        bricks = new Brick[(int)WorldView.CAMERA_WIDTH][(int)WorldView.CAMERA_HEIGHT];

        int pas = 0;
        for (int j = (int)WorldView.CAMERA_HEIGHT - 1; j > (int)(WorldView.CAMERA_HEIGHT-1/2); j--){
            for (int i = (int)WorldView.CAMERA_WIDTH - 1; i > 0; i--)  {
                bricks[i][j] = new BrickSimple(100);
            }
            for (int o = 0; o < pas; o++) {
                bricks[o - 1][j] = null;
                bricks[(int)(WorldView.CAMERA_WIDTH -1) - o][j] = null;
            }

            pas++;
        }

        this.affiche();
    }

    public void affiche() {
        String res = "|";
        for (int j = 0; j < WorldView.CAMERA_HEIGHT-1; j++) {
            for (int i = 0; i < WorldView.CAMERA_WIDTH-1; i++) {
                if (bricks[i][j] != null) {
                    res += "o|";
                } else {
                    res += " |";
                }
            }

            res += "\n";
        }

        System.out.println(res);
    }

}
