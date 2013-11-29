package org.example.lwp.template;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class PortraitLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "template";
		cfg.useGL20 = false;
		cfg.width = 480;
		cfg.height = 800;
		
		new LwjglApplication(new TemplateMain(), cfg);
	}
}
