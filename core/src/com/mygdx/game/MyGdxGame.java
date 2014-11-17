package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Grid grid;
	private OrthographicCamera camera;
	public Entity defaultEntity;
	public static float zoom;
	private static long startTime = 0;

	@Override
	public void create() {
		defaultEntity = new Entity(100);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1024, 768);
		batch = new SpriteBatch();
		grid = new Grid(25, 25);
		grid.setCell(1, 1, new Cell(new Resource(123134, 2353453)));
		grid.setCell(0, 0, new Cell(new Entity(9001)));
		MyGdxGame.startTime = TimeUtils.nanoTime();
	}

	@Override
	public void render() {
		poolInput();
		update();
		camera.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		grid.update();
		grid.drawToBatch(batch);
		batch.end();
	}

	public void update() {
		if (checkTime(1)) {
			try {
				grid.getCell(randInt(0, grid.getHeight()),
						randInt(0, grid.getWidth())).setEntity(new Entity(100));
			} catch (Throwable ex) {
				ex.printStackTrace();
			}
		}
	}

	public static int randInt(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}

	public void poolInput() {

		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.translate(-10, 0);
		} else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			camera.translate(10, 0);
		} else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			camera.translate(0, 10);
		} else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			camera.translate(0, -10);
		} else if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			camera.zoom += 0.05;
		} else if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			camera.zoom -= 0.05;
		}
		MyGdxGame.zoom = camera.zoom;
	}

	public boolean checkTime(long ms) {
		if ((TimeUtils.nanoTime() - MyGdxGame.startTime) > ms * 1000000) {
			MyGdxGame.startTime = TimeUtils.nanoTime();
			return true;
		}
		return false;
	}

}
