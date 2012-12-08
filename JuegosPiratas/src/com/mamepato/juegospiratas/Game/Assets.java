package com.mamepato.juegospiratas.Game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.mamepato.juegospiratas.framework.Pixmap;
import com.mamepato.juegospiratas.framework.Sound;
import com.mamepato.juegospiratas.framework.Graphics.PixmapFormat;
import com.mamepato.juegospiratas.framework.implementation.AndroidPixmap;

public class Assets {
	public static Pixmap backGround;
	public static Pixmap blueAndy;
	public static Pixmap greenAndy;
	public static Pixmap orangeAndy;
	public static Pixmap pinkAndy;
	public static Pixmap yellowAndy;
	public static Sound breakAndroidSound;
	
	public Assets() {
		backGround = new AndroidPixmap(BitmapFactory.decodeResource(getResources(), id), PixmapFormat.RGB565);
	}
}
