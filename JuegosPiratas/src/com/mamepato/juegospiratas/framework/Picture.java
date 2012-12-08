package com.mamepato.juegospiratas.framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public interface Picture {
	
	//This would internally use the FileIO interface and the BitmapFactory
	public Bitmap getImageFromPath(String path);
	
	public Bitmap getImageFromResourse(int resourceId);
	
	public void drawBitmap(Canvas canvas, Bitmap image, int x, int y, int alpha);
	
}
