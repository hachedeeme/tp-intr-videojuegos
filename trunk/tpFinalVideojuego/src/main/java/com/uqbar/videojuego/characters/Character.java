package com.uqbar.videojuego.characters;

import java.util.ArrayList;
import java.util.List;

import com.uqbar.videojuego.skills.Skill;

public class Character extends Actor{
	private StatsContainer basicStats;
	private CharEquipment equipment;
	
	public Character(String aName, StatsContainer stats, CharEquipment aEquipment) {
		StatsContainer statsToHandler = stats.clone();
		statsToHandler.sumStats(aEquipment.generateStatsContainer());
		this.name 	    = aName;
		this.basicStats = stats;
		this.equipment  = aEquipment;
		this.stats      = new StatsHandler(statsToHandler);
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
	
	public void recalculateStats(){
		StatsContainer statsToHandler = this.basicStats.clone();
		statsToHandler.sumStats(this.equipment.generateStatsContainer());
		this.stats = new StatsHandler(statsToHandler);
	}
	//**************//
	//** ACCESORS **//
	//**************//	
	public CharEquipment getEquipment() {
		return equipment;
	}
	
	public StatsContainer getBasicStats() {
		return basicStats;
	}
}
