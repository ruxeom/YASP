package com.mamepato.juegospiratas.Game;

import com.mamepato.juegospiratas.framework.FileIO;

public class Configuraciones {
	public static boolean soundEnabled = true;
	public static int[] highscores = new int[]{55,4,3,1};
	public static void load(FileIO files) {
		try {
			//readfile and set variables n' shit
		}
		catch(Exception e) {
			
		}
	}
	
	public static void save(FileIO files) {
		try {
			//save scores and game n' shit
		}
		catch(Exception e) {
			
		}
	}
}
