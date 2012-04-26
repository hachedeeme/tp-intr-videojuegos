package unq.videojuego.states;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.SelectedTile;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class MapChoosingArea extends State {

	protected MapChoosingArea() {
		super("ChoosingArea");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		SelectedTile sTile = map.getSelectedTile();
		int newX = sTile.getMapX();
		int newY = sTile.getMapY();
		boolean moved = false;
		if (deltaState.isKeyPressed(Key.UP)) {
			newY--;
			moved = true;
		} else if (deltaState.isKeyPressed(Key.RIGHT)) {
			newX++;
			moved = true;
		} else if (deltaState.isKeyPressed(Key.DOWN)) {
			newY++;
			moved = true;
		} else if (deltaState.isKeyPressed(Key.LEFT)) {
			newX--;
			moved = true;
		}
		if (moved){
			map.getScene().getMap().setBattleComponentCoords(sTile, newX, newY);
		}
		
	}

}
