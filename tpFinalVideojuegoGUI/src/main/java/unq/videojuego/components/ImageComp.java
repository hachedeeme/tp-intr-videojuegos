package unq.videojuego.components;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;

public class ImageComp extends GameComponent<VideojuegoScene> {
	public ImageComp(double x, double y, int z, Appearance anImage) {
		super(x, y);
		this.setZ(z);
		this.setAppearance(anImage);
	}
}
