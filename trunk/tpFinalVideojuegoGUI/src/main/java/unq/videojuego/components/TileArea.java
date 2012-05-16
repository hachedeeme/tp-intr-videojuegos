package unq.videojuego.components;

import com.uqbar.vainilla.ImageHandler;

public class TileArea extends BattleComponent {
	public TileArea(int x, int y) {
		super(x, y);
		this.setZ(-2);
		this.setAppearance(ImageHandler.INSTANCE.getAnimation("TileArea"));
	}
}
