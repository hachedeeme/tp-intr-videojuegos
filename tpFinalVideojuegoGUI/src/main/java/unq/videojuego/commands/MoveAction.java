package unq.videojuego.commands;

import unq.videojuego.components.BattleMap;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.scenes.VideojuegoScene;
import unq.videojuego.states.map.MapChoosingDestination;
import unq.videojuego.states.selectedTile.STileMoving;

public class MoveAction extends Action {

	public MoveAction() {
		super("Move");
	}

	@Override
	public void execute(VideojuegoScene scene) {
		BattleScene bScene = (BattleScene) scene;
		BattleMap map = bScene.getMap();
		bScene.removeActiveWindow();
		map.createSelectedUnitMovableArea();
		map.getSelectedTile().setState(new STileMoving());
		map.setState(new MapChoosingDestination());
	}

	
}
