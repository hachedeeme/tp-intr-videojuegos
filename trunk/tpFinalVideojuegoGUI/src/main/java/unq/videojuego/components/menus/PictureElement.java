package unq.videojuego.components.menus;


import com.uqbar.vainilla.appearances.Sprite;

public class PictureElement extends ListElement {

	public PictureElement(int x, int y, int z, Sprite aPicture) {
		super(x, y, z, aPicture);
		this.setWidth((int) aPicture.getWidth());
	}

}
