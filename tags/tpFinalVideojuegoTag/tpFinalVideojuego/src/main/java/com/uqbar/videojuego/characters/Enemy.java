package com.uqbar.videojuego.characters;

import java.util.ArrayList;

import com.uqbar.videojuego.skills.Skill;


public class Enemy extends Unit{
	
	
	public Enemy(String aName, int hp, int mp, int agility,
			 int strength, int stamina, int intellect, int wisdom ) {
	StatsContainer basicStats = new StatsContainer(hp, mp, agility, strength,
									stamina, intellect, wisdom);
	this.name = aName;
	this.stats = new StatsHandler(basicStats);
	this.skills = new ArrayList<Skill>();
	}
	
	public Enemy(String aName, int movility, int attackRange, int hp, int mp, int agility,
				 int strength, int stamina, int intellect, int wisdom ) {
		StatsContainer basicStats = new StatsContainer(hp, mp, agility, strength,
										stamina, intellect, wisdom);
		this.name     = aName;
		this.stats    = new StatsHandler(basicStats);
		this.skills   = new ArrayList<Skill>();
		this.movility = movility;
		this.attackRange = attackRange;
	}
}
