package unq.videojuego;

import java.awt.Dimension;

import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.Obstacle;
import unq.videojuego.scenes.BattleScene;
import unq.videojuego.scenes.MenuScene;

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
		imageH.addSprites("BattleMap1", "IsometricLines", "Tree");
	}

	@Override
	protected void setUpScenes() {
		this.tileSize = 100;
		int tileWidth = 9;
		int tileHeight = 7;
		this.screenWidth = this.tileSize*tileWidth;
		this.screenHeight = this.tileSize*tileHeight;
		
		ImageHandler imageH = ImageHandler.INSTANCE;
		
		BattleMap bm1 = new BattleMap(imageH.getSprite("BattleMap1"), this.tileSize, 11, 11);
		BattleScene battleScene = new BattleScene(this.tileSize, tileWidth, tileHeight);
		battleScene.setMap(bm1);
		battleScene.addBattleCharacter(new BattleCharacter("Angel", 6, 4));
		battleScene.addObstacle(new Obstacle(imageH.getSprite("Tree"), 1, 1));
		battleScene.addObstacle(new Obstacle(imageH.getSprite("Tree"), 5, 3));
		battleScene.addObstacle(new Obstacle(imageH.getSprite("Tree"), 3, 7));
		this.setCurrentScene(battleScene);
		//this.setCurrentScene(new MenuScene());
	}
	
	public static void main(String[] args) {
		new DesktopGameLauncher(new VideojuegoGame()).launch();
	}

}
