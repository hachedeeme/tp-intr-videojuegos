package unq.videojuego.components;

import java.awt.Color;
import java.awt.Font;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;

public class Ornament extends GameComponent<VideojuegoScene> {
	private Font font;
	private Color color;
	private int width;

	
	public Ornament(int x, int y, int z, Appearance aAppearance) {
		super(aAppearance,x,y);
		this.font = new Font("monospaced", Font.BOLD, 22);
		this.color = Color.WHITE;
		this.setZ(z);
	}
	
	public Font getFont() {
		return font;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
}
