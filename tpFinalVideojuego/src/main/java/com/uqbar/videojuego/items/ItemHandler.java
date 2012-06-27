package com.uqbar.videojuego.items;

import java.util.HashMap;
import java.util.Map;

import com.uqbar.videojuego.characters.StatsContainer;

public class ItemHandler {
	public static ItemHandler INSTANCE = new ItemHandler();
	private Map<String, Item> items = new HashMap<String, Item>();
	
	protected ItemHandler() {
		this.initItems();
	}
	
	private void initItems(){
		//															WEAPONS	
		//	    							            HP MP Mov Spd Str Stm Int Wis
		this.addItem( "Dagger", new Equipment(
					  "Dagger",    	new StatsContainer( 0, 0, 0,  2,  15,  0,  0,  0), EquipType.ONEHANDED));
		this.addItem( "Shortsword", new Equipment(
					  "Shortsword", new StatsContainer( 0, 0, 0,  0,  25,  0,  0,  0), EquipType.ONEHANDED));
		this.addItem( "Iron Axe", new Equipment(
				      "Iron Axe",   new StatsContainer( 0, 0, 0,  0,  40,  8,  0,  0), EquipType.TWOHANDED));
		this.addItem( "Rod", new Equipment(
				 	  "Rod", 	    new StatsContainer( 0, 0, 0,  0,  10,  0, 10,  0), EquipType.ONEHANDED));
		this.addItem( "White Staff", new Equipment(
					  "White Staff",new StatsContainer( 0, 0, 0,  0,  20,  0,  8,  0) ,EquipType.TWOHANDED));
		
		//															  BODY	
		//	    							            HP MP Mov Spd Str Stm Int Wis
		this.addItem( "Iron Armor", new Equipment(
					  "Iron Armor", new StatsContainer( 0, 0, 0,  0,  0,  30,  0,  3) ,EquipType.CHEST));
		this.addItem( "Ninja Gear", new Equipment(
					  "Ninja Gear", new StatsContainer( 0, 0, 0,  6,  0,  27,  0,  6) ,EquipType.CHEST));
		this.addItem( "White Robe", new Equipment(
					  "White Robe", new StatsContainer( 0, 0, 0,  0,  0,  23,  3,  48),EquipType.CHEST));
		
		//		 													 HEAD	
		//	    							             HP MP Mov Spd Str Stm Int Wis
		this.addItem( "Iron Helm", new Equipment(
					  "Iron Helm",  new StatsContainer  ( 0, 0, 0,  0,  0,   5,  0,  2) ,EquipType.HELMET));
		this.addItem( "Wizard's Hat", new Equipment(
					  "Wizard's Hat", new StatsContainer( 0, 0, 0,  6,  0,   1,  3, 12) ,EquipType.HELMET));
		this.addItem( "Tiara", new Equipment(
					  "Tiara",      new StatsContainer  ( 0, 0, 0,  0,  0,   8,  2, 20) ,EquipType.HELMET));
		
		//		  													 FEET	
		//	    							              HP MP Mov Spd Str Stm Int Wis
		this.addItem( "Battle Boots", new Equipment(
					  "Battle Boots", new StatsContainer( 0, 0,  1,  0,  0,  2,  0,  0) ,EquipType.BOOTS));
		this.addItem( "Sprint Shoes", new Equipment(
					  "Sprint Shoes", new StatsContainer( 0, 0,  2,  2,  0,  2,  0,  0) ,EquipType.BOOTS));
		this.addItem( "Ninja Tabi", new Equipment(
					  "Ninja Tabi",   new StatsContainer( 0, 0,  2,  1,  0,  3,  0,  0) ,EquipType.BOOTS));
		
		//		  										    	   HAND	
		//	    							           HP MP Mov Spd Str Stm Int Wis
		this.addItem( "Armguards", new Equipment(
					  "Armguards", new StatsContainer( 0, 0,  0,  0,  1,  2,  0,  0) ,EquipType.GLOVES));
		this.addItem( "Gauntlets", new Equipment(
					  "Gauntlets", new StatsContainer( 0, 0,  0,  0,  2,  5,  0,  5) ,EquipType.GLOVES));
		
		//		  										    	  ACCESORY	
		//	    							             HP MP Mov Spd Str Stm Int Wis
		this.addItem( "Magic Ring", new Equipment(
					  "Magic Ring", new StatsContainer( 0, 0,  0,  0,  0,  0,  5,  5) ,EquipType.ACCESORY));
		this.addItem( "Amulet", new Equipment(
					  "Amulet",      new StatsContainer( 0, 0,  0,  0,  5,  5,  0,  0) ,EquipType.ACCESORY));
	}

	public void addItem(String name, Item anItem){
		this.items.put(name, anItem);
	}
	
	public Equipment getEquipment(String name){
		return (Equipment) this.items.get(name);
	}
}
