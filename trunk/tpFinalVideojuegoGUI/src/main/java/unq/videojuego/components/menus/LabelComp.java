package unq.videojuego.components.menus;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;

public class LabelComp extends GameComponent<VideojuegoScene> {
	public LabelComp(double x, double y, int z, Label label) {
		super(x, y);
		this.setZ(z);
		this.setAppearance(label);
	}
	
	public void setText(String text){
		((Label) this.getAppearance()).setText(text);
	}
}

