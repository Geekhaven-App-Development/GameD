package com.betterclever.libgdx.demo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by betterclever on 1/28/2017.
 */

public class MyGameScreen extends InputAdapter implements Screen {
	
	ExtendViewport viewport;
	ShapeRenderer shapeRenderer;
	
	Array<Ball> balls;
	
	@Override
	public void show() {
		viewport = new ExtendViewport(Constants.WORLD_WIDTH,Constants.WORLD_HEIGHT);
		shapeRenderer = new ShapeRenderer();
		
		balls = new Array<Ball>();
		
		Gdx.input.setInputProcessor(this);
		for (int i = 0; i < 5; i++) {
			balls.add(new Ball(shapeRenderer));
		}
	}
	
	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		viewport.apply();
		shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
		
		for(Ball b: balls){
			b.render(delta);
		}
		
		for (int i = 0; i < balls.size; i++) {
			for (int j = i+1; j < balls.size ; j++) {
				Ball b1 = balls.get(i);
				Ball b2 = balls.get(j);
				if(b1.bounds.overlaps(b2.bounds)){
					Vector2 temp = b1.velocity.cpy();
					b1.velocity = b2.velocity;
					b2.velocity = temp;
				}
			}
		}
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
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.SPACE){
			balls.add(new Ball(shapeRenderer));
		}
		
		return super.keyDown(keycode);
	}
}
