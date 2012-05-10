package unq.videojuego.scenes;

import unq.videojuego.components.Background;
import unq.videojuego.components.BattleCharacter;
import unq.videojuego.components.BattleComponent;
import unq.videojuego.components.BattleMap;
import unq.videojuego.components.IsometricLines;
import unq.videojuego.components.Obstacle;

public class BattleScene extends VideojuegoScene {
	private Background background;
	private IsometricLines isometricLines;
	private BattleMap map;
	private int width;
	private int height;
	private int tileSize;
	
	public BattleScene(int tileSize, int width, int height) {
		super(tileSize * width, tileSize * height);
		this.width = width;
		this.height = height;
		this.tileSize = tileSize;
		this.isometricLines = new IsometricLines(imageH.getSprite("IsometricLines"));
		this.addComponent(this.isometricLines);
		
	}
	
	public void setMap(BattleMap map) {
		this.map = map;
		this.map.setX(this.width * this.tileSize / 2 - this.map.getWidth() * this.tileSize / 2);
		this.map.setY((this.height - Math.ceil(((float)this.map.getHeight())/2)) * this.tileSize / 2);
		if (this.map.getY() < this.tileSize){
			this.map.setY(this.tileSize);
		}
		if (this.map.getX() < 0){
			this.map.setX(0);
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

	public void addBattleCharacter(BattleCharacter comp, int mapX, int mapY){
		boolean added = this.addBattleComponent(comp);
		if (added){
			comp.createImagesMap();
			comp.setMapX(mapX);
			comp.setMapY(mapY);
			this.map.setMapComponentCoords(comp, comp.getMapX(), comp.getMapY());
			this.map.addUnit(comp);
		}
	}
	
	private boolean addBattleComponent(BattleComponent comp) {
		return this.map.addBattleComponent(comp);
	}
	
	public void addObstacle(Obstacle comp){
		boolean added = this.addBattleComponent(comp);
		if (added){
			this.map.setMapComponentCoords(comp, comp.getMapX(), comp.getMapY());
		}
	}	
	
}
