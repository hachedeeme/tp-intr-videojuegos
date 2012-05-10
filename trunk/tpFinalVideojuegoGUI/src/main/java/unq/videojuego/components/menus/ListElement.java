package unq.videojuego.components.menus;

import java.awt.Color;
import java.awt.Font;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Appearance;

public class ListElement extends GameComponent<VideojuegoScene> {
	private Font font;
	private Color color;
	private double width;

	public ListElement(int x, int y, int z, Appearance anAppearance) {
		super(anAppearance,x,y);
		this.font = new Font("monospaced", Font.BOLD, 18);
		this.color = Color.WHITE;
		this.setZ(z);
	}
	
	public Font getFont() {
		return font;
	}
	
	public Color getColor() {
		return color;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
}
