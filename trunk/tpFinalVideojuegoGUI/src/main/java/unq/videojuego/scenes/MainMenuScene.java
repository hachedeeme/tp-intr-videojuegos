package unq.videojuego.scenes;

import unq.videojuego.components.SceneChanger;
import unq.videojuego.states.sceneChanger.GoToBattleScene;

public class MainMenuScene extends VideojuegoScene {

	public MainMenuScene(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight, new SceneChanger(new GoToBattleScene()));
	}

}
