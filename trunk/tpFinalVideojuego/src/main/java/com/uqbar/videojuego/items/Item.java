package com.uqbar.videojuego.items;

import java.util.List;

import com.uqbar.videojuego.items.itemActions.ItemAction;

public abstract class Item {
	private String name;
	private List<ItemAction> actions;  

	protected Item(String name){
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ItemAction> getActions() {
		return actions;
	}

	public void setActions(List<ItemAction> actions) {
		this.actions = actions;
	}
	
	
	
}
