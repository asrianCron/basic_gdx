package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Cell {

	private Entity containedEntity;
	private Resource containedResource;
	public Cell() {
		this.containedEntity = null;
		this.containedResource = null;
	}

	public Cell(Entity ent) {
		this.containedEntity = ent;
	}

	public Cell(Resource res) {
		this.containedResource = res;
	}

	public Resource getResource() {
		return containedResource;
	}

	public void setResource(Resource resource) {
		this.containedResource = resource;
	}

	public Entity getEntity() {
		return containedEntity;
	}

	public void setEntity(Entity containedEntity) {
		this.containedEntity = containedEntity;
	}
	
	public Texture getCurrentTexture(){
		if(containedEntity != null){
			return containedEntity.getTexture();
		}
		if(containedResource != null){
			return containedResource.getTexture();
		}
		return AssetManager.getDefaultCelltexture();
	}
	
	/**
	 * 
	 * @return True if cell contains entity
	 */
	public boolean isOccupied() {
		return containedEntity != null;
	}
}
