package unq.videojuego.components;

import unq.videojuego.scenes.MenuScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;

public class SimpleComponent extends GameComponent<MenuScene> {
	public SimpleComponent(double x, double y, int z, Appearance image) {
		super(x, y);
		this.setZ(z);
		this.setAppearance(image);
	}
}
