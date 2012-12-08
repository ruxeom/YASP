package com.mamepato.juegospiratas.Game;

import java.util.List;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Graphics.PixmapFormat;
import com.mamepato.juegospiratas.framework.Input.TouchEvent;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;
import com.mamepato.juegospiratas.framework.implementation.AndroidPixmap;
import helpers.Types;

public class GameScreen extends Screen
{
	AndroidGame elGame;
	int screenWidth;
	int screenHeight;
	
	Grid gameGrid;
	int gridWidth;
	int gridHeight;
	int gridPositionX;
	int gridPositionY;

	int pBarPositionX;
	int pBarPositionY;
	int pBarWidth;
	int pBarHeight;

	AndroidPixmap saveButton;
	int saveButtonPositionX;
	int saveButtonPositionY;
	
	public GameScreen(Game game) {
		super(game);
		elGame = ((AndroidGame) game);
		elGame.setRenderView();
		gameGrid = new Grid(8, 8);
		gameGrid.populateGrid(5);
		screenWidth = elGame.getGraphics().getWidth();
		screenHeight = elGame.getGraphics().getHeight();
		initiateDimentions(screenWidth, screenHeight);
	}
	
	public GameScreen(Game game, Grid grid) {
		super(game);
		elGame = ((AndroidGame) game);
		elGame.setRenderView();
		gameGrid = grid;
		screenWidth = elGame.getGraphics().getWidth();
		screenHeight = elGame.getGraphics().getHeight();
		initiateDimentions(screenWidth, screenHeight);
	}
	
	private void initiateDimentions(int width, int height) {
		//Symetry in all things
		gridWidth = gridHeight = (int) (width * 0.8);
		int tenPercentX =   (int) (width * .1);
		int tenPercentY = (int) (height * .1);
		gridPositionX = tenPercentX;
		gridPositionY = tenPercentY;
		
		pBarPositionX = tenPercentX;
		pBarPositionY = gridPositionY + gridHeight + tenPercentY;
		pBarWidth = gridWidth;
		pBarHeight = tenPercentY;
		
//		saveButton = new AndroidPixmap(Assets.saveButton, PixmapFormat.RGB565);
//		saveButtonPositionX = (width- saveButton.getWidth())/2;
//		saveButtonPositionY = (height - saveButton.getHeight() - 10);		
	}

	@Override
	public void update(float deltaTime) {
		//logica
		List<TouchEvent> touchEvents = elGame.getInput().getTouchEvents();
		elGame.getInput().getKeyEvents();
        
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            /*TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 256 && event.y > 416 ) {
                    juego.setScreen(new PantallaAyuda2(juego));
                    if(Configuraciones.soundEnabled)
                        Assets.pulsar.play(1);
                    return;
                }
            }*/
        }
	}

	@Override
	public void present(float deltaTime) {
		//repaint
		int w = Assets.blueAndy.getWidth();
		int h = Assets.blueAndy.getHeight();
		int side = (w > h)? w : h;
		for(int row = 0; row < gameGrid.getRows(); row++)
			for(int col = 0; col < gameGrid.getColumns(); col++) {
				switch(gameGrid.getValue(row, col)) {
				case A:
					elGame.getGraphics().drawPixmap(Assets.blueAndy, 
							gridPositionX + side * row, gridPositionY + side * col, 0, 0, side, side);
					break;
					
				}
			}
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {

	}
}
