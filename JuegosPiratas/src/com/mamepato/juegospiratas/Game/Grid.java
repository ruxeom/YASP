package com.mamepato.juegospiratas.Game;

import java.util.*;
import helpers.Types;

public class Grid
{
    private int side;
    private Types[][] grid;
    private int rows;
    private int columns;
    
    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.side = rows;
        grid = new Types[rows][columns];
    }
    
    public void populateGrid(int amountOfFigures) {
    	Random r = new Random();
    	
    	if(amountOfFigures > 5 || amountOfFigures < 2)
    		throw new IllegalArgumentException(
    				"Grid.populateGrid(int) cannot accept values less " +
    				"than 2 or greater than the amount of resources.");
    	
    	for (int i = 0; i < side; i++) {
            boolean checkrow = (i > 1) ? true : false;
            for (int j = 0; j < side; j++) {
                boolean checkcol = (j > 1) ? true : false;
                boolean rowok, colok;
                rowok = colok = false;
                while (!colok || !rowok) {
                    switch (r.nextInt(amountOfFigures)) {
                        case 0:
                        	grid[i][j] = Types.A;
                            break;
                        case 1:
                        	grid[i][j] = Types.B;
                            break;
                        case 2:
                        	grid[i][j] = Types.C;
                            break;
                        case 3:
                        	grid[i][j] = Types.D;
                            break;
                        case 4:
                        	grid[i][j] = Types.E;
                            break;
                    }
                   
                    Types val = grid[i][j];
                    if (checkcol) {
                        if (val == grid[i][j - 2] && val == grid[i][j - 1])
                            rowok = false;
                        else
                            rowok = true;
                    }
                   else
                        rowok = true;
                    if (checkrow) {
                        if (val == grid[i - 2][j] && val == grid[i - 2][j])
                            colok = false;
                        else
                            colok = true;
                    }
                    else
                        colok = true;
                }
            }
        }
    }
    public boolean gridHasPossibleMoves() {
        for (int row = 0; row < side; row++) {
            for (int col = 0; col < side; col++)
                if(hasMove(row,col))
                	return true;
        }
        return false;
    }
    
    public boolean hasMove(int row, int col) {
    	Types value = grid[row][col];
        //upwards
        if (row > 2)
            if (piecesInArea(row - 3, col, 1, 4, value) > 2)
                return true;
        if (row >= 2 && col < side - 1) 
            if (piecesInArea(row - 2, col, 2, 1, value) +
                piecesInArea(row - 1, col, 2, 1, value) +
                piecesInArea(row, col, 2, 1, value) > 2)
                return true;
        
        if (row >= 2 && col > 0) {
            if (piecesInArea(row - 2, col -1, 2, 1, value) +
                piecesInArea(row - 1, col - 1, 2, 1, value) +
                piecesInArea(row, col - 1, 2, 1, value) > 2)
                return true;
        }
        if (row < side - 1 && col < side - 2) {
            if (piecesInArea(row, col, 1, 2, value) +
                piecesInArea(row, col + 1, 1, 2, value) +
                piecesInArea(row, col + 2, 1, 2, value) > 2)
                return true;
        }
        if (row > 0 && col < side - 2) {
            if (piecesInArea(row - 1, col, 1, 2, value) +
                piecesInArea(row - 1, col + 1, 1, 2, value) +
                piecesInArea(row - 1, col + 2, 1, 2, value) > 2)
                return true;
        }
        if (row < side - 1 && col >= 2) {
            if (piecesInArea(row, col - 2, 1, 2, value) +
                piecesInArea(row, col - 1, 1, 2, value) +
                piecesInArea(row, col, 1, 2, value) > 2)
                return true;
        }
        if (row > 0 && col > 1) {
            if (piecesInArea(row - 1, col - 2, 1, 2, value) +
                piecesInArea(row - 1, col - 1, 1, 2, value) +
                piecesInArea(row - 1, col, 1, 2, value) > 2)
                return true;
        }
        if (row < side - 2 && col < side - 1) {
            if (piecesInArea(row, col, 2, 1, value) +
                piecesInArea(row + 1, col, 2, 1, value) +
                piecesInArea(row + 2, col, 2, 1, value) > 2)
                return true;
        }
        if (row < side - 2 && col > 0) {
            if (piecesInArea(row, col - 1, 2, 1, value) +
                piecesInArea(row + 1, col - 1, 2, 1, value) +
                piecesInArea(row + 2, col - 1, 2, 1, value) > 2)
                return true;
        }
        if (row > side - 3)
            if (piecesInArea(row, col, 1, 4, value) > 2)
                return true;
        if(col < side-3)
            if (piecesInArea(row, col, 4, 1, value) > 2)
                return true;
        if (col > 2)
            if (piecesInArea(row, col - 3, 4, 1, value) > 2)
                return true;
        
        return false;
    }

    public int piecesInArea(int row, int column, int width, int height, Types value) {
        int amount = 0;

        for (int i = row; i < row + height; i++)
            for (int j = column; j < column + width; j++)
                if (value == grid[i][j])
                    amount++;

        return amount;
    }
    
    public int getRows() {
    	return this.rows;
    }
    
    public int getColumns() {
    	return this.columns;
    }
    
    public Types getValue(int row, int column) {
    	return grid[row][column];
    }
}