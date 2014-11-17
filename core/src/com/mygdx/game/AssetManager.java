package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class AssetManager {
	private static final Texture defaultCellTexture = new Texture("cell32.png");
	private static final Texture defaultEntityTexture = new Texture("defaultEntity32.png");
	private static final Texture defaultFoodTexture = new Texture("defaultFood32.png");
	
	public static Texture getDefaultCelltexture() {
		return defaultCellTexture;
	}
	public static Texture getDefaultEntitytexture() {
		return defaultEntityTexture;
	}
	public static Texture getDefaultFoodtexture() {
		return defaultFoodTexture;
	}
	
}
