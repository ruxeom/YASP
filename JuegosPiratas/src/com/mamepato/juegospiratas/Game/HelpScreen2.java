package com.mamepato.juegospiratas.Game;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

public class HelpScreen2 extends Screen
{
	Button menuButton;

	public HelpScreen2(Game game)
	{
		super(game);
		AndroidGame g = ((AndroidGame) game);
		g.setContentView(R.layout.activity_help2);
		menuButton = (Button) g.findViewById(R.id.buttonMenu);
		MenuButton(menuButton);
	}

	private void MenuButton(Button menuButton2)
	{
		menuButton.setOnClickListener(new OnClickListener() {
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
