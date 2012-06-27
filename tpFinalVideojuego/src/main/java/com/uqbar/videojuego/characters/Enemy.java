package com.uqbar.videojuego.characters;

import java.util.ArrayList;

import com.uqbar.videojuego.skills.Skill;


public class Enemy extends Unit{
	
	/**
	 * Construye un Enemy con un nombre y los stats basicos pasados por parametro. El rango 
	 * de ataque (attackRange) es 1 y la movilidad (movility) es 2 que son los valores que
	 * tienen por default.  
	 * 
	 * @param aName
	 * @param hp
	 * @param mp
	 * @param speed
	 * @param strength
	 * @param stamina
	 * @param intellect
	 * @param wisdom
	 */
	public Enemy(String aName, int hp, int mp,
							   int speed,
							   int strength, int stamina, int intellect, int wisdom ) {
		
	StatsContainer basicStats = new StatsContainer(hp, mp, speed, strength,
									stamina, intellect, wisdom);
	this.name   = aName;
	this.stats  = new StatsHandler(basicStats);
	this.skills = new ArrayList<Skill>();
	}
	
	/**
	 * Construye un Enemy con un nombre, los stats basicos y el rango de ataque (attackRange)
	 * pasados por parámetro. La movilidad (movility) es 2 que es el valor que tiene por default.
	 * 
	 * @param aName
	 * @param attackRange
	 * @param hp
	 * @param mp
	 * @param speed
	 * @param strength
	 * @param stamina
	 * @param intellect
	 * @param wisdom
	 */
	public Enemy(String aName, int attackRange, 
							   int hp, int mp, 
							   int speed,
							   int strength, int stamina, int intellect, int wisdom ) {
		
		StatsContainer basicStats = new StatsContainer(hp, mp, speed, strength,
										stamina, intellect, wisdom);
		this.name     = aName;
		this.stats    = new StatsHandler(basicStats);
		this.skills   = new ArrayList<Skill>();
		this.attackRange = attackRange;
	}
	
	/**
	 * Construye un Enemy con un nombre, los stats basicos, el rango de ataque (attackRange) y la
	 * movilidad (movility) pasados por parámetro. Este constructor es para especificar todos los 
	 * datos de un Enemy sin que use sus valores default.
	 * 
	 * @param aName
	 * @param attackRange
	 * @param movility
	 * @param hp
	 * @param mp
	 * @param speed
	 * @param strength
	 * @param stamina
	 * @param intellect
	 * @param wisdom
	 */
	public Enemy(String aName, int attackRange, int movility,
							   int hp, int mp,
							   int speed,
							   int strength, int stamina, int intellect, int wisdom ) {
		
		StatsContainer basicStats = new StatsContainer(hp, mp, movility, speed, strength,
										stamina, intellect, wisdom);
		this.name   = aName;
		this.stats  = new StatsHandler(basicStats);
		this.skills = new ArrayList<Skill>();
		this.attackRange = attackRange;
	}
	
	private Enemy(String aName, int attackRange, StatsHandler stats){
		this.name = aName;
		this.stats  = stats;
		this.skills = new ArrayList<Skill>();
		this.attackRange = attackRange;
	}
	
	public Enemy copy(){
		return new Enemy(this.getName(), this.getAttackRange(), this.stats.copy());
	}
}
