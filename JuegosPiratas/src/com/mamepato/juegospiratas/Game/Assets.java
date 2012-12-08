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

public class Assets
{
	public static Pixmap backGround;
	public static Pixmap blueAndy;
	public static Pixmap greenAndy;
	public static Pixmap orangeAndy;
	public static Pixmap pinkAndy;
	public static Pixmap yellowAndy;
	public static Sound breakAndroidSound;

	public Assets(AndroidGame game) {
		Resources r = game.getResources();
		Bitmap b = BitmapFactory.decodeResource(r, R.drawable.blue_andy);
		int scale = game.getGraphics().getWidth()/10;
		
		
		b = Bitmap.createScaledBitmap(b, scale, scale, false);
		backGround = new AndroidPixmap(
				BitmapFactory.decodeResource(r, R.drawable.green_background), PixmapFormat.RGB565);
		blueAndy = new AndroidPixmap(
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.blue_andy), 
						scale, scale, false), PixmapFormat.ARGB4444);
		greenAndy = new AndroidPixmap(
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.green_andy), 
						scale, scale, false), PixmapFormat.ARGB4444);
		orangeAndy = new AndroidPixmap(
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.orange_andy), 
						scale, scale, false), PixmapFormat.ARGB4444);
		pinkAndy = new AndroidPixmap(
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.pink_andy), 
						scale, scale, false), PixmapFormat.ARGB4444);
		yellowAndy = new AndroidPixmap(
				Bitmap.createScaledBitmap(BitmapFactory.decodeResource(r, R.drawable.yellow_andy), 
						scale, scale, false), PixmapFormat.ARGB4444);
		breakAndroidSound = new AndroidSound(
				new SoundPool(20, AudioManager.STREAM_MUSIC, 0), R.raw.bomb);
	}
}
