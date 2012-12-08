package com.mamepato.juegospiratas.framework.implementation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AndroidFastRenderView extends SurfaceView implements Runnable
{
	AndroidGame game;
	Bitmap frameBuffer;
	Thread renderThread = null;

	SurfaceHolder holder;

	volatile boolean running = false;

	public AndroidFastRenderView(AndroidGame game, Bitmap frameBuffer)
	{
		super(game);
		this.game = game;
		this.frameBuffer = frameBuffer;
		this.holder = getHolder();
	}

	public AndroidFastRenderView(Context context)
	{
		super(context);
	}

	public void resume()
	{
		running = true;
		renderThread = new Thread(this);
		renderThread.start();
	}

	public void pause()
	{
		running = false;
		while (true)
		{
			try
			{
				renderThread.join();
				break;
			}
			catch (InterruptedException ie)
			{
				ie.printStackTrace();
			}
		}
	}

	public void run()
	{
		Rect rect = new Rect();
		long startTime = System.nanoTime();

		while (running)
		{
			if (!holder.getSurface().isValid())
				continue;

			float deltaTime = (float) ((System.nanoTime() - startTime) / 1E-6); // nano

			startTime = System.nanoTime();
			game.getCurrentScreen().update(deltaTime);
			game.getCurrentScreen().present(deltaTime);
			Canvas canvas = holder.lockCanvas();
			canvas.getClipBounds(rect);
			canvas.drawBitmap(frameBuffer, null, rect, null);
			holder.unlockCanvasAndPost(canvas);
		}
	}

}
