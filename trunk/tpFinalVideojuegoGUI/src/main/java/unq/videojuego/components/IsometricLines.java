package unq.videojuego.components;

import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class IsometricLines extends GameComponent<BattleScene> {
	public IsometricLines() {
		this.setZ(1);
		this.setAppearance(Sprite.fromImage("/images/isometricLines2.png"));
	}
}
