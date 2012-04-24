package unq.videojuego;

import java.awt.Dimension;

import unq.videojuego.components.BattleComponent;
import unq.videojuego.components.BattleMap;
import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.DesktopGameLauncher;
import com.uqbar.vainilla.Game;

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
	}

	@Override
	protected void setUpScenes() {
		this.tileSize = 100;
		int tileWidth = 9;
		int tileHeight = 7;
		this.screenWidth = this.tileSize*tileWidth;
		this.screenHeight = this.tileSize*tileHeight;
		
		BattleMap bm1 = new BattleMap("/images/battleMap1.png", this.tileSize, 9, 9);
		BattleScene battleScene = new BattleScene(this.tileSize, tileWidth, tileHeight);
		battleScene.setMap(bm1);
		battleScene.addBattleComponent(new BattleComponent(), 3, 0);
		battleScene.addBattleComponent(new BattleComponent(), 4, 0);
		battleScene.addBattleComponent(new BattleComponent(), 5, 0);
		battleScene.addBattleComponent(new BattleComponent(), 6, 0);
		this.setCurrentScene(battleScene);
	}
	
	public static void main(String[] args) {
		new DesktopGameLauncher(new VideojuegoGame()).launch();
	}

}
