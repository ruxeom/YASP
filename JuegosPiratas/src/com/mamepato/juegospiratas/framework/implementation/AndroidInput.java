package com.mamepato.juegospiratas.framework.implementation;

import java.util.List;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;

import com.mamepato.juegospiratas.framework.Input;

public class AndroidInput implements Input
{
	AccelerometerHandler acelHandler;
	KeyBoardHandler keyHandler;
	TouchHandler touchHandler;

	@SuppressWarnings("deprecation")
	public AndroidInput(Context context, View view, float scaleX, float scaleY)
	{
		this.acelHandler = new AccelerometerHandler(context);
		this.keyHandler = new KeyBoardHandler(view);

		// VERSION.SDK_INT
		if (Integer.parseInt(VERSION.SDK) < 5)
		{
			this.touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
		}
		else
		{
			this.touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
		}
	}

	public boolean isKeyPressed(int keyCode)
	{
		return keyHandler.isKeyPressed(keyCode);
	}

	public boolean isTouchDown(int pointer)
	{
		return touchHandler.isTouchDown(pointer);
	}

	public int getTouchX(int pointer)
	{
		return touchHandler.getTouchX(pointer);
	}

	public int getTouchY(int pointer)
	{
		return touchHandler.getTouchY(pointer);
	}

	public float getAccelX()
	{
		return acelHandler.getAccelX();
	}

	public float getAccelY()
	{
		return acelHandler.getAccelY();
	}

	public float getAccelZ()
	{
		return acelHandler.getAccelZ();
	}

	public List<KeyEvent> getKeyEvents()
	{
		return keyHandler.getKeyEvents();
	}

	public List<TouchEvent> getTouchEvents()
	{
		return touchHandler.getTouchEvents();
	}

}
