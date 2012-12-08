package com.mamepato.juegospiratas.Game;

import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

import android.os.Bundle;
import android.util.Log;

public class YASPGame extends AndroidGame
{
	@Override
	public void onCreate(Bundle instance)
	{
		super.onCreate(instance);
		Log.v("", "WIIII: " + Configuration.currentScore);
		Configuration.load(getFileIO());

		if (Configuration.soundEnabled)
			Log.v("", "* Audio: true");
		else
			Log.v("", "* Audio: false");
		Log.v("", "* Current score: " + Configuration.currentScore);
		for (int i = 0; i < Configuration.highScores.length; i++)
			Log.v("", "" + Configuration.highScores[i]);
	}

	@Override
	public Screen getStartScreen()
	{
		return new MainMenuScreen(this);
	}

}
