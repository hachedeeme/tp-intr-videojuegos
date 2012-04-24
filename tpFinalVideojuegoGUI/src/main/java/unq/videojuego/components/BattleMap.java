package unq.videojuego.components;

import java.util.HashMap;
import java.util.Map;

import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class BattleMap extends GameComponent<BattleScene> {
	private Map<Integer, Map<Integer, BattleComponent>> grid;
	private int width;
	private int height;
	private int tileSize;
	
	public BattleMap(String image, int tileSize, int width, int height) {
		this.setZ(-1);
		this.tileSize = tileSize;
		this.width = width;
		this.grid = new HashMap<Integer, Map<Integer,BattleComponent>>();
		for (int i = 0; i < width; i++) {
			this.grid.put(i, new HashMap<Integer, BattleComponent>());
		}
		
		this.height = height;
		this.setAppearance(Sprite.fromImage(image));
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
	
	public void addBattleComponent(BattleComponent comp, int x, int y){
		if (! this.grid.get(x).containsKey(y)){
			this.getScene().addComponent(comp);
			this.grid.get(x).put(y, comp);
			
			// Cambiar por la formula para posicionar X e Y
			this.setComponentCoord(comp, x, y);
		}
	}
	
	private void setComponentCoord(BattleComponent comp, int x, int y) {
		double xStart = this.getMapXStart();
		double yStart = this.getMapYStart();
		
		double xPos = (x * this.tileSize/2) - (y * this.tileSize/2);
		double yPos = (y * this.tileSize/4) + (x * this.tileSize/4);
		
		comp.setX(xStart + xPos);
		comp.setY(yStart + yPos);
	}

	private double getMapXStart() {
		return this.getScene().getWidth() * this.tileSize / 2 - this.tileSize / 2;
	}
	
	private double getMapYStart() {
		//double pos = ((this.height - Math.ceil((this.height)/2)) * this.tileSize / 2 - this.tileSize/2) - 20;
		//return (pos < 0) ? 0 : pos;
		return this.getY() - this.tileSize/2 - 20;
	}
	
	
	
}
