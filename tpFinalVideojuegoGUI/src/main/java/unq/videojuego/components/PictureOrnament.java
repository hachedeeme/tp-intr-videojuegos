package unq.videojuego.components;

import com.uqbar.vainilla.appearances.Sprite;

public class PictureOrnament extends Ornament {

	public PictureOrnament(int x, int y, int z, Sprite aPicture) {
		super(x, y, z, aPicture);
		this.setWidth((int) aPicture.getWidth());
	}

}
