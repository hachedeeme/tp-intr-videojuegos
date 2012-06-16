package unq.videojuego.components.menus;

import com.uqbar.vainilla.appearances.Appearance;

public class PictureElement extends ListElement {

	public PictureElement(double x, double y, int z, Appearance aPicture) {
		super(x, y, z, aPicture);
		this.setWidth((int) aPicture.getWidth());
	}
	
	public double getHeight(){
		return this.getAppearance().getHeight();
	}

}
