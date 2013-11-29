package org.example.lwp.template;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.AndroidWallpaperListener;

public class TemplateLiveWallpaper extends AndroidLiveWallpaperService {

	@Override
	public void onCreateApplication(){
		super.onCreateApplication();
		
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useGL20 = false;
		
		ApplicationListener listener = new TemplateLiveWallpaperListener();
		initialize(listener, cfg);
	}
	
	public static class TemplateLiveWallpaperListener extends TemplateMain implements AndroidWallpaperListener {
		
		@Override
		public void offsetChange (float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset,	int yPixelOffset) {
			TemplateMain.xOffset = xOffset;
			TemplateMain.yOffset = yOffset;
			TemplateMain.xOffsetStep = xOffsetStep;
			TemplateMain.yOffsetStep = yOffsetStep;
			TemplateMain.xPixelOffset = xPixelOffset;
			TemplateMain.yPixelOffset = yPixelOffset;
		}

		@Override
		public void previewStateChange (boolean isPreview) {
			TemplateMain.isPreview = isPreview;
		}
	}
}
