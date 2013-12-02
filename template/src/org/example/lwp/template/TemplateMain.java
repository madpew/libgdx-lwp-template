package org.example.lwp.template;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Pixmap;

public class TemplateMain extends Game {
	
	public float xOffset = 0;
	public float yOffset = 0;
	public float xOffsetStep = 0;
	public float yOffsetStep = 0;
	public float xPixelOffset = 0;
	public float yPixelOffset = 0;
	
	public boolean isPreview = false;
	public boolean canScroll = false;
	
	private MainScreen mainScreen;
	private boolean pressedScreenshotKey = false;

	/* Settings */
	
	
	
	@Override
	public void create() {
		this.loadSettings();
		
		if (this.mainScreen == null){
			this.mainScreen = new MainScreen();
		}
		
		this.setPreview(this.isPreview);
		this.setScreen(this.mainScreen);
	}

	public void setPreview(boolean isPreview){
		this.isPreview = isPreview;
		
		if (this.mainScreen != null){
			this.mainScreen.isPreview = this.isPreview;
			this.mainScreen.canScroll = this.isPreview ? false : this.canScroll;
		}
	}
	
	@Override
	public void dispose() {
		if (this.mainScreen != null){
			this.mainScreen.dispose();
		}
	}
	
	@Override
	public void pause() {
		super.pause();
	}
	
	@Override
	public void resume(){
		super.resume();
		this.loadSettings();
	}
	
	@Override
	public void resize(int w, int h){

		if (this.mainScreen != null){
			if (w > h){
				this.mainScreen.setLandscape();
			}else{
				this.mainScreen.setPortrait();
			}
		}
	}
	
	@Override
	public void render(){
		
		if (this.mainScreen != null && this.mainScreen.canScroll){
			this.mainScreen.scrollPosition.set(-this.xPixelOffset, -this.yPixelOffset, 1);
		}
		
		super.render();
		
		if (Gdx.input.isKeyPressed(Keys.F12)){
			
			if (!this.pressedScreenshotKey){
				this.makeScreenshot();
			}
			
			this.pressedScreenshotKey = true;
		}else{
			this.pressedScreenshotKey = false;
		}
	}
	
	public void loadSettings(){
		Preferences prefs = Gdx.app.getPreferences("templatelwpSettings");
		/*TemplateMain.xxx = prefs.getBoolean("xxx", true);*/
	}
	
	private void makeScreenshot(){
	    int w = Gdx.graphics.getWidth();
	    int h = Gdx.graphics.getHeight();
	    
		Gdx.gl.glPixelStorei(GL10.GL_PACK_ALIGNMENT, 1);
		final Pixmap pixmap = new Pixmap(w, h, Format.RGBA8888);
		ByteBuffer pixels = pixmap.getPixels();
		Gdx.gl.glReadPixels(0, 0, w, h, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, pixels);
		final int numBytes = w * h * 4;
	    byte[] lines = new byte[numBytes];
	          
	    pixels.clear(); 
	    pixels.get(lines);
	    
	    String stamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	    PixmapIO.writePNG(Gdx.files.local("Screenshot-" + stamp + ".png"), pixmap);
		pixmap.dispose();
	}
}
