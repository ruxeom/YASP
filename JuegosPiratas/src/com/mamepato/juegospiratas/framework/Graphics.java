package com.mamepato.juegospiratas.framework;

public interface Graphics {
	public static enum PixmapFormat {
		ARGB8888, ARGB4444, RGB565
	}
	
	public Pixmap newPixmap(String fileName, PixmapFormat format);
	public void clear(int color);
	public void drawPixel(int x, int y, int color);
	public void drawLine(int xi, int yi, int xf, int yf, int color);
	public void drawRectangle(int xi, int yi, int width, int height, int color);
	public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);
	public void drawPixmap(Pixmap pixmap, int x, int y);
	public int getWidth();
	public int getHeight();
}
