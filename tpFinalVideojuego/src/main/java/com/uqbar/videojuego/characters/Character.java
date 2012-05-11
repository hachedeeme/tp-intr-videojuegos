package com.uqbar.videojuego.characters;

import java.util.ArrayList;
import java.util.List;

import com.uqbar.videojuego.skills.Skill;

public class Character {
	private String name;
	private StatsContainer basicStats;
	private StatsHandler stats;
	private CharEquipment equipment;
	private List<Skill> skills;
	
	public Character(String aName, StatsContainer stats, CharEquipment aEquipment) {
		this.name 	    = aName;
		this.basicStats = stats;
		this.equipment  = aEquipment;
		this.skills     = new ArrayList<Skill>();
	}

	//*************//
	//** METHODS **//
	//*************//
	public void addSkill(Skill aSkill){
		this.skills.add(aSkill);
	}
	
	public void addSkills(List<Skill> skills){
		for (Skill skill : skills) {
			this.addSkill(skill);
		}
	}
	//**************//
	//** ACCESORS **//
	//**************//
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
	
	public StatsContainer getBasicStats() {
		return basicStats;
	}

}
