package unq.videojuego.states.sceneChanger;

import java.util.List;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.Obstacle;
import unq.videojuego.components.SceneChanger;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.states.State;

import com.uqbar.vainilla.DeltaState;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.events.constants.Key;
import com.uqbar.vainilla.sound.SoundHandler;

public class GoToNextBattle extends State {

	public GoToNextBattle() {
		super("GoToNextBattle");
	}

	@Override
	public void update(GameComponent comp, DeltaState deltaState) {
		SceneChanger sChanger = (SceneChanger) comp;
		BattleScene scene = (BattleScene) sChanger.getScene();
		if (deltaState.isKeyPressed(Key.SPACE)){
			SoundHandler.INSTANCE.stopMusic();
			SoundHandler.INSTANCE.playSound("Accept");
			List<BattleCharacter> characters = scene.getMap().getCharacters();
			BattleScene newBScene = new BattleScene(scene.getTileSize(), scene.getWidth(), scene.getHeight());
			
			newBScene.addCharacters(characters);
			newBScene.addEnemies("Slime", "Slime", "Slime");
			newBScene.addObstacle(new Obstacle("Tree", 1, 1));
			newBScene.addObstacle(new Obstacle("Tree", 5, 2));
			
			sChanger.getGame().setCurrentScene(newBScene);
			SoundHandler.INSTANCE.playMusic("BattleTheme");
		}
	}

}
