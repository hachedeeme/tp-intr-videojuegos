package unq.videojuego.states.map;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.menus.UnitStats;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.State;
import unq.videojuego.states.character.CharSelected;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;

public class MapSelectingUnit extends State {

	public MapSelectingUnit(){
		super("SelectingUnit");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		BattleMap map = (BattleMap) comp;
		BattleScene scene = map.getScene();
		map.nextSelectedUnit();
		map.addSelectedTileInSelectedUnit();
		map.getSelectedUnit().setState(new CharSelected());
		map.setState(new MapWaitingForCommand());
		map.updateHPBars();
		if (scene.getActiveWindow() == null){
			scene.addActiveWindow(scene.getBattleCommandsWindow());
		}
		scene.removeCurUnitStats();
		scene.updateAndShowUnitStats();
	}

}
