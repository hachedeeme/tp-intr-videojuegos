package unq.videojuego.components;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class Background extends GameComponent {
	
	public Background(String image){
		super(0, 0);
		this.setZ(-10);
		this.setAppearance(Sprite.fromImage(image));
	}

}
