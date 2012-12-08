package com.mamepato.juegospiratas.Game;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ToggleButton;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

public class MainMenuScreen extends Screen
{
	Button playButton;
	Button resumeButton;
	Button scoreButton;
	Button helpButton;

	ToggleButton audioButton;

	public MainMenuScreen(Game game)
	{
		super(game);
		AndroidGame g = ((AndroidGame) game);
		g.setContentView(R.layout.activity_main_menu);

		playButton = (Button) g.findViewById(R.id.playButton);
		resumeButton = (Button) g.findViewById(R.id.resumeButton);
		scoreButton = (Button) g.findViewById(R.id.scoreButton);
		helpButton = (Button) g.findViewById(R.id.helpButton);

		audioButton = (ToggleButton) g.findViewById(R.id.audioToggleButton);

		PlayClick(playButton);
		ResumeClick(resumeButton);
		HighScoreClick(scoreButton);
		HelpClick(helpButton);
	}

	@Override
	public void update(float deltaTime)
	{
	}

	@Override
	public void present(float deltaTime)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}

	@Override
	public void dispose()
	{
	}

	// button2.setOnClickListener(new OnClickListener() {
	// public void onClick(View v)
	// {
	// startActivity(new Intent(getApplicationContext(),
	// ActivityTwo.class));
	// overridePendingTransition(R.anim.slide_in_left,
	// R.anim.slide_out_left);
	// finish();
	// }
	// });

	private void PlayClick(Button playButton)
	{
		playButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				game.setScreen(new GameScreen(game));
			}
		});
	}

	private void ResumeClick(Button resumeButton)
	{

	}

	public void HighScoreClick(View scoreButton)
	{
		scoreButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				game.setScreen(new HighScoresScreen(game));
			}
		});
	}

	public void HelpClick(View helpButton)
	{
		helpButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				game.setScreen(new HelpScreen1(game));
			}
		});
	}

}
