package com.uqbar.videojuego.worldmap;

import java.util.List;
import java.util.Map;

import com.uqbar.videojuego.items.Stackable;

public class Shop extends Area {
	private List<Stackable> equips;
	private List<Stackable> consumables;

	public Shop(String name, Map<Dir, Area> areas, List<Stackable> consumables, List<Stackable> equips){
		super(name, areas);
		this.equips = equips;
		this.consumables = consumables;
	}
	
	public List<Stackable> getEquips() {
		return equips;
	}

	public void setEquips(List<Stackable> equips) {
		this.equips = equips;
	}

	public List<Stackable> getConsumables() {
		return consumables;
	}

	public void setConsumables(List<Stackable> consumables) {
		this.consumables = consumables;
	}

}
