package unq.videojuego.components.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import unq.videojuego.components.Ornament;
import unq.videojuego.scenes.VideojuegoScene;
import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Label;
import com.uqbar.vainilla.appearances.Sprite;

public class ListElement extends GameComponent<VideojuegoScene>{
	private Ornament picture;
	private Ornament text;
	private int width;
	private int height;
	
	public ListElement(int x, int y, String imagePath, String text) {
		Sprite image = Sprite.fromImage(imagePath);
		Font font = new Font("monospaced", Font.BOLD, 22);
		int space = 10; 
		this.width  = (int) image.getWidth();
		this.height = (int) image.getHeight();
		
		this.picture = new Ornament(x, y, 0, image);
		this.text    = new Ornament(x + this.width + 10, y, 0, new Label(font, Color.WHITE, text));
	}
	
	@Override
	public void render(Graphics2D graphics) {
		this.picture.render(graphics);
		this.text.render(graphics);
	}
	
	//***************//
	//** ACCESSORS **//
	//*** ***********//
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}	
}
