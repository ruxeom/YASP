package com.mamepato.juegospiratas.Game;

import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

import android.os.Bundle;
import android.util.Log;

public class TestActivity extends AndroidGame
{
	@Override
	public void onCreate(Bundle instance)
	{
		super.onCreate(instance);
		Log.v("", "funciona   gente");
	}

	@Override
	public Screen getStartScreen()
	{
		return new MainMenuScreen(this);
	}

}
