package unq.videojuego.components;

import java.awt.Color;

import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.appearances.Sprite;

public class BattleComponent extends GameComponent<BattleScene> {
	public BattleComponent() {
		this.setZ(1);
		this.setAppearance(Sprite.fromImage("/images/pj.png"));
	}
	
}
