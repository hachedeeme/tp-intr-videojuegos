package com.uqbar.videojuego.characters;

import java.util.List;

import com.uqbar.videojuego.skills.Skill;

public abstract class Actor {
	protected String name;
	protected StatsHandler stats;
	protected List<Skill> skills;
	
	protected Actor() {
	}
	
	//*************//
	//** METHODS **//
	//*************//
	public void attack(Actor anActor){
		int damage = this.getStrength() + this.getAttackPower();
		int armor  = anActor.getArmor();
		if(damage > armor)
			anActor.inflictDamage(damage - armor);
		else
			anActor.inflictDamage(1);
	}
	
	public void inflictDamage(int amount){
		this.stats.decreaseHP(amount);
	}
	
	public boolean isDeat(){
		return this.stats.getCurrentHp() <= 0;
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
	
	public int getStrength(){
		return this.stats.getStrength();
	}
	
	public int getStamina(){
		return this.stats.getStamina();
	}
	
	public int getCurrentHp() {
		return this.stats.getCurrentHp();
	}
	
	public int getCurrentMp() {
		return this.stats.getCurrentMp();
	}
	public int getArmor() {
		return this.stats.getArmor();
	}
	
	public int getAttackPower() {
		return this.stats.getAttackPower();
	}
	
	
	public int getMagicResist() {
		return this.stats.getMagicResist();
	}
	
	public int getSpellPower() {
		return this.stats.getSpellPower();
	}

}
