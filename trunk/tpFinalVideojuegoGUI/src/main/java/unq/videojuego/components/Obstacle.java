package unq.videojuego.components;

import com.uqbar.vainilla.appearances.Sprite;

public class Obstacle extends BattleComponent {
	public Obstacle(Sprite image, int mapX, int mapY) {
		super(mapX, mapY);
		this.setAppearance(image);
	}
}
