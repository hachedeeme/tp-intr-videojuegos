package unq.videojuego.interfaces;

import java.awt.Graphics2D;

public interface Showable {

	public void render(Graphics2D graphics);
	
	public void setX(double start, double end);
	
	public void setY(double y);
	
	public double getHeight();

}
