package unq.videojuego.components;

import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;
import com.uqbar.vainilla.appearances.Invisible;
import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.events.constants.Key;

public class IsometricLines extends GameComponent<BattleScene> {
	private Appearance otherAppearance;
	private Appearance curAppearance;
	
	public IsometricLines() {
		this.setZ(1);
		this.otherAppearance = new Invisible();
		this.curAppearance = Sprite.fromImage("/images/isometricLines2.png");
		this.setAppearance(this.curAppearance);
	}
	
	@Override
	public void update(DeltaState deltaState) {
		super.update(deltaState);
		if (deltaState.isKeyPressed(Key.SPACE)){
			Appearance temp = this.curAppearance;
			this.curAppearance = this.otherAppearance;
			this.otherAppearance = temp;
			this.setAppearance(this.curAppearance);
		}
	}
}
