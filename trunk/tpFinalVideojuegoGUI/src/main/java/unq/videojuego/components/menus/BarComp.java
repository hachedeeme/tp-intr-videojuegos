package unq.videojuego.components.menus;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.appearances.Invisible;
import com.uqbar.vainilla.appearances.Sprite;

public class BarComp extends GameComponent<VideojuegoScene> {
	private Sprite bar;
	
	public BarComp(double scale, double x, double y, int z, String imageName) {
		super(x, y);
		this.bar = ImageHandler.INSTANCE.getSprite(imageName).scale(scale);
		this.setZ(z);
		this.setAppearance(bar);
	}
	
	public BarComp(double scale, double x, double y, int z, String imageName, double perc) {
		this(scale, x, y, z, imageName);
		this.updateBar(perc);
	}
	
	public void updateBar(double perc) {
		if (perc <= 0){
			this.setAppearance(new Invisible());
		} else {
			Sprite newImage = bar.crop((int) (bar.getWidth() * perc), (int) bar.getHeight());
			this.setAppearance(newImage);
		}
	}

	public double getFullWidth() {
		return this.bar.getWidth();
	}

	public double getFullHeight() {
		return this.bar.getHeight();
	}

	public void changeCoords(double x, double y) {
		this.setX(x);
		this.setY(y);
	}
}
