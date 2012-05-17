package unq.videojuego.components;

import com.uqbar.vainilla.appearances.Appearance;

public class Obstacle extends BattleComponent {
	public Obstacle(Appearance image, int mapX, int mapY) {
		super(mapX, mapY);
		this.setAppearance(image);
	}
}
