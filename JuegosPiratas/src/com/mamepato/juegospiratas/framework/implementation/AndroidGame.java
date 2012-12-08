package com.mamepato.juegospiratas.framework.implementation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.Window;
import android.view.WindowManager;

import com.mamepato.juegospiratas.framework.Audio;
import com.mamepato.juegospiratas.framework.FileIO;
import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Graphics;
import com.mamepato.juegospiratas.framework.Input;
import com.mamepato.juegospiratas.framework.Screen;

public class AndroidGame extends Activity implements Game
{
	AndroidFastRenderView renderView;
	Screen screen;
	Graphics graphics;
	Audio audio;
	FileIO fileIO;
	Input input;

	PowerManager.WakeLock wakeLock;

	@SuppressWarnings("deprecation")
	public void onCreate(Bundle instance)
	{
		super.onCreate(instance);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		boolean isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

		int frameBufferWidth = isLandscape ? 480 : 320;
		int frameBufferHeight = isLandscape ? 320 : 480;
		Bitmap frameBuffer = Bitmap.createBitmap(frameBufferWidth,
				frameBufferHeight, Config.RGB_565);
		float scaleX = (float) (frameBufferWidth / getWindowManager()
				.getDefaultDisplay().getWidth());
		float scaleY = (float) (frameBufferHeight / getWindowManager()
				.getDefaultDisplay().getHeight());

		renderView = new AndroidFastRenderView(this, frameBuffer);
		graphics = new AndroidGraphics(getAssets(), frameBuffer);
		fileIO = new AndroidFileIO(getAssets());
		audio = new AndroidAudio(this);
		input = new AndroidInput(this, renderView, scaleX, scaleY);

		screen = getStartScreen();
		//setContentView(renderView);

		PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "Game Lock");
	}

	public FileIO getFileIO()
	{
		return fileIO;
	}

	public Graphics getGraphics()
	{
		return graphics;
	}

	public Input getInput()
	{
		return input;
	}

	public Audio getAudio()
	{
		return audio;
	}

	public Screen getCurrentScreen()
	{
		return screen;
	}

	public Screen getStartScreen()
	{
		return null;
	}

	public void setScreen(Screen screen)
	{
		if (screen == null)
		{
			throw new IllegalArgumentException("Can't set a null game Screen.");
		}
		this.screen.pause();
		this.screen.dispose();
		screen.resume();
		screen.update(0);
		this.screen = screen;
	}

	@Override
	public void onPause()
	{
		super.onPause();
		wakeLock.release();
		renderView.pause();
		screen.pause();

		if (isFinishing())
		{
			screen.dispose();
		}
	}

	@Override
	public void onResume()
	{
		super.onResume();
		wakeLock.acquire();
		screen.resume();
		renderView.resume();
	}
	
	public void setRenderView() {
		setContentView(renderView);	
	}

}
