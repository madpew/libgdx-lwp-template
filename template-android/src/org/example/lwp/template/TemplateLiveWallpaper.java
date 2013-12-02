package org.example.lwp.template;

import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.AndroidWallpaperListener;

public class TemplateLiveWallpaper extends AndroidLiveWallpaperService {

	@Override
	public void onCreateApplication(){
		super.onCreateApplication();
		
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		cfg.useGL20 = false;
		
		initialize(new TemplateLiveWallpaperListener(), cfg);
	}
	
	public static class TemplateLiveWallpaperListener extends TemplateMain implements AndroidWallpaperListener {
		
		public TemplateLiveWallpaperListener(){
			super();
			this.canScroll = true;
		}
		
		@Override
		public void offsetChange (float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset,	int yPixelOffset) {
			this.xOffset = xOffset;
			this.yOffset = yOffset;
			this.xOffsetStep = xOffsetStep;
			this.yOffsetStep = yOffsetStep;
			this.xPixelOffset = xPixelOffset;
			this.yPixelOffset = yPixelOffset;
		}

		@Override
		public void previewStateChange (boolean isPreview) {
			this.setPreview(isPreview);
		}
	}
}
