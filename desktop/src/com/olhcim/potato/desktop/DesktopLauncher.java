package com.olhcim.potato.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.olhcim.potato.Main;
import org.mini2Dx.desktop.DesktopMini2DxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new DesktopMini2DxGame("com.olhcim.potato.Main", new Main()), config);
	}
}
