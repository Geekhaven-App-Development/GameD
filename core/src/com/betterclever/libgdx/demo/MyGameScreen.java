package com.betterclever.libgdx.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by betterclever on 1/28/2017.
 */

public class MyGameScreen implements Screen {
	
	ExtendViewport viewport;
	ShapeRenderer shapeRenderer;
	
	float radius = 10;
	
	@Override
	public void show() {
		viewport = new ExtendViewport(Constants.WORLD_WIDTH,Constants.WORLD_HEIGHT);
		shapeRenderer = new ShapeRenderer();
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		radius += 10*delta;
		
		viewport.apply();
		shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
		
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.circle(Constants.WORLD_WIDTH/2,Constants.WORLD_HEIGHT/2,radius,256);
		shapeRenderer.end();
	}
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width,height,true);
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	@Override
	public void hide() {
		
	}
	
	@Override
	public void dispose() {
		
	}
}
