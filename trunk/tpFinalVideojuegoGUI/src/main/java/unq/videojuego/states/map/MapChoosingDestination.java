package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.Sleeping;
import unq.videojuego.states.State;
import unq.videojuego.states.units.UnitWalking;
import unq.videojuego.utils.TTuple;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class MapChoosingDestination extends State {

	public MapChoosingDestination() {
		super("ChoosingDestination");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		if (deltaState.isKeyPressed(Key.X)){
			TTuple selectedTuple = new TTuple(map.getSelectedTile().getMapX(), map.getSelectedTile().getMapY());
			TTuple selectedTupleWithCounter = selectedTuple.getTupleFromCoords(map.getAreaTuples());
			boolean isInSelectionArea = selectedTupleWithCounter != null;
			
			if (isInSelectionArea){
				map.removeSelectedTile();
				map.getSelectedUnit().setState(new UnitWalking(selectedTupleWithCounter, map.getAreaTuples(), map.getTileSize()));
				map.setState(new Sleeping());
				map.removeArea();
			}
		} else if (deltaState.isKeyPressed(Key.Z)){
			BattleScene scene = map.getScene();
			scene.addActiveWindow(scene.getBattleCommandsWindow());
			map.removeSelectedTile();
			map.addSelectedTileInSelectedUnit();
			map.removeArea();
			map.setState(new MapWaitingForCommand());
		}
	}

}
