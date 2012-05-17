package unq.videojuego.components.menus;

import java.awt.Graphics2D;

public abstract class Showable {

	public abstract void render(Graphics2D graphics);
	
	public abstract void setX(double start, double end);
	
	public abstract void setY(double y);
	
	public double getHeight(){
		return 32;
	}

}
