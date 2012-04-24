package unq.videojuego.states;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.enums.CharDir;

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
		boolean moved = false;
		CharDir newCharDir = bc.getDir();
		if (deltaState.isKeyPressed(Key.UP)) {
			newY--;
			moved = true;
			newCharDir = CharDir.Up;
		} else if (deltaState.isKeyPressed(Key.RIGHT)) {
			newX++;
			moved = true;
			newCharDir = CharDir.Right;
		} else if (deltaState.isKeyPressed(Key.DOWN)) {
			newY++;
			moved = true;
			newCharDir = CharDir.Down;
		} else if (deltaState.isKeyPressed(Key.LEFT)) {
			newX--;
			moved = true;
			newCharDir = CharDir.Left;
		}
		if (moved){
			int tilesize = bc.getScene().getTileSize();
			double newRealX = bc.getScene().getMap().getRealXCoord(bc, newX, newY);
			double newRealY = bc.getScene().getMap().getRealYCoord(bc, newX, newY);
			bc.setDir(newCharDir);
			bc.setState(new CharWalking(tilesize, bc.getX(), bc.getY(), newRealX, newRealY, newX, newY));
		}
	}

}
