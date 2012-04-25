package unq.videojuego.components;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;
import com.uqbar.vainilla.appearances.Appearance;

public class Ornament extends GameComponent<GameScene> {
	
	public Ornament(int x, int y, int z, Appearance aAppearance) {
		super(aAppearance,x,y);
		this.setZ(z);
	}

}
