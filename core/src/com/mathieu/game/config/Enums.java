package com.mathieu.game.config;

public class Enums {

    public enum State {
        IDLE, MOVE
    }

    public enum Keys {
        LEFT,RIGHT
    }

    public enum FloatValue {
        AUDIO_MUSIC_VOLUME(1.0f), AUDIO_SOUND_VOLUME(1.0F);

        public float defaultValue;

        FloatValue(float defaultValue) {
            this.defaultValue = defaultValue;
        }
    }

    public enum BooleanValue {
        AUDIO_MUSIC_ENABLED(true), AUDIO_SOUND_ENABLED(true);

        //GRAPHICS_FULLSCREEN(false);

        public boolean defaultValue;

        BooleanValue(boolean defaultValue) {
            this.defaultValue = defaultValue;
        }
    }
}
