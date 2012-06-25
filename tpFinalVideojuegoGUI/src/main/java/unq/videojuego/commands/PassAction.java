package unq.videojuego.commands;

import unq.videojuego.components.BattleMap;
import unq.videojuego.components.BattleUnit;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.scenes.VideojuegoScene;
import unq.videojuego.states.character.CharWaiting;
import unq.videojuego.states.map.MapSelectingUnit;

public class PassAction extends Action {

	public PassAction() {
		super("Pass");
	}

	@Override
	public void execute(VideojuegoScene scene) {
		BattleScene bScene = (BattleScene) scene;
		BattleMap map = bScene.getMap();
		BattleUnit curUnit = map.getSelectedUnit();
		curUnit.setState(new CharWaiting());
		map.addUnit(curUnit);
		map.removeSelectedTile();
		map.setState(new MapSelectingUnit());
		bScene.getActiveWindow().setPointerPos(0);
		bScene.resetCommands();
	}

}
