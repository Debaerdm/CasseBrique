package com.mathieu.game.model;

public class World {
    public Level level;

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
