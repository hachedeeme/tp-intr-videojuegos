package com.uqbar.videojuego.characters;

public class StatsContainer {
	protected int hp;
	protected int mp;
	protected int agility;
	protected int strength;
	protected int stamina;
	protected int intellect;
	protected int wisdom;
	
	public StatsContainer(int hp, int mp, int agility, int strength,
						  int stamina, int intellect, int wisdom) {
		this.hp = hp;
		this.mp = mp;
		this.agility = agility;
		this.strength = strength;
		this.stamina = stamina;
		this.intellect = intellect;
		this.wisdom = wisdom;
	}

	//*************//
	//** METHODS **//
	//*************//		
	public void sumStats(StatsContainer stats){
		this.hp += stats.getHp();
		this.mp += stats.getMp();
		this.agility += stats.getAgility();
		this.strength += stats.getStrength();
		this.stamina += stats.getStamina();
		this.intellect += stats.getIntellect();
		this.wisdom += stats.getWisdom();
	}
	
	//**************//
	//** ACCESORS **//
	//**************//
	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getAgility() {
		return agility;
	}

	public int getStrength() {
		return strength;
	}

	public int getStamina() {
		return stamina;
	}

	public int getIntellect() {
		return intellect;
	}

	public int getWisdom() {
		return wisdom;
	}
	
	
}
