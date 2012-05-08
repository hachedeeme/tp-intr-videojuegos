package unq.videojuego.interfaces;

import java.awt.Graphics2D;

public interface Showable {
	
	public String getName();

	public void render(Graphics2D graphics);
	
	public void setX(int x, int windowWidth);

}
