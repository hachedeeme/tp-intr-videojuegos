package com.uqbar.videojuego.characters;

import java.util.HashMap;
import java.util.Map;

import com.uqbar.videojuego.items.EquipType;
import com.uqbar.videojuego.items.Equipment;

public class CharEquipment {
	private Map<String,Equipment> equipment;
	
	public CharEquipment() {
		this.equipment = new HashMap<String, Equipment>();
		this.equipment.put("mainHand", null);
		this.equipment.put("offHand",  null);
		this.equipment.put("head",     null);
		this.equipment.put("body",     null);
		this.equipment.put("hand",     null);
		this.equipment.put("feet",     null);
		this.equipment.put("accesory", null);
	}
	
	//*************//
	//** METHODS **//
	//*************//
	/**
	 * Retorna el StatsContainer resultado de sumar los StatsContainers de todos 
	 * los Equipments.
	 * @return StatsContainer
	 */
	public StatsContainer generateStatsContainer(){
		StatsContainer stats = new StatsContainer(0, 0, 0, 0, 0, 0, 0);
		for (Equipment equip : this.equipment.values()) {
			if(equip != null)
				stats.sumStats(equip.getStats());
		}
		return stats;
	}
	
	/**
	 * Recine un Equipment por parámetro y lo agrega al CharEquipment segun su EquipType.
	 * Si ya había un Equipment de ese EquipType, es reemplazado por el nuevo. 
	 * Si el Equipment a equipar es del tipo TWOHANDED, se acomoda en la "mainHand" y la
	 * "offHand" queda en null.
	 * Si el Equipment a equipar es del tipo ONEHANDED, se acomoda en la "mainHand" pero
	 * si ya había uno en ese lugar, se acomoda en la "offHand". 
	 * @param aEquipment
	 */
	public void putEquipment(Equipment aEquipment){
		EquipType equipType = aEquipment.getType();
		switch (equipType) {
		case TWOHANDED:
			this.equipment.put(equipType.getEquipString(), aEquipment);
			this.equipment.put("offHand", null);
			break;
		case ONEHANDED:
			Equipment mainHand = this.getMainHand();
			if((mainHand == null) || (mainHand.getType() == EquipType.TWOHANDED))
				this.equipment.put(equipType.getEquipString(), aEquipment);
			else
				this.equipment.put("offHand", aEquipment);
			break;
		default:
			this.equipment.put(equipType.getEquipString(), aEquipment);
			break;
		}
	}
	
	public boolean haveMainHand(){
		return this.getMainHand() != null;
	}
	
	public boolean haveOffHand(){
		return this.getOffHand() != null;
	}
	
	@Override
	public String toString() {
		return this.equipment.toString();
	}
	
	//**************//
	//** ACCESORS **//
	//**************//
	public Equipment getAccesory() {
		return this.equipment.get("accesory");
	}
	 
	public Equipment getBody() {
		return this.equipment.get("body");
	}
	 
	public Equipment getFeet() {
		return this.equipment.get("feet");
	}
	 
	public Equipment getHand() {
		return this.equipment.get("hand");
	}
	 
	public Equipment getHead() {
		return this.equipment.get("head");
	}
	 
	public Equipment getMainHand() {
		return this.equipment.get("mainHand");
	}
	
	public Equipment getOffHand() {
		return this.equipment.get("offHand");
	}
}
