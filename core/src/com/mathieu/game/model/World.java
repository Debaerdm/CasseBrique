package com.mathieu.game.model;

public class World {

    private Level level;

    public Level getLevel() {
        return level;
    }

    public World() {
        this.createWorld();
    }

    private void createWorld() {
        this.level = new Level();
    }
}
