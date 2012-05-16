package unq.videojuego.commands;

import unq.videojuego.components.BattleMap;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.scenes.VideojuegoScene;
import unq.videojuego.states.map.MapChoosingTarget;
import unq.videojuego.states.selectedTile.STileMoving;

public class AttackAction extends Action {

	public AttackAction() {
		super("Attack");
	}

	@Override
	public void execute(VideojuegoScene scene) {
		BattleScene bScene = (BattleScene) scene;
		BattleMap map = bScene.getMap();
		bScene.removeActiveWindow();
		bScene.removeComponent(bScene.getBattleCommandsWindow());
		map.createSelectedUnitAttackableArea();
		map.getSelectedTile().setState(new STileMoving());
		bScene.getMap().setState(new MapChoosingTarget());
	}

}
