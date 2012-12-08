package com.mamepato.juegospiratas.framework;

import com.mamepato.juegospiratas.framework.Graphics.PixmapFormat;

public interface Pixmap {
	public int getWidth();
	public int getHeight();
	
	public PixmapFormat getFormat();
	public void dispose();
}
