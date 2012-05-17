package com.uqbar.videojuego.characters;

import java.util.ArrayList;

import com.uqbar.videojuego.items.Equipment;
import com.uqbar.videojuego.skills.Skill;

public class Character extends Unit{
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
	/**
	 * Recalcula los valores su StatHandler.
	 */
	public void recalculateStats(){
		StatsContainer statsToHandler = this.basicStats.clone();
		statsToHandler.sumStats(this.equipment.generateStatsContainer());
		this.stats = new StatsHandler(statsToHandler);
	}
	
	/**
	 * Agrega a su CharEquipment el Equipment pasado por parámetro, si ya tiene uno 
	 * de ese tipo es reemplazado por el nuevo. Luego recalcula los stats del StatsHandler.
	 * @param aEquipment
	 */
	public void equip(Equipment aEquipment){
		this.equipment.putEquipment(aEquipment);
		this.recalculateStats();
	}
	
	/**
	 * Retorna la movilidad del Character.
	 * @return int
	 */
	@Override
	public int getMovility() {
		return super.movility + this.stats.calculateMovility();
	}
	
	/**
	 * Retorna el rango de ataque que tiene un Character, si tiene un arma Equipada
	 * devuelve el rango del arma, sino devuelve rango 1.
	 * @return int
	 */
	@Override
	public int getAttackRange() {
		if(this.equipment.haveMainHand())
			return this.equipment.getMainHand().getRange();			
		return super.getAttackRange();
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
