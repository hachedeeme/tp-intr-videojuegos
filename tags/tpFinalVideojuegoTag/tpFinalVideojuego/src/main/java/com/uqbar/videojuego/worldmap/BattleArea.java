package com.uqbar.videojuego.worldmap;

import java.util.ArrayList;
import java.util.List;

import com.uqbar.videojuego.characters.Enemy;

public class BattleArea {
	private List<Enemy> enemies = new ArrayList<Enemy>();

	
	public List<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	
	
}
