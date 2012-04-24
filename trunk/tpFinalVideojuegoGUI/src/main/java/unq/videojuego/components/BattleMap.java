package unq.videojuego.components;

import java.util.HashMap;
import java.util.Map;

import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class BattleMap extends GameComponent<BattleScene> {
	private Map<Integer, Map<Integer, BattleComponent>> grid;
	private Map<Integer, Map<Integer, Integer>> obstaclesGrid;
	private int width;
	private int height;
	private int tileSize;
	
	public BattleMap(Sprite image, int tileSize, int width, int height) {
		this.setZ(-2);
		this.tileSize = tileSize;
		this.width = width;
		this.grid = new HashMap<Integer, Map<Integer,BattleComponent>>();
		
		this.height = height;
		for (int i = 0; i < width; i++) {
			this.grid.put(i, new HashMap<Integer, BattleComponent>());
		}
		
		this.setAppearance(image);
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
	
	public void addBattleComponent(BattleComponent comp){
		int x = comp.getMapX();
		int y = comp.getMapY();
		if (! this.grid.get(x).containsKey(y)){
			this.getScene().addComponent(comp);
			this.grid.get(x).put(y, comp);
		}
	}
	
	public void setComponentCoord(BattleComponent comp, int x, int y) {
		double xStart = this.getMapXStart() - comp.getAppearance().getWidth()/2;
		double yStart = this.getMapYStart() + this.tileSize/2 - comp.getAppearance().getHeight();
		
		double xPos = (x * this.tileSize/2) - (y * this.tileSize/2);
		double yPos = (y * this.tileSize/4) + (x * this.tileSize/4);
		
		comp.setX(xStart + xPos);
		comp.setY(yStart + yPos);
		
		comp.setMapX(x);
		comp.setMapY(y);
	}

	private double getMapXStart() {
		return this.getScene().getWidth() * this.tileSize/2;
	}
	
	private double getMapYStart() {
		return this.getY();
	}
	
	
	
}
