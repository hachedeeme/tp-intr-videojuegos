package unq.videojuego.components.menus;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class Window extends GameComponent<VideojuegoScene> {
	private List<ListElement> elements;
	private String name;
	private int width;
	private int height;
	
	public Window(int x, int y, String name, int widht, int heigth) {
		super(x,y);
		this.width  = widht;
		this.height = heigth;
		this.setAppearance(Sprite.fromImage("/images/menuWindowBlue.png"));
		this.elements = new ArrayList<ListElement>();
	}
	
	public void addElement(ListElement element){
		this.elements.add(element);		
	}
	
	public void addAllElements(List<ListElement> elements){
		this.elements.addAll(elements);
	}
	
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
		for (ListElement element : this.elements) {
			element.render(graphics);
		}
	}
}
