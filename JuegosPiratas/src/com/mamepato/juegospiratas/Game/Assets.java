package com.mamepato.juegospiratas.Game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;

import com.mamepato.juegospiratas.framework.Pixmap;
import com.mamepato.juegospiratas.framework.Sound;
import com.mamepato.juegospiratas.framework.Graphics.PixmapFormat;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;
import com.mamepato.juegospiratas.framework.implementation.AndroidPixmap;
import com.mamepato.juegospiratas.framework.implementation.AndroidSound;

public class Assets {
	public static Pixmap backGround;
	public static Pixmap blueAndy;
	public static Pixmap greenAndy;
	public static Pixmap orangeAndy;
	public static Pixmap pinkAndy;
	public static Pixmap yellowAndy;
	public static Sound breakAndroidSound;
	
	public Assets(AndroidGame game) {
		Resources r = game.getResources();
		backGround = new AndroidPixmap(
				BitmapFactory.decodeResource(r, R.drawable.green_background), PixmapFormat.RGB565);
		blueAndy = new AndroidPixmap(
				BitmapFactory.decodeResource(r, R.drawable.blue_andy), PixmapFormat.RGB565);
		greenAndy = new AndroidPixmap(
				BitmapFactory.decodeResource(r, R.drawable.green_andy), PixmapFormat.RGB565);
		orangeAndy = new AndroidPixmap(
				BitmapFactory.decodeResource(r, R.drawable.orange_andy), PixmapFormat.RGB565);
		pinkAndy = new AndroidPixmap(
				BitmapFactory.decodeResource(r, R.drawable.pink_andy), PixmapFormat.RGB565);
		yellowAndy = new AndroidPixmap(
				BitmapFactory.decodeResource(r, R.drawable.yellow_andy), PixmapFormat.RGB565);
		breakAndroidSound = new AndroidSound(
				new SoundPool(20, AudioManager.STREAM_MUSIC, 0), R.raw.bomb);
	}
}
