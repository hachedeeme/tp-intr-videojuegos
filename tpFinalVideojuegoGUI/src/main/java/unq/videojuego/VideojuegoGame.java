package unq.videojuego;

import java.awt.Dimension;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.Obstacle;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.items.ItemHandler;

public class VideojuegoGame extends Game {
	private int tileSize;
	private int screenWidth;
	private int screenHeight;

	@Override
	public Dimension getDisplaySize() {
		return new Dimension(this.screenWidth, this.screenHeight);
	}

	@Override
	public String getTitle() {
		return "Videojuego";
	}

	@Override
	protected void initializeResources() {
		ImageHandler imageH = ImageHandler.INSTANCE;
		imageH.addSprites("BattleMap1", "IsometricLines", "SelectedTile", "Background",
				
						  "Tree",
				
						  "pointer", "arrow", "BlueWindow", "BigBlueWindow", "LongBlueWindow", "UnitStatsBack", "HpBar", "MpBar", "HpBarBack",
						  
						  "HP Potion", "MP Potion",  
						  
						  "Dagger",
						  
						  "AngelAvatar", "AshAvatar", "SlimeAvatar");
		
		// Tile Selection 
		imageH.addAnimation(0.15, 1, 900, 50, 100, 50, "TileArea");
		imageH.addAnimation(0.07, 1, 1200, 150, 100, 150, "SelectionCone");
		
		// Attacks
		imageH.addLimitedAnimation(0.1, 1, 324, 100, 81, 100, "attacks/BasicAttack");
		imageH.addLimitedAnimation(0.1, 1, 126, 128, 126, 64, "attacks/Ki");
		imageH.addLimitedAnimation(0.1, 1.5, 560, 104, 80, 104, "attacks/FirePilar");
	}

	@Override
	protected void setUpScenes() {
		this.tileSize = 100;
		int tileWidth = 9;
		int tileHeight = 7;
		this.screenWidth = this.tileSize*tileWidth;
		this.screenHeight = this.tileSize*tileHeight;
		ItemHandler ih = ItemHandler.INSTANCE;
		
		ImageHandler imageH = ImageHandler.INSTANCE;
		//										     Name    Dir         HP   MP   Spd Str Stm Int Wis
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
		angel.equip(ih.getEquipment("White Staff"),
					ih.getEquipment("Tiara"),
					ih.getEquipment("White Robe"),
					ih.getEquipment("Armguards"),
					ih.getEquipment("Sprint Shoes"),
					ih.getEquipment("Magick Ring")
					);
		
		ash.equip(ih.getEquipment("Shortsword"),
				  ih.getEquipment("Dagger"),
				  ih.getEquipment("Iron Helm"),
				  ih.getEquipment("Ninja Gear"),
				  ih.getEquipment("Gauntlets"),
				  ih.getEquipment("Ninja Tabi"),
				  ih.getEquipment("Amulet")
				  );
		
		System.out.println(angel);
		System.out.println(ash);
		//									 Name     Dir       AttRang mov HP  MP   Spd Str Stm Int Wis
		BattleEnemy slime1 = new BattleEnemy("Slime", UnitDir.Down, 1,   3, 200,100, 80, 60, 60, 60, 60); 
		BattleEnemy slime2 = new BattleEnemy("Slime", UnitDir.Down, 1,   3, 200,100, 80, 60, 60, 60, 60);  
		BattleEnemy slime3 = new BattleEnemy("Slime", UnitDir.Down, 1,   3, 200,100, 80, 60, 60, 60, 60);  
		
		System.out.println(slime1);
		BattleMap bm1 = new BattleMap(imageH.getSprite("BattleMap1"), this.tileSize, 11, 11);
		BattleScene battleScene = new BattleScene(bm1, this.tileSize, tileWidth, tileHeight);
		//battleScene.addComponent(new GameStatsLabel(10, 10));
		
		battleScene.addBattleCharacter(angel, 4, 8);
		battleScene.addBattleCharacter(ash, 5, 8);
		battleScene.addBattleEnemy(slime1, 4, 3);
		battleScene.addBattleEnemy(slime2, 3, 3);
		battleScene.addBattleEnemy(slime3, 5, 3);
		
		battleScene.addObstacle(new Obstacle("Tree", 1, 1));
		battleScene.addObstacle(new Obstacle("Tree", 5, 2));
		
		this.setCurrentScene(battleScene);
		/*
		this.setCurrentScene(new MenuScene(screenWidth, screenHeight));
		 */
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}
	
	public int getScreenHeight() {
		return screenHeight;
	}
	
	public static void main(String[] args) {
		new DesktopGameLauncher(new VideojuegoGame()).launch();
	}
}
