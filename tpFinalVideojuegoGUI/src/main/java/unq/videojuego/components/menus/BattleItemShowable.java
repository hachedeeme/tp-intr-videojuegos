package unq.videojuego.components.menus;

import java.awt.Graphics2D;


import com.uqbar.vainilla.ImageHandler;
import com.uqbar.videojuego.items.Consumable;
import com.uqbar.videojuego.items.Stackable;


public class BattleItemShowable extends Showable{
	private double x;
	private double y;
	private Consumable item;
	private PictureElement picture;
	private TextElement text;
	private CounterElement amount;
	
	public BattleItemShowable(Consumable anItem) {
		this.item = anItem;
		this.picture = new PictureElement(0, 0, 0, ImageHandler.INSTANCE.getSprite(item.getName()));
		this.text = new TextElement(0, 0, 0, item.getName());
		this.amount = new CounterElement(0, 0, 0, item.getQuantity());
	}
	
	//***********************//
	//** GAME LOOP METHODS **//
	//***********************//
	@Override
	public void render(Graphics2D graphics) {
		this.picture.render(graphics);
		this.text.render(graphics);
		this.amount.render(graphics);		
	}
	
	//*************//
	//** METHODS **//
	//*************//
	public void setX(double start, double end){
		this.x = start;
		this.picture.setX(start);
		this.text.setX(start + this.picture.getWidth() + 5);
		this.amount.setX(end - this.amount.getWidth() - 15);
	}
	
	public void setY(double y){
		this.y = y;
		this.picture.setY(y-5);
		this.text.setY(y);
		this.amount.setY(y);
	}
	
	//**************//
	//** ACCESORS **//
	//**************//
	public Stackable getConsumableItem() {
		return this.item;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}


}
