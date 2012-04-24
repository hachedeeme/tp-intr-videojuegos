package unq.videojuego.states;

import unq.videojuego.components.BattleCharacter;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class CharWaiting extends State {
	public CharWaiting(){
		super("Waiting");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleCharacter bc = (BattleCharacter) comp;
		int newX = bc.getMapX();
		int newY = bc.getMapY();
		if (deltaState.isKeyPressed(Key.UP)) {
			newY--;
		}
		if (deltaState.isKeyPressed(Key.RIGHT)) {
			newX++;
		}
		if (deltaState.isKeyPressed(Key.DOWN)) {
			newY++;
		}
		if (deltaState.isKeyPressed(Key.LEFT)) {
			newX--;
		}
		bc.getScene().getMap().setComponentCoord(bc, newX, newY);
	}

}
