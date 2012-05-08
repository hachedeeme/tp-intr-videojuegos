package com.uqbar.videojuego.characters;

import java.util.ArrayList;
import java.util.List;

import com.uqbar.videojuego.skills.Skill;

public class Character {
	private String name;
	private StatsHandler stats;
	private CharEquipment equipment;
	private List<Skill> skills;
	
	public Character(String aName, StatsHandler aStatH, CharEquipment aEquipment) {
		this.name 	   = aName;
		this.stats     = aStatH;
		this.equipment = aEquipment;
		this.skills    = new ArrayList<Skill>();
	}

	//*************//
	//** METHODS **//
	//*************//	
	public String getName() {
		return name;
	}
	
	public List<Skill> getSkills() {
		return skills;
	}
	
	public StatsHandler getStats() {
		return stats;
	}
	
	public CharEquipment getEquipment() {
		return equipment;
	}

}
