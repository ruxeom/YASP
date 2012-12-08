package com.mamepato.juegospiratas.Game;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

public class GameScreen extends Screen
{

	public GameScreen(Game game)
	{
		super(game);
		AndroidGame g = ((AndroidGame) game);
		g.setContentView(R.layout.activity_game);
	}

	@Override
	public void update(float deltaTime)
	{
	}

	@Override
	public void present(float deltaTime)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}

	@Override
	public void dispose()
	{

	}
}
