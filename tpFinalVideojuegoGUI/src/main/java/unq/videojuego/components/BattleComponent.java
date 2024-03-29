package unq.videojuego.components;

import unq.videojuego.scenes.BattleScene;

import com.uqbar.vainilla.GameComponent;

public abstract class BattleComponent extends GameComponent<BattleScene> {
	private int mapX;
	private int mapY;
	
	public BattleComponent(int mapX, int mapY) {
		super();
		this.setMapX(mapX);
		this.setMapY(mapY);
	}
	
	public BattleComponent() {
		super();
	}

	public int getMapX() {
		return mapX;
	}

	public void setMapX(int mapX) {
		this.mapX = mapX;
	}

	public int getMapY() {
		return mapY;
	}

	public void setMapY(int mapY) {
		this.mapY = mapY;
	}
	
	public void updateZ(){
		this.setZ(this.getMapX() + this.getMapY());
	}
}
