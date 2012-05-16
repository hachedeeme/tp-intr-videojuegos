package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.menus.BattleActionShowable;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;

public class MapWaitingForCommand extends State {

	public MapWaitingForCommand() {
		super("WaitingForCommand");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp; 
		BattleScene scene = map.getScene();
		if (deltaState.isKeyPressed(Key.X)){
			BattleActionShowable actionS = (BattleActionShowable) scene.getActiveWindow().getElem();
			actionS.execute(scene);
		}
	}

}
