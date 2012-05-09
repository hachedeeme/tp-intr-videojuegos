package unq.videojuego.states.character;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.enums.CharDir;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class CharWaiting extends State {
	public CharWaiting(){
		super("Waiting");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		
	}

}
