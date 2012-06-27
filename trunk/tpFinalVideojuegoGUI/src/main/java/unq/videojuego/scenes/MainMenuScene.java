package unq.videojuego.scenes;

import unq.videojuego.components.Background;
import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.MiddleComponent;
import unq.videojuego.components.Obstacle;
import unq.videojuego.components.SceneChanger;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.states.sceneChanger.GoToBattleScene;
import unq.videojuego.utils.UnitHandler;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.items.ItemHandler;

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
		
		BattleEnemy slime1 = (BattleEnemy) unitH.getUnit("Slime");
		BattleEnemy slime2 = (BattleEnemy) unitH.getUnit("Slime"); 
		BattleEnemy slime3 = (BattleEnemy) unitH.getUnit("Slime"); 
		
		System.out.println(slime1);
		
		int tileWidth = screenWidth/tileSize;
		int tileHeight = screenHeight/tileSize;
		BattleMap bm1 = new BattleMap(imageH.getSprite("BattleMap1"), tileSize, 11, 11);
		this.battleScene = new BattleScene(bm1, tileSize, tileWidth, tileHeight);
		//this.battleScene.addComponent(new GameStatsLabel(10, 10));
		
		this.battleScene.addBattleCharacter(angel, 4, 8);
		this.battleScene.addBattleCharacter(ash, 5, 8);
		this.battleScene.addBattleEnemy(slime1, 4, 3);
		this.battleScene.addBattleEnemy(slime2, 3, 3);
		this.battleScene.addBattleEnemy(slime3, 5, 3);
		
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
