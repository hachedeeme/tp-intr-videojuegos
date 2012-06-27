package unq.videojuego.utils;

import java.util.HashMap;
import java.util.Map;

import unq.videojuego.components.BattleUnit;

public class UnitHandler {
	public static UnitHandler INSTANCE = new UnitHandler();
	private Map<String, BattleUnit> units = new HashMap<String, BattleUnit>();
	
	public void addUnit(BattleUnit unit){
		this.units.put(unit.getName(), unit);
	}
	
	public void addUnits(BattleUnit...units){
		for (BattleUnit unit : units){
			this.addUnit(unit);
		}
	}
	
	public BattleUnit getUnit(String name){
		return this.units.get(name).copy();
	}
}
