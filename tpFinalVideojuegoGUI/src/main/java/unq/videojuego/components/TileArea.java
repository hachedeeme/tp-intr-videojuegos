package unq.videojuego.components;

import unq.videojuego.scenes.VideojuegoScene;

public class TileArea extends BattleComponent {
	public TileArea(int x, int y) {
		super(x, y);
		this.setZ(-2);
		this.setAppearance(VideojuegoScene.imageH.getAnimation("TileArea"));
	}
}
