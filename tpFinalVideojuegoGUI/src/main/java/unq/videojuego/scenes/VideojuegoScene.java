package unq.videojuego.scenes;

import unq.videojuego.components.menus.Window;

import com.uqbar.vainilla.GameScene;

public abstract class VideojuegoScene extends GameScene {
	private int screenWidth;
	private int screenHeight;
	
	private Window activeWindow;
	
	public VideojuegoScene(int screenWidth, int screenHeight) {
		super();
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}

	public int getScreenHeight() {
		return screenHeight;
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}

	public Window getActiveWindow() {
		return activeWindow;
	}

	public void setActiveWindow(Window activeWindow) {
		this.activeWindow = activeWindow;
		if (activeWindow != null){
			activeWindow.setPointerPos(0);
		}
	}

	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}

	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}	
	
}