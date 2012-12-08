package com.mamepato.juegospiratas.Game;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

public class HighScoresScreen extends Screen
{
	Button backButton;
	TextView textViewHighScores;
	String scores = "";

	public HighScoresScreen(Game game)
	{
		super(game);
		AndroidGame g = ((AndroidGame) game);
		g.setContentView(R.layout.activity_high_scores);

		textViewHighScores = (TextView) g.findViewById(R.id.textView);
		for (int i = 0; i < Configuration.highScores.length; i++)
		{
			scores += (i + 1) + ")  " + Configuration.highScores[i] + "\n";
		}
		textViewHighScores.setText(scores);
		backButton = (Button) g.findViewById(R.id.buttonBack);
		BackButton(backButton);
	}

	private void BackButton(Button backButton)
	{
		backButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				game.setScreen(new MainMenuScreen(game));
			}
		});
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
}
