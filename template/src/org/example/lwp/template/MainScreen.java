package org.example.lwp.template;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MainScreen implements Screen {

	public boolean canScroll = false;
	public boolean isPreview = false;
	public Vector3 scrollPosition = new Vector3();
	
	private Camera camera;
	private SpriteBatch batch;
	private BitmapFont font;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(0, 0, 1);
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		font.dispose();
	}

	public void setPortrait(){
		Gdx.graphics.getGLCommon().glClearColor(0.5f, 0, 0, 1);
	}
	
	public void setLandscape(){
		Gdx.graphics.getGLCommon().glClearColor(0, 0, 0.5f, 1);
	}
	
	@Override
	public void render(float delta) {
		
		if (this.canScroll){
			// variable position
			this.camera.position.set(this.scrollPosition);	
		}else{
			// set static position
			this.camera.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 1);
		}
		
		this.camera.update();
		this.camera.apply(Gdx.graphics.getGL10());
		
		Gdx.graphics.getGLCommon().glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.batch.setProjectionMatrix(this.camera.combined);
		this.batch.begin();
		
		if (this.isPreview){
			this.font.draw(this.batch, "Preview", 0, 0);
		}
		
		if (this.canScroll){
			this.font.draw(this.batch, "Position: " + this.scrollPosition, 0, 16);
		}else{
			this.font.draw(this.batch, "Position: fixed", 0, 16);
		}
		
		this.batch.end();
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
