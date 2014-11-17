package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Grid {

	private Cell[][] cells;
	private int width;
	private int height;

	public Grid() {
		this.width = 0;
		this.height = 0;
		this.cells = new Cell[width][height];
	}

	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new Cell[width][height];
		for (int i = 0; i < cells.length; i++) {
			this.cells[i] = new Cell[width];
			for (int j = 0; j < cells[i].length; j++) {
				this.cells[i][j] = new Cell();
			}
		}
	}
	
	public Cell[][] getCells() {
		return cells;
	}

	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void update(){
		
	}
	public void setCell(int x, int y, Cell cell) {
		if (x > this.width -1 || x < 0) {
			throw new IndexOutOfBoundsException("Coordinate X is out of bounds");
		}
		if (y > this.height -1 || y < 0) {
			throw new IndexOutOfBoundsException("Coordinate Y is out of bounds");
		}
		this.cells[x][y] = cell;
	}
	public Cell getCell(int x, int y) {
		if (x > this.width-1 || x < 0) {
			throw new IndexOutOfBoundsException("Coordinate X is out of bounds");
		}
		if (y > this.height-1 || y < 0) {
			throw new IndexOutOfBoundsException("Coordinate Y is out of bounds");
		}
		return this.cells[x][y];
	}
	public void drawToBatch(SpriteBatch batch) {
		int x = 0;
		int y = 0;
		int toAdd = 32;
		toAdd += MyGdxGame.zoom * 3;
		for (int i = 0; i < cells.length; ++i) {
			for (int j = cells[i].length - 1; j >= 0; --j) {
				batch.draw(cells[i][j].getCurrentTexture(), x, y);
				y+=toAdd;
			}
			y = 0;
			x+=toAdd;
		}
	}
}
