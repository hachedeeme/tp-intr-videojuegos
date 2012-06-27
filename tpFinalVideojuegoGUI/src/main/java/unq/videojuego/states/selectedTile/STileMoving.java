package unq.videojuego.states.selectedTile;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;
import com.uqbar.vainilla.sound.SoundHandler;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.SelectedTile;
import unq.videojuego.states.State;

public class STileMoving extends State {

	public STileMoving() {
		super("STileMoving");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		SelectedTile sTile = (SelectedTile) comp;
		BattleMap map = sTile.getScene().getMap();
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
		if (moved && ! map.isOutOfMap(newX, newY)){
			SoundHandler.INSTANCE.playSound("Select");
			sTile.getBattleMap().setSelectedTileCoords(newX, newY);
		}
	}
}
