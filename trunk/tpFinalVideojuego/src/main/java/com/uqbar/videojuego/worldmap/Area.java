package com.uqbar.videojuego.worldmap;

import java.util.HashMap;
import java.util.Map;

public abstract class Area {
	private String name;
	private Map<Area, Dir> areas = new HashMap<Area, Dir>();
	
	protected Area(String name, Map<Area, Dir> areas){
		this.name = name;
		this.areas = areas;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Area, Dir> getAreas() {
		return areas;
	}
	public void setAreas(Map<Area, Dir> areas) {
		this.areas = areas;
	} 
	
	
}
