package com.mamepato.juegospiratas.framework.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.res.AssetManager;
import android.os.Environment;

import com.mamepato.juegospiratas.framework.FileIO;

public class AndroidFileIO implements FileIO
{
	AssetManager assetManager;
	String externalStoragePath;

	public AndroidFileIO(AssetManager assetManager)
	{
		this.assetManager = assetManager;
		this.externalStoragePath = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + File.separator;
	}

	public InputStream readAsset(String assetFileName) throws IOException
	{
		return assetManager.open(assetFileName);
	}

	public InputStream readFile(String fileName) throws IOException
	{
		return new FileInputStream(externalStoragePath + fileName);
	}

	public OutputStream writeFile(String fileName) throws IOException
	{
		return new FileOutputStream(externalStoragePath + fileName);
	}

}
