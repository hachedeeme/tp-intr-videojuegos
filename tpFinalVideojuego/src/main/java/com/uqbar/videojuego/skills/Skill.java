package com.uqbar.videojuego.skills;

import com.uqbar.videojuego.characters.Unit;


public class Skill {
	private String name;
	private DamageType type;
	private int cost;
	private int currentCost;
	private int basicDamage;
	
	public Skill(String name, int cost, int basicDamage, DamageType type) {
		this.name = name;
		this.cost = cost;
		this.currentCost = cost;
		this.basicDamage = basicDamage;
		this.type = type;
	}
	
	private int percentageOfCost(int percentage){
		return this.cost * percentage / 100;
	}
	
	public void raiseCost(){
		this.currentCost += this.percentageOfCost(50);
	}
	
	public void reduceCost(){
		if(this.currentCost > this.cost){
			this.currentCost -= this.percentageOfCost(34);
			if(this.currentCost < this.cost)
				this.currentCost = this.cost;
		}
	}
	
	public int calculeDamageOf(Unit aUnit){
		return this.basicDamage + this.type.damageOf(aUnit);
	}
	
	public int calculeDefenceOf(Unit aUnit){
		return this.type.defenceOf(aUnit);
	}
	
	//**************//
	//** ACCESORS **//
	//**************//	
	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}

	public int getCurrentCost() {
		return currentCost;
	}
	
	public int getBasicDamage() {
		return basicDamage;
	}
	
	public DamageType getType() {
		return type;
	}
}
