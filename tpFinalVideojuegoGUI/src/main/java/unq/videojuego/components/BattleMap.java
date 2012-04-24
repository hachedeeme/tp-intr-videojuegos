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
		this.height = height;
		this.grid = new HashMap<Integer, Map<Integer,BattleComponent>>();
		
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
		if (this.grid.containsKey(x)){
			if (! this.grid.get(x).containsKey(y)){
				this.getScene().addComponent(comp);
			}
		}
	}
	
	public void moveGridComponent(BattleComponent comp, int x, int y){
		int oldX = comp.getMapX();
		int oldY = comp.getMapY();
		this.grid.get(oldX).remove(oldY);
		this.grid.get(x).put(y, comp);
	}
	
	public void setComponentCoord(BattleComponent comp, int x, int y) {
		this.setMapCoords(comp, x, y);
		
		this.moveGridComponent(comp, x, y);
		
		comp.setMapX(x);
		comp.setMapY(y);
	}

	public void setMapCoords(BattleComponent comp, int x, int y) {
		comp.setX(this.getRealXCoord(comp, x, y));
		comp.setY(this.getRealYCoord(comp, x, y));
	}
	
	public double getRealXCoord(BattleComponent comp, int x, int y) {
		double xStart = this.getMapXStart() - comp.getAppearance().getWidth()/2;
		double xPos = (x * this.tileSize/2) - (y * this.tileSize/2);
		return xStart + xPos;
	}
	
	public double getRealYCoord(BattleComponent comp, int x, int y) {
		double yStart = this.getMapYStart() + this.tileSize/2 - comp.getAppearance().getHeight();
		double yPos = (y * this.tileSize/4) + (x * this.tileSize/4);
		return yStart + yPos;
	}
	
	

	private double getMapXStart() {
		return this.getScene().getWidth() * this.tileSize/2;
	}
	
	private double getMapYStart() {
		return this.getY();
	}
	
	
	
}
