package unq.videojuego.states;

import unq.videojuego.components.BattleMap;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class MapSelectingUnit extends State {

	public MapSelectingUnit(){
		super("SelectingUnit");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		map.createSelectedUnitMovableArea();
		map.addSelectedTileInSelectedUnit();
		map.setState(new MapChoosingArea());
	}

}
