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

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.items.ItemHandler;

public class MainMenuScene extends VideojuegoScene {
	private BattleScene battleScene;

	public MainMenuScene(int screenWidth, int screenHeight, int tileSize) {
		super(screenWidth, screenHeight, new SceneChanger(new GoToBattleScene()));
		
		this.background = new Background("MainMenuBackground");
		this.addComponent(this.background);
		this.addComponent(new MiddleComponent(screenWidth, screenHeight, ImageHandler.INSTANCE.getAnimation("GoToBattle")));
		
		ItemHandler itemH = ItemHandler.INSTANCE;
		ImageHandler imageH = ImageHandler.INSTANCE;
		//	     									 Name    Dir         HP   MP   Spd Str Stm Int Wis
		BattleCharacter angel = new BattleCharacter("Angel", UnitDir.Up, 223, 160, 27, 30, 27, 60, 30);
		BattleCharacter ash   = new BattleCharacter("Ash",   UnitDir.Up, 255, 100, 45, 50, 33, 16, 25);
		
		/* ITEM EQUIPMENTS LIST
		 * 
		 * WEAPONS: ONE HAND: Dagger, Shortsword, Rod. 
		 * 			TWO HAND: Iron Axe, White Staff.
		 * HEAD: Iron Helm, Wizard's Hat, Tiara.
		 * BODY: Iron Armor, Ninja Gear, White Robe.
		 * HANDS: Armguards, Gauntlets.
		 * BOOTS: Battle Boots, Sprint Shoes, Ninja Tabi.
		 * ACCESORIES: Magick Ring, Amulet.
		 */
		angel.equip(itemH.getEquipment("White Staff"),
					itemH.getEquipment("Tiara"),
					itemH.getEquipment("White Robe"),
					itemH.getEquipment("Armguards"),
					itemH.getEquipment("Sprint Shoes"),
					itemH.getEquipment("Magick Ring")
					);
		
		ash.equip(itemH.getEquipment("Shortsword"),
				  itemH.getEquipment("Dagger"),
				  itemH.getEquipment("Iron Helm"),
				  itemH.getEquipment("Ninja Gear"),
				  itemH.getEquipment("Gauntlets"),
				  itemH.getEquipment("Ninja Tabi"),
				  itemH.getEquipment("Amulet")
				  );
		
		System.out.println(angel);
		System.out.println(ash);
		//									 Name     Dir       AttRang mov HP  MP   Spd Str Stm Int Wis
		BattleEnemy slime1 = new BattleEnemy("Slime", UnitDir.Down, 1,   3, 200,100, 80, 60, 60, 60, 60); 
		BattleEnemy slime2 = new BattleEnemy("Slime", UnitDir.Down, 1,   3, 200,100, 80, 60, 60, 60, 60);  
		BattleEnemy slime3 = new BattleEnemy("Slime", UnitDir.Down, 1,   3, 200,100, 80, 60, 60, 60, 60);  
		
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
