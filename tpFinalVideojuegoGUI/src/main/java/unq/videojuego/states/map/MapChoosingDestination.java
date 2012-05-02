package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;
import unq.videojuego.states.character.CharWalking;
import unq.videojuego.utils.TTuple;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class MapChoosingDestination extends State {

	protected MapChoosingDestination() {
		super("ChoosingDestination");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		TTuple selectedTuple = new TTuple(map.getSelectedTile().getMapX(), map.getSelectedTile().getMapY());
		TTuple selectedTupleWithCounter = selectedTuple.getTupleFromCoords(map.getAreaTuples());
		boolean isInSelectionArea = selectedTupleWithCounter != null;
		
		if (deltaState.isKeyPressed(Key.X) && isInSelectionArea){
			map.removeSelectedTile();
			map.getSelectedUnit().setState(new CharWalking(selectedTupleWithCounter, map.getAreaTuples(), map.getTileSize()));
			map.setState(new Sleeping());
			map.removeArea();
		}
	}

}
