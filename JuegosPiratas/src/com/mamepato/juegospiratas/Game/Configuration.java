package com.mamepato.juegospiratas.Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.util.Log;

import com.mamepato.juegospiratas.framework.FileIO;

public class Configuration
{
	public static boolean soundEnabled;
	public static int currentScore = 5;
	public static int[] highScores = new int[5];
	public static int[][] gameGrid;

	static String var[] = new String[5];

	public static void load(FileIO files)
	{
		BufferedReader in = null;
		try
		{
			in = new BufferedReader(new InputStreamReader(
					files.readAsset("Config.yasp")));
			for (int i = 0; i < 4; i++)
			{
				var[i] = in.readLine();
			}

			checkAudio(var[0]);
			checkCurrentScore(var[1]);
			loadHighScores(var[2]);
			loadGame(var[3]);
		}
		catch (Exception e)
		{
			Log.v("", "Error en void load");
		}
		finally
		{
			try
			{
				if (in != null)
					in.close();
			}
			catch (IOException e)
			{

			}
		}
	}

	private static void checkAudio(String audio)
	{
		try
		{
			String[] a = audio.split(":");
			if (a[1] == "true")
			{
				soundEnabled = true;
			}
			else if (a[1] == "false")
			{
				soundEnabled = false;
			}
		}
		catch (NumberFormatException e)
		{
			Log.v("", "Error en void checkAudio");
		}
	}

	private static void checkCurrentScore(String score)
	{
		try
		{
			String[] a = score.split(":");
			currentScore = Integer.parseInt(a[1]);
		}
		catch (NumberFormatException e)
		{
			Log.v("", "Error en void checkCurrentScore");
		}
	}

	private static void loadHighScores(String scores)
	{
		try
		{
			String[] a = scores.split(":");
			String[] s = a[1].split(",");
			for (int i = 0; i < 5; i++)
			{
				highScores[i] = Integer.parseInt(s[i]);
			}
		}
		catch (NumberFormatException e)
		{
			Log.v("", "Error en void HighScores");
		}
	}

	private static void loadGame(String grid)
	{

	}

	public static void save(FileIO files)
	{
		BufferedWriter out = null;
		try
		{
			out = new BufferedWriter(new OutputStreamWriter(
					files.writeAsset("Config.yasp")));
			out.write("Sound:" + Boolean.toString(soundEnabled));
			out.write("\n");
			out.write("CurrentScore:" + Integer.toString(currentScore));
			out.write("\n");
			out.write("HighScores:");
			for (int i = 0; i < 5; i++)
			{
				out.write(highScores[i] + ",");
			}
			// GRID?
		}
		catch (Exception e)
		{

		}
	}
}
