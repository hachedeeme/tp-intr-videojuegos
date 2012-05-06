package unq.videojuego.scenes;

import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.sound.SoundHandler;

public abstract class VideojuegoScene extends GameScene {
	public static ImageHandler imageH = ImageHandler.INSTANCE;
	public static SoundHandler soundH = SoundHandler.INSTANCE;
	private int screenWidth;
	private int screenHeight;

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
}
