package unq.videojuego.states.sceneChanger;

import unq.videojuego.components.SceneChanger;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.scenes.MainMenuScene;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;
import com.uqbar.vainilla.sound.SoundHandler;

public class GoToMainMenuScene extends State {

	public GoToMainMenuScene() {
		super("GoToMainMenuScene");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		SceneChanger sChanger = (SceneChanger) comp;
		BattleScene scene = (BattleScene) sChanger.getScene();
		if (deltaState.isKeyPressed(Key.SPACE)){
			SoundHandler.INSTANCE.stopMusic();
			sChanger.getGame().setCurrentScene(new MainMenuScene(scene.getScreenWidth(), scene.getScreenHeight(), scene.getTileSize()));
			SoundHandler.INSTANCE.playSound("Accept");
			//SoundHandler.INSTANCE.playMusic("MainMenuTheme");
		}
	}

}
