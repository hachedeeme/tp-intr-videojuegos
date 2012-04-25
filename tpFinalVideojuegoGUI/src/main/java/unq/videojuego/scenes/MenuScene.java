package unq.videojuego.scenes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import unq.videojuego.components.Ornament;
import unq.videojuego.components.menus.ListElement;
import unq.videojuego.components.menus.Window;

import com.uqbar.vainilla.appearances.Rectangle;

public class MenuScene extends VideojuegoScene {
	private Ornament background;
	
	public MenuScene() {
		//this.setBackground(new Ornament(0, 0, 1, new Rectangle(Color.BLACK, 1000, 1000)));
		List<ListElement> elements = new ArrayList<ListElement>();
		Window win = new Window(10, 10, "Items", 300, 600);
		ListElement dagger = new ListElement(20, 20, "/images/Dagger.png", "Iron Dagger");
		elements.add(dagger);
		elements.add(new ListElement(20, 20 + dagger.getHeight(), "/images/Dagger.png", "Iron Dagger"));
		elements.add(new ListElement(20, 20 + dagger.getHeight()*2, "/images/Dagger.png", "Iron Dagger"));
		elements.add(new ListElement(20, 20 + dagger.getHeight()*3, "/images/Dagger.png", "Iron Dagger"));
		this.addComponent(win);
		this.addComponents(elements);
	}
	
	public void initMenu(){
	}
	
	public void setBackground(Ornament background) {
		this.background = background;
		this.addComponent(background);
	}
}
