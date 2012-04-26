package unq.videojuego.components;

import unq.videojuego.scenes.VideojuegoScene;

public class SelectedTile extends BattleComponent {
	public SelectedTile(int x, int y) {
		super(x, y);
		this.setZ(-1);
		this.setAppearance(VideojuegoScene.imageH.getSprite("SelectedTile"));
	}
}
