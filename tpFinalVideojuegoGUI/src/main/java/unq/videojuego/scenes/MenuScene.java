package unq.videojuego.scenes;

import java.awt.Color;

import unq.videojuego.components.Ornament;
import unq.videojuego.components.menus.Window;

import com.uqbar.vainilla.appearances.Rectangle;
import com.uqbar.vainilla.appearances.Sprite;

public class MenuScene extends VideojuegoScene {
	private Ornament background;
	
	public MenuScene(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
		this.setBackground(new Ornament(0, 0, -1, new Rectangle(Color.BLACK, 1000, 1000)));
		Window win = new Window(0, 0, Sprite.fromImage("/images/BlueWindow.png"));
		this.addComponent(win);
		win.placeWindow();
		/*/List<ListElement> elements = new ArrayList<ListElement>();
		ListElement dagger = new ListElement(20, 20, "/images/Dagger.png", "Iron Dagger");
		elements.add(dagger);
		elements.add(new ListElement(20, 20 + dagger.getHeight(), "/images/Dagger.png", "Iron Dagger"));
		elements.add(new ListElement(20, 20 + dagger.getHeight()*2, "/images/Dagger.png", "Iron Dagger"));
		elements.add(new ListElement(20, 20 + dagger.getHeight()*3, "/images/Dagger.png", "Iron Dagger"));
		this.addComponents(elements);*/
	}
	
	public void initMenu(){
	}
	
	public void setBackground(Ornament background) {
		this.background = background;
		this.addComponent(background);
	}
}
