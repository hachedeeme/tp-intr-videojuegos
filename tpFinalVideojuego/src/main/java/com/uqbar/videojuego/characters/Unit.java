package com.uqbar.videojuego.characters;

import java.util.List;
import java.util.Random;

import com.uqbar.videojuego.skills.Skill;

public abstract class Unit {
	protected String name;
	protected StatsHandler stats;
	protected List<Skill> skills;
	protected int attackRange = 1;
	
	protected Unit() {
	}
	
	//*************//
	//** METHODS **//
	//*************//
	/**
	 * Ataca a la Unit pasada por par�metro y le reduce el HP calculando el da�o, si da�o
	 * de la Unit atacante es mayor a la defensa de la Unit atacada, se le inflinge la 
	 * diferencia como da�o a su currentHP, sino, le inflinge 1 de da�o. 
	 * @param aUnit
	 */
	public void attack(Unit aUnit){
		int damage   = this.getPhysicalDamage();
		int defence  = aUnit.getPhysicalDefence();
		this.applyDamage(aUnit, damage, defence);
	}

	
	public void attackWith(Skill aSkill, Unit aUnit){
		int damage   = aSkill.calculeDamageOf(this);
		int defence  = aSkill.calculeDefenceOf(aUnit);
		applyDamage(aUnit, damage, defence);
	}
	
	private void applyDamage(Unit aUnit, int damage, int defence) {
		if(damage > defence){
			aUnit.inflictDamage(this.applyVariance(damage - defence));
		}
		else
			aUnit.inflictDamage(1);
	}
	
	public int applyVariance(int aValue){
		Random rand = new Random();
		double newValue = aValue * 10.0 / 100.0;
		return rand.nextInt((int)Math.ceil(newValue)) + aValue;
	}
	/**
	 * Retorna el da�o fisico que puede llegar a causar seg�n sus stats.
	 * @return int
	 */
	private int getPhysicalDamage(){
		return this.stats.getAttackPower();
	}
	
	/**
	 * Retorna la defensa fisica de la Unit seg�n sus stats.
	 * @return int
	 */
	private int getPhysicalDefence(){
		return this.stats.getArmor();
	}
	
	/**
	 * Recibe una cantidad de da�o por par�metro y se lo resta a su currentHP.
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
	
	@Override
	public String toString() {
		String enter = System.getProperty("line.separator");
		String resString = this.getName() + enter;
		resString += this.stats.toString();
		return resString;
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
	
	public int getAttackRange() {
		return attackRange;
	}
	
	public int getSpeed(){
		return this.stats.getSpeed();
	}
	
	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
	
	public int getMovility(){
		return this.stats.getMovility();
	}
	
	public int getHp(){
		return this.stats.getHp();
	}
	
	public int getCurrentHp(){
		return this.stats.getCurrentHp();
	}
	
	public int getMp(){
		return this.stats.getMp();
	}
	
	public int getCurrentMp(){
		return this.stats.getCurrentMp();
	}
}
