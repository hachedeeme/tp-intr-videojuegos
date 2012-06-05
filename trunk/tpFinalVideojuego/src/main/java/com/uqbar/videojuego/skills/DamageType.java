package com.uqbar.videojuego.skills;

import com.uqbar.videojuego.characters.StatsHandler;
import com.uqbar.videojuego.characters.Unit;

public enum DamageType {
	PHYSICALDAMAGE, MAGICDAMAGE;
	
	public int damageOf(Unit aUnit){
		StatsHandler stats = aUnit.getStats();
		if(this == PHYSICALDAMAGE){
			return stats.calculatePhysicalDamage();
		}
		return stats.calculatePhysicalDefence();
	}
	
	public int defenceOf(Unit aUnit){
		StatsHandler stats = aUnit.getStats();
		if(this == PHYSICALDAMAGE){
			return stats.calculateMagicDamage();
		}
		return stats.calculateMagicDefence();
	}
}
