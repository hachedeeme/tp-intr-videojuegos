package com.uqbar.videojuego.characters;

import java.util.Random;


public class StatsHandler extends StatsContainer {
	private int currentHp;
	private int currentMp;
	private int attackPower;
	private int spellPower;
	private int magicResist;
	private int armor;
	
	public StatsHandler(StatsContainer stats) {
		super(0,0,0,0,0,0,0);
		this.sumStats(stats);
		this.currentHp = this.hp;
		this.currentMp = this.mp;
		this.attackPower = this.calculateAttackPower();
		this.armor 		 = this.calculateArmor();
		this.spellPower  = this.calculateSpellPower();
		this.magicResist = this.calculateMagicResist();
	}
	
	//*************//
	//** METHODS **//
	//*************//
	/**
	 * Obtiene la variansa del valor pasado por parámetro, la variansa es un numero 
	 * random de 0 hasta el 10% del valor pasado.
	 * @param aValue
	 * @return
	 */
	public int getVarianceOf(int aValue){
		Random rand = new Random();
		int value = aValue * 10 / 100;
		return rand.nextInt(value);
	}
	
	public void decreaseHP(int amount){
		if(this.currentHp > amount)
			this.currentHp -= amount;
		else
			this.currentHp = 0;
	}
	
	public void increaseHP(int amount){
		if((this.hp - this.currentHp) < amount)
			this.currentHp += amount;
		else
			this.currentHp = this.hp;
	}
	
	public void decreaseMP(int amount){
		if(this.currentMp > amount)
			this.currentMp -= amount;
		else
			this.currentMp = 0;
	}
	
	public void increaseMP(int amount){
		if((this.mp - this.currentMp) < amount)
			this.currentMp += amount;
		else
			this.currentMp = this.mp;
	}
	
	//************************//
	//** STATS CALCULATIONS **//
	//************************//
	public int calculateAttackPower(){
		return this.strength * 40/100 + this.stamina * 20/100;
	}
	
	public int calculateSpellPower(){
		return this.intellect * 40/100 + this.wisdom * 20/100;
	}
	
	public int calculateArmor(){
		return this.stamina * 40/100 + this.strength * 20/100;
	}
	
	public int calculateMagicResist(){
		return this.wisdom * 40/100 + this.intellect * 20/100;
	}
	
	//*************************************//
	//** DAMAGE AND DEFENCE CALCULATIONS **//
	//*************************************//
	public int calculatePhysicalDamage(){
		return this.calculateStats(this.strength, this.attackPower);
	}
	
	public int calculatePhysicalDefence(){
		return this.calculateStats(this.armor, this.stamina*20/100);
	}
	
	public int calculateMagicDamage(){
		return this.calculateStats(this.intellect, this.spellPower);
	}
	
	public int calculateMagicDefence(){
		return this.calculateStats(this.magicResist, this.wisdom/20/100);
	}
	
	/**
	 * Recive los valores de dos stats por parámetro, los suma y le suma una variansa.
	 * @param firstStat
	 * @param secondStat
	 * @return
	 */
	private int calculateStats(int firstStat, int secondStat){
		int res = firstStat + secondStat;
		res += this.getVarianceOf(res);
		return 0;
	}
	
	//**************//
	//** ACCESORS **//
	//**************//
	public int getArmor() {
		return armor;
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	public int getCurrentHp() {
		return currentHp;
	}
	
	public int getCurrentMp() {
		return currentMp;
	}
	
	public int getMagicResist() {
		return magicResist;
	}
	
	public int getSpellPower() {
		return spellPower;
	}
	
	@Override
	public int getMovility() {
		return this.movility;
	}
	
	//**************//
	//** PRINTING **//
	//**************//
	@Override
	public String toString() {
		String enter = System.getProperty("line.separator");
		String resString = "HP = " + this.hp + "/"+ this.currentHp + enter;
		resString += "MP = " + this.mp + "/"+ this.currentMp + enter;
		resString += this.statsToString();
		resString += "Attack Power = " + this.attackPower + enter;
		resString += "Spell Power = " + this.spellPower + enter;
		resString += "Armor = " + this.armor + enter;
		resString += "Magic Resist = " + this.magicResist + enter;
		return resString;
	}
}
