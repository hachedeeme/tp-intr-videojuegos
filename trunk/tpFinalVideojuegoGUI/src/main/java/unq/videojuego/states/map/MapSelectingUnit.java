package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.states.State;
import unq.videojuego.states.selectedTile.STileMoving;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class MapSelectingUnit extends State {

	public MapSelectingUnit(){
		super("SelectingUnit");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		map.nextSelectedUnit();
		map.addSelectedTileInSelectedUnit();
		map.setState(new MapWaitingForOrders());
		
	}

}
