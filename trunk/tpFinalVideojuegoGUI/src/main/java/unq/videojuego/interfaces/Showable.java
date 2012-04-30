package unq.videojuego.interfaces;

import java.awt.Graphics2D;

public interface Showable {
	
	public String getName();
	
	public Showable getElement();

	public void render(Graphics2D graphics);

}
