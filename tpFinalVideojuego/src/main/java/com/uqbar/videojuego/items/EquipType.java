package com.uqbar.videojuego.items;

public enum EquipType {
	ONEHANDED, TWOHANDED, CHEST, HELMET, BOOTS, GLOVES, ACCESORY;
	
	public String getEquipString(){
		switch(this){
		case ONEHANDED: return "mainHand";
		case TWOHANDED: return "mainHand";
		case CHEST:  	return "body";
		case HELMET:    return "head";
		case BOOTS:     return "feet";
		case GLOVES:    return "hand";
		case ACCESORY:  return "accesory";
		default: return "";
		}
	}
}
