package com.mamepato.juegospiratas.framework;

public interface Game
{
	public FileIO getFileIO();

	public Graphics getGraphics();

	public Input getInput();

	public Audio getAudio();

	public Screen getCurrentScreen();

	public Screen getStartScreen();

	public void setScreen(Screen screen);
}
