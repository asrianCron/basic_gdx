package com.mygdx.game;

public class GridManager {
	
	private Grid grid;
	
	public GridManager(){
		this.grid = new Grid();
	}
	public void init(int width, int height){
		this.grid = new Grid(width, height);
	}
		
}
