package com.mathieu.game;

import com.badlogic.gdx.Game;
import com.mathieu.game.Screen.GameScreen;

public class CasseBrique extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
