package org.example.lwp.template;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

public class MainScreen implements Screen {

	
	@Override
	public void show() {
		
	}
	
	@Override
	public void dispose() {
		
	}

	
	public void setPortrait(){
		Gdx.graphics.getGLCommon().glClearColor(1, 0, 0, 1);
	}
	
	public void setLandscape(){
		Gdx.graphics.getGLCommon().glClearColor(0, 0, 1, 1);
	}
	
	@Override
	public void render(float delta) {
		Gdx.graphics.getGLCommon().glClear(GL10.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}
