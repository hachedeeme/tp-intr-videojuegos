package com.uqbar.videojuego.characters;


public class StatsHandler extends StatsContainer {
	private int currentHp;
	private int currentMp;
	private int attackPower;
	private int spellPower;
	private int magicResist;
	private int armor;

	public StatsHandler(int hp, int mp, int mobility, int strength,
						int stamina, int intellect, int wisdom) {
		super(hp, mp, mobility, strength, stamina, intellect, wisdom);
		this.currentHp = hp;
		this.currentMp = mp;
		this.attackPower = this.calculateAttackPower();
		this.armor 		 = this.calculateArmor();
		this.spellPower  = this.calculateSpellPower();
		this.magicResist = this.calculateMagicResist();
	}
	
	//*************//
	//** METHODS **//
	//*************//	
	public int calculateAttackPower(){
		return 0;
	}
	
	public int calculateSpellPower(){
		return 0;
	}
	
	public int calculateArmor(){
		return 0;
	}
	
	public int calculateMagicResist(){
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
}
