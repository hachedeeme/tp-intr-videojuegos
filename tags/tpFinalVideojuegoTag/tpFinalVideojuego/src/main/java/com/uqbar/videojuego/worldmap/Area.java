package com.uqbar.videojuego.worldmap;

import java.util.HashMap;
import java.util.Map;

public abstract class Area {
	private String name;
	private Map<Dir, Area> areas = new HashMap<Dir, Area>();
	
	protected Area(String name, Map<Dir, Area> areas){
		this.name = name;
		this.areas = areas;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Dir, Area> getAreas() {
		return areas;
	}
	public void setAreas(Map<Dir, Area> areas) {
		this.areas = areas;
	} 
	
	public Area getArea(Dir dir){
		return this.getAreas().get(dir);
	}
	
}
