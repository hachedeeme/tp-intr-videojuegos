package com.uqbar.videojuego.skills;

public class Skill {
	private String name;
	private int cost;
	
	public Skill(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}

}
