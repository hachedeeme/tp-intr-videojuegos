package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.states.State;
import unq.videojuego.states.selectedTile.STileMoving;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class MapPrepareForMoving extends State {

	protected MapPrepareForMoving() {
		super("PrepareForMoving");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		map.createSelectedUnitMovableArea();
		map.getSelectedTile().setState(new STileMoving());
		map.setState(new MapChoosingDestination());
	}

}
