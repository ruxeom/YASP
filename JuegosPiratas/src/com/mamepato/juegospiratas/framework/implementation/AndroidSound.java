package com.mamepato.juegospiratas.framework.implementation;

import android.media.SoundPool;

import com.mamepato.juegospiratas.framework.Sound;

public class AndroidSound implements Sound
{
	int soundId;
	SoundPool soundPool;

	public AndroidSound(SoundPool sp, int soundId)
	{
		this.soundPool = sp;
		this.soundId = soundId;
	}

	public void play(float volume)
	{
		soundPool.play(soundId, volume, volume, 0, 0, 1);
	}

	public void dispose()
	{
		soundPool.unload(soundId);
	}
}
