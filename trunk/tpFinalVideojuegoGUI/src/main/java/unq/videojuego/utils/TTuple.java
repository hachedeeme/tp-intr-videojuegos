package unq.videojuego.utils;

import java.awt.Point;

public class TTuple {
	private int x;
	private int y;
	private int counter;
	
	public TTuple(int x, int y, int counter) {
		super();
		this.x = x;
		this.y = y;
		this.counter = counter;
	}
	
	public TTuple(Point point, int counter) {
		super();
		this.x = (int) point.getX();
		this.y = (int) point.getY();
		this.counter = counter;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.x == ((TTuple)obj).getX()  &&  this.y == ((TTuple)obj).getY();
	}
	
	

}
