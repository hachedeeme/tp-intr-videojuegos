package com.uqbar.videojuego.items;

public abstract class Stackable extends Item {
	private int quantity;
	private int price;

	protected Stackable(String name, int quantity, int price) {
		super(name);
		this.quantity = quantity;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
