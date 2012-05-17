package unq.videojuego.commands;

import unq.videojuego.scenes.BattleScene;
import unq.videojuego.scenes.VideojuegoScene;
import unq.videojuego.states.map.MapWaitingForAction;

public class ActionAction extends Action {

	public ActionAction() {
		super("Action");
	}

	@Override
	public void execute(VideojuegoScene scene) {
		BattleScene bScene = (BattleScene) scene;
		bScene.addActiveWindow(bScene.getBattleActionsWindow());
		bScene.getMap().setState(new MapWaitingForAction());
	}

}
