package unq.videojuego.components;

import com.uqbar.vainilla.ImageHandler;


public class Obstacle extends BattleComponent {
	public Obstacle(String image, int mapX, int mapY) {
		super(mapX, mapY);
		this.setAppearance(ImageHandler.INSTANCE.getSprite(image));
	}
}
