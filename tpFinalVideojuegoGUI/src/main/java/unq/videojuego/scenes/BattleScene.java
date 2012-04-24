package unq.videojuego.scenes;

import unq.videojuego.components.Background;
import unq.videojuego.components.BattleComponent;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.IsometricLines;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.GameScene;

public class BattleScene extends GameScene {
	private Background background;
	private GameComponent isometricLines;
	private BattleMap map;
	private int width;
	private int height;
	private int tileSize;
	
	public BattleScene(int tileSize, int width, int height) {
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		this.background = new Background("/images/background.png");
		//this.addComponent(this.background);
		this.isometricLines = new IsometricLines();
		//this.addComponent(this.isometricLines);
		
	}
	
	public void setMap(BattleMap map) {
		this.map = map;
		this.map.setX(this.width * this.tileSize / 2 - this.map.getWidth() * this.tileSize / 2);
		this.map.setY((this.height - Math.ceil(((float)this.map.getHeight())/2)) * this.tileSize / 2);
		if (this.map.getY() < this.tileSize/2){
			this.map.setY(this.tileSize/2);
		}
		this.addComponent(this.map);
	}

	public Background getBackground() {
		return background;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public BattleMap getMap() {
		return map;
	}

	public void addBattleComponent(BattleComponent comp, int x, int y) {
		this.map.addBattleComponent(comp, x, y);
	}
	
	
	
}
