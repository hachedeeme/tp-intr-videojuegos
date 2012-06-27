package com.uqbar.videojuego.characters;

public class StatsHandler extends StatsContainer {
	private int currentHp;
	private int currentMp;
	private int attackPower;
	private int spellPower;
	private int magicResist;
	private int armor;
	
	public StatsHandler(StatsContainer stats) {
		super(0,0,0,0,0,0,0,0);
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
	public void decreaseHP(int amount){
		if(this.currentHp > amount)
			this.currentHp -= amount;
		else
			this.currentHp = 0;
	}
	
	public void increaseHP(int amount){
		if((this.hp - this.currentHp) > amount)
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
		if((this.mp - this.currentMp) > amount)
			this.currentMp += amount;
		else
			this.currentMp = this.mp;
	}
	
	//************************//
	//** STATS CALCULATIONS **//
	//************************//
	public int calculateAttackPower(){
		return this.strength * 150/100 + this.stamina * 20/100;
	}
	
	public int calculateSpellPower(){
		return this.intellect * 150/100 + this.wisdom * 20/100;
	}
	
	public int calculateArmor(){
		return this.stamina + this.strength * 20/100;
	}
	
	public int calculateMagicResist(){
		return this.wisdom  + this.intellect * 20/100;
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
	
	public StatsHandler copy(){
		StatsContainer stats = new StatsContainer(this.hp, this.mp, this.movility, this.speed, 
												  this.strength, this.stamina, this.intellect, 
												  this.wisdom);
		return new StatsHandler(stats);
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
		resString += "Spell Power  = " + this.spellPower + enter;
		resString += "Armor        = " + this.armor + enter;
		resString += "Magic Resist = " + this.magicResist + enter;
		return resString;
	}
}
