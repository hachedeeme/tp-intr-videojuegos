package com.uqbar.videojuego.items;

import java.util.ArrayList;
import java.util.List;

import com.uqbar.videojuego.characters.StatsContainer;
import com.uqbar.videojuego.skills.Skill;

public class Equipment extends Stackable {
	private int range;
	private EquipType type;
	private StatsContainer stats;
	private List<Skill> skills;

	public Equipment(String name, EquipType aType, StatsContainer stats, int range, 
					 int quantity, int price) {
		super(name, quantity, price);
		this.type   = aType;
		this.stats  = stats;
		this.range  = range;
		this.skills = new ArrayList<Skill>();
	}
	
	//*************//
	//** METHODS **//
	//*************//	
	
	
	//**************//
	//** ACCESORS **//
	//**************//	
	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public EquipType getType() {
		return type;
	}

	public void setType(EquipType type) {
		this.type = type;
	}

	public StatsContainer getStats() {
		return stats;
	}

	public void setStats(StatsContainer stats) {
		this.stats = stats;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
