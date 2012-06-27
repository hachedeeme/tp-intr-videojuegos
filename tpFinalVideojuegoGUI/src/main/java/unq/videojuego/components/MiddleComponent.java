package unq.videojuego.components;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;

public class MiddleComponent extends GameComponent<VideojuegoScene> {
	public MiddleComponent(int screenWidth, int screenHeight, Appearance app) {
		super();
		this.setAppearance(app);
		this.setZ(1000);
		this.setX(screenWidth/2 - this.getAppearance().getWidth()/2);
		this.setY(screenHeight/2 - this.getAppearance().getHeight()/2);
	}
}
