package com.uqbar.videojuego.characters;

import java.util.List;

import com.uqbar.videojuego.skills.Skill;

public abstract class Unit {
	protected String name;
	protected StatsHandler stats;
	protected List<Skill> skills;
	protected int movility = 3;
	protected int attackRange = 1;
	
	protected Unit() {
	}
	
	//*************//
	//** METHODS **//
	//*************//
	/**
	 * Ataca a la Unit pasada por parámetro y le reduce el HP calculando el daño, si daño
	 * de la Unit atacante es mayor a la defensa de la Unit atacada, se le inflinge la 
	 * diferencia como daño a su currentHP, sino, le inflinge 1 de daño. 
	 * @param aUnit
	 */
	public void attack(Unit aUnit){
		int damage   = this.getPhysicalDamage();
		int defence  = aUnit.getPhysicalDefence();
		if(damage > defence)
			aUnit.inflictDamage(damage - defence);
		else
			aUnit.inflictDamage(1);
	}
	
	public void attackWith(Skill aSkill, Unit aUnit){
		int damage   = aSkill.calculeDamageOf(this);
		int defence  = aSkill.calculeDefenceOf(aUnit);
		if(damage > defence)
			aUnit.inflictDamage(damage - defence);
		else
			aUnit.inflictDamage(1);
	}
	
	/**
	 * Retorna el daño fisico que puede llegar a causar según sus stats.
	 * @return int
	 */
	private int getPhysicalDamage(){
		return this.stats.calculatePhysicalDamage();
	}
	
	/**
	 * Retorna la defensa fisica de la Unit según sus stats.
	 * @return int
	 */
	private int getPhysicalDefence(){
		return this.stats.calculatePhysicalDefence();
	}
	
	/**
	 * Recibe una cantidad de daño por parámetro y se lo resta a su currentHP.
	 * @param amount
	 */
	private void inflictDamage(int amount){
		this.stats.decreaseHP(amount);
	}
	
	/**
	 * Retorna si el currentHp de la Unit es menor o igual a 0.
	 * @return boolean
	 */
	public boolean isDeat(){
		return this.stats.getCurrentHp() <= 0;
	}
	
	public void addSkill(Skill aSkill){
		this.skills.add(aSkill);
	}
	
	public void addSkills(List<Skill> skills){
		for (Skill skill : skills) {
			this.addSkill(skill);
		}
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
	
	public int getMovility() {
		return movility;
	}
	
	public int getAttackRange() {
		return attackRange;
	}
	
	/**
	 * Obtiene la agility de una Unit
	 * @return int 
	 */
	public int getAgility(){
		return this.stats.getAgility();
	}
	
	public void setMovility(int movility) {
		this.movility = movility;
	}
	
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	
}
