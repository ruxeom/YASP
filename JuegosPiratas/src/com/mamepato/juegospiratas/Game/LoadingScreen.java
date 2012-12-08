package com.mamepato.juegospiratas.Game;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Screen;

public class LoadingScreen extends Screen
{

	public LoadingScreen(Game juego)
	{
		super(juego);
	}

	// Graficos g = juego.getGraphx();
	// Assets.nombreasset = g.newPixmap("nombreimagen.png",
	// PirxmapFormat.RGB565);
	// Configuraciones.load(juego.getFIleIO());
	// juego.setScreen(new MainMenuScreen(juego));

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

	/*
	 * OVERRIDESSS?
	 */

	// en present se hace el drawPixmap thingie
}
