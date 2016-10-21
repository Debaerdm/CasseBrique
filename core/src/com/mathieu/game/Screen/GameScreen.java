package com.mathieu.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mathieu.game.controller.PaddleController;
import com.mathieu.game.model.World;
import com.mathieu.game.view.WorldView;

public class GameScreen implements Screen, InputProcessor {

    private World world;
    private WorldView worldView;
    private PaddleController paddleController;

    @Override
    public void show() {
        this.world = new World();
        this.worldView = new WorldView(world);
        this.paddleController = new PaddleController(world.getLevel().getPaddle());
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f,0.25f,0.25f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.paddleController.update(delta);
        this.worldView.render();
    }

    @Override
    public void resize(int width, int height) {
        this.worldView.setSize(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                this.paddleController.leftPressed();
                break;
            case Input.Keys.RIGHT:
                this.paddleController.rightPressed();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                this.paddleController.leftRelease();
                break;
            case Input.Keys.RIGHT:
                this.paddleController.rightRelease();
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
