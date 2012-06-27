package unq.videojuego;

import java.awt.Dimension;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleEnemy;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.Obstacle;
import unq.videojuego.enums.UnitDir;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.scenes.MainMenuScene;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;
import com.uqbar.vainilla.ImageHandler;
import com.uqbar.vainilla.sound.SoundHandler;
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
		imageH.addSprites("BattleMap1", "IsometricLines", "SelectedTile", "BattleBackground", "MainMenuBackground",
				
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
	
		SoundHandler soundH = SoundHandler.INSTANCE;
		soundH.addSounds("Accept", "StartGame");
		
	}

	@Override
	protected void setUpScenes() {
		this.tileSize = 100;
		int tileWidth = 9;
		int tileHeight = 7;
		this.screenWidth = this.tileSize*tileWidth;
		this.screenHeight = this.tileSize*tileHeight;
		
		this.setCurrentScene(new MainMenuScene(this.screenWidth, this.screenHeight, this.tileSize));
		//SoundHandler.INSTANCE.playMusic("MainMenuTheme");
	}
	
	public int getScreenWidth() {
		return this.screenWidth;
	}
	
	public int getScreenHeight() {
		return this.screenHeight;
	}
	
	public int getTileSize() {
		return this.tileSize;
	}

	public static void main(String[] args) {
		new DesktopGameLauncher(new VideojuegoGame()).launch();
	}
}
