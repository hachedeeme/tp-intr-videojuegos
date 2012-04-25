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
		this((int)point.getX(), (int)point.getY(), counter);
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + counter;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TTuple other = (TTuple) obj;
		if (counter != other.counter)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public boolean counterSmallerOrEqual(TTuple tuple) {
		return this.counter <= tuple.getCounter();
	}
	
	public boolean equalsCoords(TTuple tuple) {
		return this.x == tuple.getX() && this.y == tuple.getY();
	}

	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + "," + this.counter + ")";
	}
	
	

}
