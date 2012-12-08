package com.mamepato.juegospiratas.framework.implementation;

import java.io.IOException;

import com.mamepato.juegospiratas.framework.Audio;
import com.mamepato.juegospiratas.framework.Music;
import com.mamepato.juegospiratas.framework.Sound;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

public class AndroidAudio implements Audio
{
	AssetManager assets;
	SoundPool soundPool;

	public AndroidAudio(Activity activity)
	{
		activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
		this.assets = activity.getAssets();
		this.soundPool = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);
	}

	public Music nuevaMusica(String fileName)
	{
		try
		{
			AssetFileDescriptor asf = assets.openFd(fileName);
			return new AndroidMusic(asf);
		}
		catch (IOException ex)
		{
			throw new RuntimeException("El audio no se ha podido reproducir");
		}
	}

	public Sound newSound(String fileName)
	{
		try
		{
			AssetFileDescriptor asf = assets.openFd(fileName);
			int soundId = soundPool.load(asf, 0);
			return new AndroidSound(soundPool, soundId);
		}
		catch (IOException ex)
		{
			throw new RuntimeException("El audio no se ha podido reproducir");
		}
	}

}
