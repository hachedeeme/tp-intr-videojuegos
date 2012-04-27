package unq.videojuego.components;

import unq.videojuego.scenes.VideojuegoScene;

public class SelectionCone extends BattleComponent {

	public SelectionCone(int x, int y) {
		super(x, y);
		this.setZ(50);
		this.setAppearance(VideojuegoScene.imageH.getAnimation("SelectionCone"));
	}

}
