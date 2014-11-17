package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Entity extends Sprite{
	
	private double energy;
	private static Texture defaultTexture = AssetManager.getDefaultEntitytexture();
	private static double defaultEnergy = 100;
	public Entity(Texture tex) {
		super(tex);
		this.energy = defaultEnergy;
	}
	
	public Entity(double energy){
		super(defaultTexture);
		this.energy = energy;
	}

}
