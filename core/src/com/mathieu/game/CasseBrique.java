package com.mathieu.game;

import com.badlogic.gdx.Game;
import com.mathieu.game.screen.ConfigScreen;

public class CasseBrique extends Game {

	@Override
	public void create() {
		this.setScreen(new ConfigScreen(this));
	}
}
