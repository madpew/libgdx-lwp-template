package org.example.lwp.template;

import android.annotation.TargetApi;
 
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidDaydream;

 
@TargetApi(17)
public class TemplateDaydream extends AndroidDaydream {
	
   @Override
   public void onAttachedToWindow() {
      super.onAttachedToWindow();      
      setInteractive(false);
      setFullscreen(true);
 
      AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
      cfg.useGL20 = false;
      
      ApplicationListener app = new TemplateMain();
      initialize(app, cfg);
   }
   
   @Override
   public void onDreamingStarted(){
	   super.onDreamingStarted();
   }
   
   @Override
   public void onDreamingStopped(){
	   super.onDreamingStopped();
   }
   
}