package com.uqbar.videojuego.characters;

public class StatsContainer {
	protected int hp;
	protected int mp;
	protected int movility;
	protected int speed;
	protected int strength;
	protected int stamina;
	protected int intellect;
	protected int wisdom;
	
	public StatsContainer(int hp, int mp,int movility, int speed, int strength,
						  int stamina, int intellect, int wisdom) {
		this.hp = hp;
		this.mp = mp;
		this.movility  = movility;
		this.speed     = speed;
		this.strength  = strength;
		this.stamina   = stamina;
		this.intellect = intellect;
		this.wisdom    = wisdom;
	}
	
	public StatsContainer(int hp, int mp, int speed,
			int strength, int stamina, int intellect, int wisdom) {
		this(hp, mp, 2, speed, strength, stamina, intellect, wisdom);
	}

	//*************//
	//** METHODS **//
	//*************//
	/**
	 * Recibe un StatsContainer por par�metro y le suma los valores correspondientes a cada
	 * campo al objeto receptor.
	 * @param stats
	 */
	public void sumStats(StatsContainer stats){
		this.hp += stats.getHp();
		this.mp += stats.getMp();
		this.movility += stats.getMovility();
		this.speed += stats.getSpeed();
		this.strength += stats.getStrength();
		this.stamina += stats.getStamina();
		this.intellect += stats.getIntellect();
		this.wisdom += stats.getWisdom();
	}
	
	/**
	 * Retorna un StatsContainer con los mismos valores que el objeto receptor.
	 * @return StatsContainer
	 */
	public StatsContainer clone(){
		StatsContainer stats = new StatsContainer(0, 0, 0, 0, 0, 0, 0);
		stats.sumStats(this);
		return stats;
	}
	
	
	//**************//
	//** ACCESORS **//
	//**************//
	public int getHp() {
		return hp;
	}

	public int getMp() {
		return mp;
	}

	public int getSpeed() {
		return speed;
	}

	public int getStrength() {
		return strength;
	}

	public int getStamina() {
		return stamina;
	}

	public int getIntellect() {
		return intellect;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getMovility() {
		return movility;
	}
	
	//**************//
	//** PRINTING **//
	//**************//
	protected String statsToString(){
		String enter = System.getProperty("line.separator");
		String resString = "Movility = " + this.movility + enter;
		resString += "Speed = " + this.speed + enter;
		resString += "Strength = "  + this.strength + enter;
		resString += "Stamina = "   + this.stamina + enter;
		resString += "Intellect = " + this.intellect + enter;
		resString += "Wisdom = "    + this.wisdom + enter;
		return resString;
	}
	
	@Override
	public String toString() {
		String enter = System.getProperty("line.separator");
		String resString = "HP = " + this.hp + enter;
		resString += "MP = " + this.mp + enter;
		resString += this.statsToString();
		return resString;
	}
}
