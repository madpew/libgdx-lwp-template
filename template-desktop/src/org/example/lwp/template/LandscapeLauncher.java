package org.example.lwp.template;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class LandscapeLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "template";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 480;
		
		new LwjglApplication(new TemplateMain(), cfg);
	}
}
