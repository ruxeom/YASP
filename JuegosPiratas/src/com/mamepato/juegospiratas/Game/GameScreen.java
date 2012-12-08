package com.mamepato.juegospiratas.Game;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.util.Pair;

import com.mamepato.juegospiratas.framework.Game;
import com.mamepato.juegospiratas.framework.Graphics;
import com.mamepato.juegospiratas.framework.Graphics.PixmapFormat;
import com.mamepato.juegospiratas.framework.Input.TouchEvent;
import com.mamepato.juegospiratas.framework.Screen;
import com.mamepato.juegospiratas.framework.implementation.AndroidGame;
import com.mamepato.juegospiratas.framework.implementation.AndroidGraphics;
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
	
	int startScore = 0;
	int actualScore = 0;
	int endScore = 100;
	
	int downRow;
	int downCol;
	int upRow;
	int upCol;
	
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
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_DOWN) {
            	if(event.x >= gridPositionX && event.x <= gridPositionX + gridWidth &&
            			event.y >= gridPositionY && event.y <= gridPositionY + gridHeight) {
            		downCol = translateCoordinatesToCol(event.x);
            		downRow = translateCoordinatesToRow(event.y);
            	}
            }
            if(event.type == TouchEvent.TOUCH_UP) {
            	if(event.x >= gridPositionX && event.x <= gridPositionX + gridWidth &&
            			event.y >= gridPositionY && event.y <= gridPositionY + gridHeight) {
            		upCol = translateCoordinatesToCol(event.x);
            		upRow = translateCoordinatesToRow(event.y);
            		calculateNewBoard(downRow, downCol, upRow, upCol);
            	}
            }
        	if(actualScore >= endScore) {
        		startScore = endScore;
        	}
        }
	}
	
	public void calculateNewBoard(int dRow, int dCol, int uRow, int uCol) {
		Grid copy = gameGrid.clone();
		Types down = gameGrid.getValue(dRow, dCol);
		Types up = gameGrid.getValue(uRow, uCol);
		copy.setValue(uRow, uCol, down);
		copy.setValue(dRow, dCol, up);
    	ArrayList<Pair<Integer, Integer>> affectedCells = new ArrayList<Pair<Integer, Integer>>();
		if(copy.hasTrio(dRow,dCol)) {
			actualScore += copy.breakPieces(dRow, dCol, affectedCells) * 10;
		}
		if(copy.hasTrio(uRow, uCol)) {
			actualScore += copy.breakPieces(uRow, uCol, affectedCells) * 10;
		}
	}
	
	public int translateCoordinatesToCol(int x) {
		return (x-gridPositionX)/(gridWidth/gameGrid.getColumns());
	}
	
	public int translateCoordinatesToRow(int y) {
		return (y-gridPositionY)/(gridHeight/gameGrid.getRows());
	}

	@Override
	public void present(float deltaTime) {
		//repaint
		int w = Assets.blueAndy.getWidth();
		int h = Assets.blueAndy.getHeight();
		Graphics graphics = elGame.getGraphics();
		int side = (w > h)? w : h;
		for(int row = 0; row < gameGrid.getRows(); row++)
			for(int col = 0; col < gameGrid.getColumns(); col++) {
				switch(gameGrid.getValue(row, col)) {
				case A:
					graphics.drawPixmap(Assets.blueAndy, 
							gridPositionX + side * row, gridPositionY + side * col, 0, 0, side, side);
					break;
				case B:
					graphics.drawPixmap(Assets.greenAndy, 
							gridPositionX + side * row, gridPositionY + side * col, 0, 0, side, side);
					break;
				case C:
					graphics.drawPixmap(Assets.orangeAndy, 
							gridPositionX + side * row, gridPositionY + side * col, 0, 0, side, side);
					break;
				case D:
					graphics.drawPixmap(Assets.pinkAndy, 
							gridPositionX + side * row, gridPositionY + side * col, 0, 0, side, side);
					break;
				case E:
					graphics.drawPixmap(Assets.yellowAndy, 
							gridPositionX + side * row, gridPositionY + side * col, 0, 0, side, side);
					break;
					
				}
			}
		graphics.drawRectangle(pBarPositionX, pBarPositionY, pBarWidth, pBarHeight, Color.DKGRAY);
		graphics.drawRectangle(pBarPositionX, pBarPositionY, (actualScore-startScore)*pBarWidth / (endScore-startScore), pBarHeight, Color.MAGENTA);
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
