package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Resource extends Sprite{
	
	private double food;
	private double water;
	private static Texture defaultTexture = AssetManager.getDefaultFoodtexture();
	public Resource(){
		super(defaultTexture);
		this.food = 0;
		this.water = 0;
	}
	
	public Resource(double food, double water){
		super(defaultTexture);
		this.food = food;
		this.water = water;
	}

	public double getFood() {
		return food;
	}

	public void setFood(double food) {
		this.food = food;
	}

	public double getWater() {
		return water;
	}

	public void setWater(double water) {
		this.water = water;
	}
	
	public Texture getTexture(){
		return Resource.defaultTexture;
	}
	
	
}
