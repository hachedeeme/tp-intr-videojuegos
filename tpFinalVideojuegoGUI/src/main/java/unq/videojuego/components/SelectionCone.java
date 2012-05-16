package unq.videojuego.components;

import com.uqbar.vainilla.ImageHandler;

public class SelectionCone extends BattleComponent {

	public SelectionCone(int x, int y) {
		super(x, y);
		this.setZ(50);
		this.setAppearance(ImageHandler.INSTANCE.getAnimation("SelectionCone"));
	}

}
