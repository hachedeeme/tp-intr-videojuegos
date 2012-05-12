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
	public StatsContainer generateStatsContainer(){
		StatsContainer stats = new StatsContainer(0, 0, 0, 0, 0, 0, 0);
		for (Equipment equip : this.equipment.values()) {
			if(equip != null)
				stats.sumStats(equip.getStats());
		}
		return stats;
	}
	
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
