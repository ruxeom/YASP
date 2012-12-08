package com.mamepato.juegospiratas.Game;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;

public class HelpScreen1 extends Screen
{
	Button nextButton;

	public HelpScreen1(Game game)
	{
		super(game);
		AndroidGame g = ((AndroidGame) game);
		g.setContentView(R.layout.activity_help1);
		nextButton = (Button) g.findViewById(R.id.buttonNext);
		NextButton(nextButton);
	}

	private void NextButton(Button nextButton2)
	{
		nextButton2.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				game.setScreen(new HelpScreen2(game));
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
