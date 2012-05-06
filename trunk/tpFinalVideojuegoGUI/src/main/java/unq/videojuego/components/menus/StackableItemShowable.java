package unq.videojuego.components.menus;

import java.awt.Graphics2D;

import unq.videojuego.components.CounterOrnament;
import unq.videojuego.components.PictureOrnament;
import unq.videojuego.components.TextOrnament;
import unq.videojuego.interfaces.Showable;

import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.items.Stackable;

public class StackableItemShowable implements Showable{
	private int x;
	private int y;
	private Stackable item;
	private PictureOrnament picture;
	private TextOrnament text;
	private CounterOrnament amount;
	
	public StackableItemShowable(Stackable anItem) {
		this.item = anItem;
		this.picture = new PictureOrnament(0, 0, 0, ImageHandler.INSTANCE.getSprite(item.getName()));
		this.text = new TextOrnament(0, 0, 0, item.getName());
		this.amount = new CounterOrnament(0, 0, 0, item.getQuantity());
	}
	
	public void setX(int x, int windowWidth){
		//this.x = x;
		this.picture.setX(x);
		this.text.setX(x + this.picture.getWidth());
		
	}

	@Override
	public String getName() {
		return item.getName();
	}

	@Override
	public Showable getElement() {
		return this;
	}

	@Override
	public void render(Graphics2D graphics) {
		
	}

}
