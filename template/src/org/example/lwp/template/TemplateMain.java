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
/*import com.badlogic.gdx.Preferences;*/
import com.badlogic.gdx.graphics.Pixmap;

public class TemplateMain extends Game {
	
	public static float xOffset = 0;
	public static float yOffset = 0;
	public static float xOffsetStep = 0;
	public static float yOffsetStep = 0;
	public static float xPixelOffset = 0;
	public static float yPixelOffset = 0;
	
	public static boolean isPreview = false;
	
	/* Settings */

	
	
	
	private static MainScreen mainScreen;
	
	@Override
	public void create() {
		loadSettings();
		
		if (TemplateMain.mainScreen == null){
			TemplateMain.mainScreen = new MainScreen();
		}
		
		this.setScreen(TemplateMain.mainScreen);
	}

	@Override
	public void dispose() {
		
	}
	
	@Override
	public void pause() {
		super.pause();
	}
	
	@Override
	public void resume(){
		super.resume();
		loadSettings();
	}
	
	@Override
	public void resize(int w, int h){

		if (TemplateMain.mainScreen != null){
			if (w > h){
				TemplateMain.mainScreen.setLandscape();
			}else{
				TemplateMain.mainScreen.setPortrait();
			}
		}
	}
	
	private static boolean pressedScreenshotKey = false;
	@Override
	public void render(){
		super.render();
		
		if (Gdx.input.isKeyPressed(Keys.F12)){
			
			if (!pressedScreenshotKey){
				makeScreenshot();
			}
			
			pressedScreenshotKey = true;
		}else{
			pressedScreenshotKey = false;
		}
	}
	
	public void loadSettings(){
		/*Preferences prefs = Gdx.app.getPreferences("templatelwpSettings");
		TemplateMain.xxx = prefs.getBoolean("xxx", true);*/
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
