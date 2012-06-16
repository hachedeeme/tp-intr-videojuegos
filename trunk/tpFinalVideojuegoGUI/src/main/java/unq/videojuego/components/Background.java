package unq.videojuego.components;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.ImageHandler;

public class Background extends GameComponent {
	
	public Background(String image){
		super(0, 0);
		this.setZ(-100);
		this.setAppearance(ImageHandler.INSTANCE.getSprite(image));
	}

}
