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
		this.tileSize = 80;
		this.screenWidth = this.tileSize*11;
		this.screenHeight = this.tileSize*8;
		
		BattleMap bm1 = new BattleMap("/images/battleMap3.png", this.tileSize, 8, 8);
		BattleScene battleScene = new BattleScene(this.tileSize, 11, 8);
		battleScene.setMap(bm1);
		battleScene.addBattleComponent(new BattleComponent(), 5, 3);
		this.setCurrentScene(battleScene);
	}
	
	public static void main(String[] args) {
		new DesktopGameLauncher(new VideojuegoGame()).launch();
	}

}
