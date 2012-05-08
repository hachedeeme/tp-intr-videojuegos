package com.uqbar.videojuego.characters;

import com.uqbar.videojuego.items.Equipment;

public class CharEquipment {
	private Equipment mainHand;
	private Equipment offHand;
	private Equipment head;
	private Equipment body;
	private Equipment hand;
	private Equipment feet;
	private Equipment accesory;
	
	public CharEquipment(Equipment mainHand, Equipment offHand, Equipment head,
						 Equipment body, Equipment hand, Equipment feet, 
			 			 Equipment accesory) {
		this.mainHand = mainHand;
		this.offHand = offHand;
		this.head = head;
		this.body = body;
		this.hand = hand;
		this.feet = feet;
		this.accesory = accesory;
	}
	
	//*************//
	//** METHODS **//
	//*************//
	public void modifyStats(StatsHandler aStatH){
	}
	
	//**************//
	//** ACCESORS **//
	//**************//
	public Equipment getAccesory() {
		return accesory;
	}
	 
	public Equipment getBody() {
		return body;
	}
	 
	public Equipment getFeet() {
		return feet;
	}
	 
	public Equipment getHand() {
		return hand;
	}
	 
	public Equipment getHead() {
		return head;
	}
	 
	public Equipment getMainHand() {
		return mainHand;
	}
	
	public Equipment getOffHand() {
		return offHand;
	}
}
