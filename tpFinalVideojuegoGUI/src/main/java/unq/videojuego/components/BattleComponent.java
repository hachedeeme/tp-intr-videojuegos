package unq.videojuego.components;

import java.awt.Color;

import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;

public class BattleComponent extends GameComponent<BattleScene> {
	public BattleComponent() {
		this.setZ(1);
		this.setAppearance(new Rectangle(Color.RED, 80, 80));
	}
	
}
