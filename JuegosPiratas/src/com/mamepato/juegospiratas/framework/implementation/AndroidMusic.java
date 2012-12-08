package com.mamepato.juegospiratas.framework.implementation;

import java.io.IOException;

import com.mamepato.juegospiratas.framework.Music;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class AndroidMusic implements Music, OnCompletionListener
{
	MediaPlayer mp;
	boolean isPrepared;

	public AndroidMusic(AssetFileDescriptor asf)
	{
		mp = new MediaPlayer();
		try
		{
			mp.setDataSource(asf.getFileDescriptor(), asf.getStartOffset(),
					asf.getLength());
			mp.prepare();
			isPrepared = true;
			mp.setOnCompletionListener(this);
		}
		catch (Exception ex)
		{
			throw new RuntimeException("No se ha podido cargar la musica");
		}
	}

	public void play()
	{
		if (mp.isPlaying())
			return;
		try
		{
			synchronized (this)
			{
				if (!isPrepared)
					mp.prepare();
				mp.start();
			}
		}
		catch (IllegalStateException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void stop()
	{
		mp.stop();
		synchronized (this)
		{
			isPrepared = false;
		}
	}

	public void pause()
	{
		if (mp.isPlaying())
			mp.pause();
	}

	public void setLooping(boolean looping)
	{
		mp.setLooping(looping);
	}

	public void setVolume(float volumen)
	{
		mp.setVolume(volumen, volumen);
	}

	public boolean isPlaying()
	{
		return mp.isPlaying();
	}

	public boolean isStopped()
	{
		return !isPrepared;
	}

	public boolean isLooping()
	{
		return mp.isLooping();
	}

	public void dispose()
	{
		if (mp.isPlaying())
			mp.stop();
		mp.release();
	}

	public void onCompletion(MediaPlayer mediaPlayer)
	{
		synchronized (this)
		{
			isPrepared = false;
		}
	}

}
