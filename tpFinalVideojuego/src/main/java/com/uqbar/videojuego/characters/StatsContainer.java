package com.uqbar.videojuego.characters;

public class StatsContainer {
	protected int hp;
	protected int mp;
	protected int mobility;
	protected int strength;
	protected int stamina;
	protected int intellect;
	protected int wisdom;
	
	public StatsContainer(int hp, int mp, int mobility, int strength,
						  int stamina, int intellect, int wisdom) {
		this.hp = hp;
		this.mp = mp;
		this.mobility = mobility;
		this.strength = strength;
		this.stamina = stamina;
		this.intellect = intellect;
		this.wisdom = wisdom;
	}
}
