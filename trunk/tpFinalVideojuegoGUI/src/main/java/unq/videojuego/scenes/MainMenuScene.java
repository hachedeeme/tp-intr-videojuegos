package unq.videojuego.scenes;

import java.util.ArrayList;
import java.util.List;

import unq.videojuego.components.Background;
import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.MiddleComponent;
import unq.videojuego.components.Obstacle;
import unq.videojuego.components.SceneChanger;
import unq.videojuego.states.sceneChanger.GoToBattleScene;
import unq.videojuego.utils.UnitHandler;

import com.uqbar.vainilla.ImageHandler;

public class MainMenuScene extends VideojuegoScene {
	private BattleScene battleScene;

	public MainMenuScene(int screenWidth, int screenHeight, int tileSize) {
		super(screenWidth, screenHeight, new SceneChanger(new GoToBattleScene()));
		
		this.background = new Background("MainMenuBackground");
		this.addComponent(this.background);
		this.addComponent(new MiddleComponent(screenWidth, screenHeight, ImageHandler.INSTANCE.getAnimation("GoToBattle")));
		
		ImageHandler imageH = ImageHandler.INSTANCE;
		
		UnitHandler unitH = UnitHandler.INSTANCE;
		BattleCharacter angel = (BattleCharacter) unitH.getUnit("Angel");
		BattleCharacter ash   = (BattleCharacter) unitH.getUnit("Ash");
		List<BattleCharacter> characters = new ArrayList<BattleCharacter>();
		characters.add(angel);
		characters.add(ash);
		
		int tileWidth = screenWidth/tileSize;
		int tileHeight = screenHeight/tileSize;
		this.battleScene = new BattleScene(tileSize, tileWidth, tileHeight);
		this.battleScene.addCharacters(characters);
		this.battleScene.addEnemies("Slime", "Slime", "Slime");
		//this.battleScene.addComponent(new GameStatsLabel(10, 10));
		
		this.battleScene.addObstacle(new Obstacle("Tree", 1, 1));
		this.battleScene.addObstacle(new Obstacle("Tree", 5, 2));
	}

	public BattleScene getBattleScene() {
		return battleScene;
	}

	public void setBattleScene(BattleScene battleScene) {
		this.battleScene = battleScene;
	}
	
}
