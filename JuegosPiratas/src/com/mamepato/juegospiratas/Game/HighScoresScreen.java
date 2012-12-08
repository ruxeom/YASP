package com.mamepato.juegospiratas.Game;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

public class HighScoresScreen extends Screen
{
	Button backButton;

	public HighScoresScreen(Game game)
	{
		super(game);
		AndroidGame g = ((AndroidGame) game);
		g.setContentView(R.layout.activity_high_scores);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void present(float deltaTime)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}
}
