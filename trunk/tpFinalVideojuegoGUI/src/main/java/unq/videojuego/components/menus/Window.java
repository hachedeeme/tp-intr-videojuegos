package unq.videojuego.components.menus;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import unq.videojuego.VideojuegoGame;
import unq.videojuego.interfaces.Showable;
import unq.videojuego.scenes.VideojuegoScene;

import com.uqbar.vainilla.GameComponent;
import com.uqbar.vainilla.appearances.Sprite;

public class Window extends GameComponent<VideojuegoScene> {
	private List<Showable> elements;
	private Pointer pointer;
	private Sprite image;
	
	public Window(int x, int y, Sprite image) {
		super(x,y);
		this.elements = new ArrayList<Showable>();
		this.image    = image;
		this.pointer  = new Pointer(x,y);
		this.setAppearance(image);
	}
	
	//***********************//
	//** GAME LOOP METHODS **//
	//***********************//
	@Override
	public void render(Graphics2D graphics) {
		super.render(graphics);
		for (Showable element : this.elements) {
			element.render(graphics);
		}
	}
	
	//*************//
	//** METHODS **//
	//*************//
	public void placeWindow(){
		this.setX(0);
		this.setY(this.getScene().getScreenHeight() - this.getHeight());
		//TODO Elimiar hardcode
	}
	
	public void placeWindow(int x, int y){
		this.setX(x);
		this.setY(y);
	}
	
	public int getHeight(){
		return (int) this.image.getHeight();
	}
	
	public int getWidth(){
		return (int) this.image.getWidth();
	}
	
	public int rigthBorder(){
		return (int) this.getX() + this.getWidth();
	}
	//**************//
	//** ACCESORS **//
	//**************//
	public void addElement(Showable element){
		this.elements.add(element);		
	}
	
	public void addAllElements(List<Showable> elements){
		this.elements.addAll(elements);
	}
	
	public Sprite getImage() {
		return image;
	}
	
	public Pointer getPointer() {
		return pointer;
	}
}
