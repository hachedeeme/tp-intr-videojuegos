package com.uqbar.videojuego.characters;

import java.util.ArrayList;

import com.uqbar.videojuego.items.Equipment;
import com.uqbar.videojuego.skills.Skill;

public class Character extends Unit{
	private StatsContainer basicStats;
	private CharEquipment equipment;
	
	public Character(String aName, StatsContainer stats) {
		StatsContainer statsToHandler = stats.clone();
		this.name 	    = aName;
		this.basicStats = stats;
		this.equipment  = new CharEquipment();
		statsToHandler.sumStats(this.equipment.generateStatsContainer());
		this.stats      = new StatsHandler(statsToHandler);
		this.skills     = new ArrayList<Skill>();
	}
	
	private Character(String aName, StatsContainer basicStats, StatsHandler stats, CharEquipment equipment){
		this.name = aName;
		this.basicStats = basicStats;
		this.equipment = equipment;
		this.stats = stats;
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
	 * Agrega a su CharEquipment el Equipment pasado por par�metro, si ya tiene uno 
	 * de ese tipo es reemplazado por el nuevo. Luego recalcula los stats del StatsHandler.
	 * @param aEquipment
	 */
	public void equip(Equipment aEquipment){
		this.equipment.putEquipment(aEquipment);
		this.recalculateStats();
	}
	

	/**
	 * Retorna el rango de ataque que tiene un Character, si tiene un arma Equipada
	 * devuelve el rango del arma, sino devuelve rango 1.
	 * @return int
	 */
	@Override
	public int getAttackRange() {
		if(this.equipment.haveMainHand() && this.equipment.getMainHand().getRange() > 1)
			return this.equipment.getMainHand().getRange();			
		return super.getAttackRange();
	}
	
	@Override
	public String toString() {
		String enter = System.getProperty("line.separator");
		String resString = super.toString() + this.equipment.toString() + enter;		
		return resString;
	}
	
	public Character copy(){
		return new Character(this.name, this.basicStats.clone(), this.stats.copy(), this.equipment.copy());
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
