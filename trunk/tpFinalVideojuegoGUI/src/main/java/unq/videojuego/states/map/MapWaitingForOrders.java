package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class MapWaitingForOrders extends State {

	public MapWaitingForOrders() {
		super("WaitingForOrders");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		if (deltaState.isKeyPressed(Key.X)){
			BattleMap map = (BattleMap) comp;
			map.setState(new MapPrepareForMoving());
		}
	}

}
