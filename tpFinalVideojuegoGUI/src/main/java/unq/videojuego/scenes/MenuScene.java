package unq.videojuego.scenes;

import java.util.ArrayList;
import java.util.List;

import unq.videojuego.components.menus.BattleItemShowable;
import unq.videojuego.components.menus.ListElement;
import unq.videojuego.components.menus.Window;
import unq.videojuego.interfaces.Showable;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.items.Consumable;

public class MenuScene extends VideojuegoScene {
	private ListElement background;
	
	public MenuScene(int screenWidth, int screenHeight) {
		super(screenWidth, screenHeight);
		List<Showable> showables = new ArrayList<Showable>();
		showables.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables.add(new BattleItemShowable(new Consumable("MP Potion", 35, 1000)));
		showables.add(new BattleItemShowable(new Consumable("HP Potion", 99, 1000)));
		Window win = new Window(0, 0, ImageHandler.INSTANCE.getSprite("LongBlueWindow"), showables);
		this.addComponent(win);
		
	}
	
	public void initMenu(){
	}
	
	public void setBackground(ListElement background) {
		this.background = background;
		this.addComponent(background);
	}
}
