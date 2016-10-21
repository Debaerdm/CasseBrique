package com.mathieu.game.config;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.PropertiesUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Name : CasseBrique
 * Created by Debaerdm on 20/10/2016.
 * This Package : com.mathieu.game.config.
 */
public class Constance {

    private static final Properties PROPERTIES;

    public static final float DAMP;
    public static final float MAX_VEL;
    public static final float ACCELERATION;
    public static final int POINT_BRICK_SIMPLE;
    public static final int DEFAULT_LIFE_BRICK;
    public static final float PADDLE_WIDTH;
    public static final float PADDLE_HEIGHT;
    public static final float CAMERA_WIDTH;
    public static final float CAMERA_HEIGHT;

    static {

        PROPERTIES = new Properties();

        try {
            PROPERTIES.load(new FileReader("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ACCELERATION = Float.parseFloat((String) PROPERTIES.get("acceleration"));
        MAX_VEL = Float.parseFloat((String) PROPERTIES.get("velocity"));
        DAMP = Float.parseFloat((String) PROPERTIES.get("damp"));
        POINT_BRICK_SIMPLE = Integer.parseInt((String) PROPERTIES.get("point_brick_simple"));
        DEFAULT_LIFE_BRICK = Integer.parseInt((String) PROPERTIES.get("default_life_brick"));
        PADDLE_HEIGHT = Float.parseFloat((String) PROPERTIES.get("paddle_default_height"));
        PADDLE_WIDTH = Float.parseFloat((String) PROPERTIES.get("paddle_default_width"));
        CAMERA_HEIGHT = Float.parseFloat((String) PROPERTIES.get("camera_height"));
        CAMERA_WIDTH = Float.parseFloat((String) PROPERTIES.get("camera_width"));
    }
}
