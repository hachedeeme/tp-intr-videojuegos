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
				
						  "pointer", "arrow", "BlueWindow", "BigBlueWindow", "LongBlueWindow", "UnitStatsBack", "HpBar", "MpBar",
						  
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
		
		ImageHandler imageH = ImageHandler.INSTANCE;
		
		BattleCharacter angel = new BattleCharacter("Angel", UnitDir.Down);
		BattleCharacter ash = new BattleCharacter("Ash", UnitDir.Down);
		
		BattleEnemy slime = new BattleEnemy("Slime", UnitDir.Up);
		
		BattleMap bm1 = new BattleMap(imageH.getSprite("BattleMap1"), this.tileSize, 11, 11);
		BattleScene battleScene = new BattleScene(bm1, this.tileSize, tileWidth, tileHeight);
		//battleScene.addComponent(new GameStatsLabel(10, 10));
		
		battleScene.addBattleCharacter(angel, 5, 6);
		battleScene.addBattleCharacter(ash, 6, 6);
		battleScene.addBattleEnemy(slime, 4, 8);
		
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
