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
	
	/*
	 * Calculos de stats, hasta ahora la formula es, 40% de su primer atributo sumado a
	 * el 20% de su segundo atributo. Esto está así por ahora porque es para probar, tengo
	 * la tendencia de hacer algún otro tipo de formula con respecto a esto y a los daños. */
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
	
	/**
	 * Cada 100 puntos de agility es uno de movility.
	 * @return
	 */
	public int calculateMovility(){
		return this.agility/100;
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
	
	/*
	 * Hasta ahora, los cálculos de daño fisico y mágico son: su atributo especifico(Fuerza
	 * en caso de daño físico) más su ataque especifico más un random de 0 a 10 para que
	 * los ataques varien un poco, estuve viendo ejemplos y se usa bastante y lo llaman 
	 * varianza, lo puse para probar que onda y por ahora va... como dije en el comentario 
	 * aterior, estoy en busca de una que me paresca mejor y mas copada, esta me va, pero por
	 * ahora. Despues hablaremos sobre eso supongo :P .*/
	//*************************************//
	//** DAMAGE AND DEFENCE CALCULATIONS **//
	//*************************************//
	public int calculatePhysicalDamage(){
		return this.getStrength() + this.getAttackPower() + this.getVariance();
	}
	
	public int calculatePhysicalDefence(){
		return this.getArmor() + this.getStamina()*20/100 + this.getVariance();
	}
	
	public int calculateMagicDamage(){
		return this.getIntellect() + this.getSpellPower() + this.getVariance();
	}
	
	public int calculateMagicDefence(){
		return this.getMagicResist() + this.getWisdom()*20/100 + this.getVariance();
	}
	
	public int getVariance(){
		Random rand = new Random();		
		return rand.nextInt(10);
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
