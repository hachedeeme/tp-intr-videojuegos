package unq.videojuego.states.sceneChanger;

import unq.videojuego.components.SceneChanger;
import unq.videojuego.scenes.MainMenuScene;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;
import com.uqbar.vainilla.sound.SoundHandler;

public class GoToBattleScene extends State {
	public GoToBattleScene() {
		super("GoToBattleScene");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		SceneChanger sChanger = (SceneChanger) comp;
		MainMenuScene scene = (MainMenuScene) sChanger.getScene();
		if (deltaState.isKeyPressed(Key.SPACE)){
			SoundHandler.INSTANCE.stopMusic();
			sChanger.getGame().setCurrentScene(scene.getBattleScene());
			SoundHandler.INSTANCE.playSound("StartGame");
			SoundHandler.INSTANCE.playMusic("BattleTheme");
		}
	}

}
